package com.iutnc.geompaint.view;

import java.awt.Color;
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

	private Point movingPoint;
	private State state;
	private String hintMessage = "";
		
	/**
	 * Canvas Constructor
	 * @param selectedFigure the selected figure, you want to modify
	 * @param movingPoint the point to move a figure
	 */
	public Canvas(GeomPaintFrame frame) {
		super();
		this.frame = frame; 
		state = State.NORMAL;
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
		this.selectedFigure = f;
	}
	
	
	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	public boolean isSelected(Figure f) {
		return f == selectedFigure;
	}
	
	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	private boolean isSelected(Point p) {
		return p == movingPoint;
	}
	
	
	/**
	 * The figure is hover
	 * @param f the figure you want to check
	 * @return True if the figure is hover
	 */
	private boolean isHover(Figure f) {
		// TODO appel Ã  FigureAnalyzer
		return false;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Figure[] figures = frame.getFigures();
		FigureDrawer fgD =  new FigureDrawer(this);
		if (figures == null)
			return;
		/*
		 * Draw every figures in the array
		 */
		for (int i = 0; i < figures.length; i++)
			if (!isSelected(figures[i]))
				fgD.drawFigure(figures[i], g);
		fgD.drawFigure(getSelectedFigure(), g);
		
		if (state == State.DRAWING && !hintMessage.equals("")) {
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
				frame.moveFigure(this.selectedFigure,e.getX(),e.getY());
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO changer le style de la figure qui est survolÃ©e
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
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (this.state == State.NORMAL){
				Figure[] figures = frame.getFigures();
				analyzer.setRef(e.getX(), e.getY());
				for (int i = 0; i < figures.length; i++) {
					if (analyzer.isHoverFigure(figures[i])) {
						this.selectedFigure = figures[i];
					}
				}
			}
			else if (this.state == State.DRAWING) {
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
		} else {
			movingPoint = null;
			selectedFigure = null;
			setState(State.NORMAL);
			repaint();
		}
	}
	
	private void cancelDrawing() {
		movingPoint = null;
		selectedFigure = null;
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
				frame.enableEdition(false);
				setHintMessage("Cliquez pour ajouter des points");
				repaint();
				break;
			default:
				frame.enableAdding(true);
				frame.enableEdition(true);
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
