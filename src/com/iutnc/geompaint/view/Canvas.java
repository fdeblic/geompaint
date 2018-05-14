package com.iutnc.geompaint.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.iutnc.geompaint.controller.FigureAnalyzer;
import com.iutnc.geompaint.controller.GeomPaintController;
import com.iutnc.geompaint.controller.State;
import com.iutnc.geompaint.model.*;

/**
 * Class for canvas
 * @author Elise
 * @version 09/05/2018
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener, Observer {

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
		// TODO tester par rapport Ã  l'attribut movingPoint
		return false;
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
		Figure[] figures = frame.getFigures();
		FigureDrawer fgD =  new FigureDrawer(this);
		if (figures == null)
			return;
		/*
		 * Draw every figures in the array
		 */
		for (int i = 0; i < figures.length; i++){
			fgD.drawFigure(figures[i], g);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO dÃ©placement du point en cours ou de la figure
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
		if (this.state == State.NORMAL){
			Figure[] figures = frame.getFigures();
			analyzer.setRef(e.getX(), e.getY());
			for (int i = 0; i < figures.length; i++) {
				if (analyzer.isHoverFigure(figures[i])) {
					this.selectedFigure = figures[i];
				}
			}
			repaint();
		}
		else if (this.state == State.DRAWING) {
			if (!this.selectedFigure.isFull()){
				Point p = new Point(e.getX(), e.getY());
				this.selectedFigure.addGripPoint(p);
			}
			if (selectedFigure.isFull()){
				frame.saveFigure(this.selectedFigure);
			}
			repaint();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public void setState(State state) {
		this.state = state;
		
	}

}
