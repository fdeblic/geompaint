package com.iutnc.geompaint.controller;

import java.awt.Color;
import java.awt.Point;

import com.iutnc.geompaint.model.Drawing;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.view.GeomPaintFrame;
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
		if (f.isValid()) {
			drawing.addFigure(f);
			f.addObserver(view.getObserver());
		}
	}
	
	public void fillFigure(Figure f, boolean filled) {
		if (f != null)
			f.setFilled(filled);
	}
	
	public void changeFigureColor(Figure f, Color newColor) {
		if (f != null)
			f.setColor(newColor);
	}
	
	public Figure cloneFigure(Figure f) {
		if (f == null || !f.isValid()) return null;
		Figure fig2 = f.getCopie();
		fig2.translate(15, 15);
		addFigure(fig2);
		return fig2;
	}
	
	public void deleteFigure(Figure f) {
		if (f != null)
			drawing.removeFigure(f);
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
			p.setLocation(x, y);
			return true;
		} else {
			return false;
		}
	}
	
	// GETTERS
	
	public Figure[] getFigures() {
		return drawing.getFigures().toArray(new Figure[drawing.getFigures().size()]);
	}

	public void setView(IGeomPaintView view) {
		this.view = view;
		drawing.addObserver(view.getObserver());
	}
}
