package com.iutnc.geompaint.view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * Class for canvas
 * @author Elise
 * @version 09/05/2018
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener{
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
	public Canvas(Figure selectedFigure, Point movingPoint) {
		super();
		this.selectedFigure = selectedFigure;
		this.movingPoint = movingPoint;
	}

	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	public void setSelectedFigure(Figure selectedFigure) {
		this.selectedFigure = selectedFigure;
	}
	
	/**
	 * Draw a figure in the JPanel
	 * @param f the figure to draw
	 */
	public void drawFigure(Figure f) {}
	
	/**
	 * Draw a polygon in the JPanel
	 * @param p the polygon to draw
	 */
	public void drawPolygon(Polygon p) {}
	
	/**
	 * Draw a circle in the JPanel
	 * @param c the circle to draw
	 */
	public void drawCircle(Circle c) {}
	
	/**
	 * Draw a point in the JPanel
	 * @param p the point to draw
	 */
	public void drawPoint(Point p) {}
	
	/**
	 * The figure is hover
	 * @param f the figure you want to check
	 * @return True if the figure is hover
	 */
	public boolean isHover(Figure f) {
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

}
