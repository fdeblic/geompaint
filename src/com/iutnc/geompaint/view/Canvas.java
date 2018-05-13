package com.iutnc.geompaint.view;
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
	private GeomPaintController controller;
	private FigureDrawer drawer;
	private FigureAnalyzer analyzer;
	private ArrayList<Figure> figures;
	private Figure selectedFigure;
	private Point movingPoint;
	
		
	/**
	 * Canvas Constructor
	 * @param selectedFigure the selected figure, you want to modify
	 * @param movingPoint the point to move a figure
	 */
	public Canvas(GeomPaintController controller) {
		super();
	}
	
	/**
	 * Add figure to figures's list
	 * @param f the figure to add
	 */
	public void addFigure(Figure f){
		figures.add(f);
	}

	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	public boolean isSelected(Figure f) {
		return false;
	}
	
	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	private boolean isSelected(Point p) {
		return false;
	}
	
	
	/**
	 * The figure is hover
	 * @param f the figure you want to check
	 * @return True if the figure is hover
	 */
	private boolean isHover(Figure f) {
		return false; 
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg0) {}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
