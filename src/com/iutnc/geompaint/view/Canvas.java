package com.iutnc.geompaint.view;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

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
	
	private Figure selectedFigure;
	private Point movingPoint;
		
	/**
	 * Canvas Constructor
	 * @param selectedFigure the selected figure, you want to modify
	 * @param movingPoint the point to move a figure
	 */
	public Canvas() {
		super();
	}

	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	private void setSelectedFigure(Figure selectedFigure) {
		this.selectedFigure = selectedFigure;
	}
	
	/**
	 * Draw a figure in the JPanel
	 * @param f the figure to draw
	 */
	private void drawFigure(Figure f) {}
	
	/**
	 * Draw a polygon in the JPanel
	 * @param p the polygon to draw
	 */
	private void drawPolygon(Polygon p) {}
	
	/**
	 * Draw a circle in the JPanel
	 * @param c the circle to draw
	 */
	private void drawCircle(Circle c) {}
	
	/**
	 * Draw a point in the JPanel
	 * @param p the point to draw
	 */
	private void drawPoint(Point p) {}
	
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
