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
	 * 
	 * @param selectedFigure
	 * @param movingPoint
	 */
	public Canvas(Figure selectedFigure, Point movingPoint) {
		super();
		this.selectedFigure = selectedFigure;
		this.movingPoint = movingPoint;
	}

	/**
	 * Figure selected to set
	 * @param selectedFigure
	 */
	public void setSelectedFigure(Figure selectedFigure) {
		this.selectedFigure = selectedFigure;
	}
	
	/**
	 * Draw a figure in the JPanel
	 * @param f
	 */
	public void drawFigure(Figure f) {}
	
	/**
	 * Draw a polygon in the JPanel
	 * @param p
	 */
	public void drawPolygon(Polygon p) {}
	
	/**
	 * Draw a circle in the JPanel
	 * @param c
	 */
	public void drawCircle(Circle c) {}
	
	/**
	 * Draw a point in the JPanel
	 * @param p
	 */
	public void drawPoint(Point p) {}
	
	/**
	 * The figure is hover
	 * @param f
	 * @return True if the figure is hover
	 */
	public boolean isHover(Figure f) {}

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
