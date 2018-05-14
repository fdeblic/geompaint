package com.iutnc.geompaint.controller;

import java.awt.Color;
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
	
	public void addFigure(Figure f) {
		if (f.isValid())
			drawing.addFigure(f);
	}
	
	public void fillFigure(Figure f, boolean filled) {
		f.setFilled(filled);
	}
	
	public void changeFigureColor(Figure f, Color newColor) {
		
	}
	
	/**
	 * Handler for the clone button
	 */
	public Figure cloneFigure(Figure f) {
		Figure fig2 = f.getCopie();
		fig2.translate(15, 15);
		drawing.addFigure(fig2);
		return fig2;
	}
	
	/**
	 * Handler for the delete button
	 */
	public void deleteFigure() {
		
	}
	
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
