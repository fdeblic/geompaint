package com.iutnc.geompaint.controller;

import java.awt.Point;
import com.iutnc.geompaint.model.Drawing;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.view.IGeomPaintView;

/**
 * Controller of the GeomPaint program
 * @author francois
 *
 */
public class GeomPaintController {
	
	// ATTRIBUTES

	private IGeomPaintView view;
	private Drawing drawing;
	
	// CONSTRUCTOR
	
	/**
	 * Constructor
	 */
	public GeomPaintController() {
		drawing = new Drawing();
	}
	
	// BUTTON HANDLERS

	/**
	 * Handler for the circle button
	 */
	public void createCircle() {
	}
	
	/**
	 * Handler for the polygon button
	 */
	public void createPolygon() {
		
	}
	
	/**
	 * Handler for the rectangle button
	 */
	public void createRectangle() {
		
	}
	
	/**
	 * Handler for the triangle button
	 */
	public void createTriangle() {
		
	}
	
	/**
	 * Handler for the fill_figure button
	 */
	public void fillFigure() {
		
	}
	
	/**
	 * Handler for the color button
	 */
	public void changeFigureColor() {
		
	}
	
	/**
	 * Handler for the clone button
	 */
	public void cloneFigure() {
		
	}
	
	/**
	 * Handler for the delete button
	 */
	public void deleteFigure() {
		
	}
	
	// ACTIONS HANDLER

	/**
	 * Moves a Figure at the given position
	 * @param f the Figure to move
	 * @param x the x position to set
	 * @param y the y position to set
	 */
	public boolean moveFigure(Figure f, int x, int y) {
		if (f != null) {
			f.translate(x, y);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Moves a Figure at the given position
	 * @param p the Point to move
	 * @param x the x position to set
	 * @param y the y position to set
	 */
	public boolean movePoint(Point p, int x, int y) {
		if (p != null) {
			p.translate(x, y);
			return true;
		} else {
			return false;
		}
	}
	
	// GETTERS
	
	public Figure[] getFigures() {
		return drawing.getFigures().toArray(new Figure[drawing.getFigures().size()]);
	}
}
