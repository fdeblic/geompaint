package com.iutnc.geompaint.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.iutnc.geompaint.controller.FigureAnalyzer;
import com.iutnc.geompaint.controller.State;
import com.iutnc.geompaint.model.*;

/**
 * Class for canvas
 * @author Elise
 * @version 09/05/2018
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener, Observer, KeyListener {

	/**
	 * Attributs
	 */
	private static final long serialVersionUID = 3407451406157270690L;
	private GeomPaintFrame frame;
	private FigureDrawer drawer;
	private FigureAnalyzer analyzer;
	private Figure selectedFigure;
	private Figure hoveredFigure;

	private Point movingPoint;
	private State state;
	private String hintMessage = "";
	private int lastX ;
	private int lastY;
		
	/**
	 * Canvas Constructor
	 * @param selectedFigure the selected figure, you want to modify
	 * @param movingPoint the point to move a figure
	 */
	public Canvas(GeomPaintFrame frame) {
		super();
		this.frame = frame; 
		state = State.NORMAL;
		drawer = new FigureDrawer(this);
		setBackground(Color.white);
		analyzer = new FigureAnalyzer();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
	}
	
	/**
	 * Get the figure selected
	 * @return the figure selected
	 */
	public Figure getSelectedFigure() {
		return selectedFigure;
	}
	
	public void setSelectedFigure(Figure f) {
		selectedFigure = f;
		if (frame != null)
			frame.enableEdition(f != null && f.isValid());
	}
	
	
	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	public boolean isSelected(Figure f) {
		return f == selectedFigure;
	}
	
	public boolean isHovered(Figure f) {
		return f == hoveredFigure;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2, BasicStroke.JOIN_ROUND, BasicStroke.CAP_ROUND, 0f));
		
		Figure[] figures = frame.getFigures();
		if (figures == null)
			return;
		/*
		 * Draw every figures in the array
		 */
		for (int i = 0; i < figures.length; i++)
			if (!isSelected(figures[i]))
				drawer.drawFigure(figures[i], g);
		drawer.drawFigure(getSelectedFigure(), g);
		
		if (state == State.DRAWING && !hintMessage.equals("")) {
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			g.setFont(new Font("verdana", Font.BOLD, 18));
			FontMetrics metrics = g.getFontMetrics(g.getFont());
		    int x = 0 + (getWidth() - metrics.stringWidth(hintMessage)) / 2;
			g.setColor(Color.LIGHT_GRAY);
			g.drawString(hintMessage, x, getHeight()-50);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)){
			if (this.state == State.NORMAL){
				if (movingPoint == null){
					int newPointx = e.getX() - lastX;
					int newPointy = e.getY() - lastY;
					frame.moveFigure(this.selectedFigure, newPointx, newPointy);
				}
				else {
					frame.movePoint(movingPoint, e.getX(), e.getY());
					repaint();
				}
				lastX = e.getX(); 
				lastY = e.getY();
			}
		}		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(this.state == State.NORMAL) {
			Figure[] figures = frame.getFigures();
			hoveredFigure = null;
			analyzer.setRef(e.getX(), e.getY());
			for (int i = 0; i < figures.length; i++) {
				if (analyzer.isHoverFigure(figures[i])) {
					this.hoveredFigure = figures[i];
				}
			}
			Cursor cursor = getCursor();// Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
			
			// Cursor
			if (hoveredFigure != null)
				cursor = new Cursor(Cursor.MOVE_CURSOR);
			else
				cursor = new Cursor(Cursor.DEFAULT_CURSOR);
			
			
			if (this.selectedFigure != null) {
				Point[] pts = this.selectedFigure.getGripPoints();
				for (int i = 0 ; i < pts.length; i ++){
					if (analyzer.isHoverPoint(pts[i])){
						cursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
						break;
					}
				}
			}

			// Updates the cursor if changed
			if (getCursor().getType() != cursor.getType())
				setCursor(cursor);
		}
		
		frame.movePoint(movingPoint, e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			lastX = e.getX();
			lastY = e.getY();
			
			if (this.state == State.NORMAL){
				Figure[] figures = frame.getFigures();
				
				// Where is the point ?
				if (this.selectedFigure != null) {
					analyzer.setRef(lastX, lastY);
					Point[] pts = this.selectedFigure.getGripPoints();
					movingPoint = null;
					for (int i = 0 ; i < pts.length; i ++){
						if (analyzer.isHoverPoint(pts[i])){
							movingPoint = pts[i];
						}					
					}
				}
				
				if (movingPoint == null) {
					setSelectedFigure(null);
					analyzer.setRef(e.getX(), e.getY());
					for (int i = 0; i < figures.length; i++) {
						if (analyzer.isHoverFigure(figures[i])) {
							setSelectedFigure(figures[i]);
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {			
			if (this.state == State.DRAWING) {
				setHintMessage("");
				if (!this.selectedFigure.isFull()){
					if (movingPoint == null)
						this.selectedFigure.addGripPoint(new Point(e.getX(), e.getY()));
					movingPoint = new Point(e.getX(), e.getY());
					this.selectedFigure.addGripPoint(movingPoint);
				}
				else if (selectedFigure.isFull()){
					saveFigure();
				}
			} else {
				movingPoint = null;
			}
		} else if (SwingUtilities.isRightMouseButton(e)) {
			saveFigure();
		}
		repaint();
	}
	
	private void saveFigure() {
		if (selectedFigure == null)
			return;
		
		// If the figure is a polygon, we remove the moving point of it
		if(selectedFigure.getClass().equals(Polygon.class))
			selectedFigure.removeGripPoint(movingPoint);
		
		if (selectedFigure.isValid()) {
			movingPoint = null;
			frame.saveFigure(this.selectedFigure);
			frame.enableEdition(true);
		} else {
			movingPoint = null;
			setSelectedFigure(null);
			setState(State.NORMAL);
			repaint();
		}
	}
	
	public void cancelDrawing() {
		movingPoint = null;
		setSelectedFigure(null);
		setState(State.NORMAL);
		repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public void setState(State state) {
		this.state = state;
		switch (state) {
			case DRAWING:
				frame.enableAdding(false);
				setHintMessage("Cliquez pour ajouter des points");
				repaint();
				break;
			default:
				frame.enableAdding(true);
				break;
		}
	}
	
	public void setHintMessage(String hint) {
		this.hintMessage = hint;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				cancelDrawing();
				break;
			case KeyEvent.VK_ENTER:
				saveFigure();
				break;
		}
	}
}
