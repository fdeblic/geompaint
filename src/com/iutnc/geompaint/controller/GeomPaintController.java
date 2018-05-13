package com.iutnc.geompaint.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.view.Canvas;
import com.iutnc.geompaint.view.GeomPaintFrame;
import com.iutnc.geompaint.view.IGeomPaintView;
import com.iutnc.geompaint.view.MenuAdd;
import com.iutnc.geompaint.view.MenuEdit;

/**
 * Controller of the GeomPaint program
 * @author francois
 *
 */
public class GeomPaintController {
	
	// ATTRIBUTES

	private IGeomPaintView view;
	private State state;
	
	// CONSTRUCTOR
	
	/**
	 * Constructor
	 */
	public GeomPaintController(IGeomPaintView view) {
		if (view != null) {
			this.view = view;
		} else {
			this.view = new GeomPaintFrame();
		}
		state = State.NORMAL;
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
	public void moveFigure(Figure f, int x, int y) {
		if (f != null) f.translate(x, y);
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
	

	/**
	 * Launches the program
	 */
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	// GETTER - SETTER
	
	
	// PRIVATE METHODS
	
	private void updateButtons() {
		
	}
	
}
