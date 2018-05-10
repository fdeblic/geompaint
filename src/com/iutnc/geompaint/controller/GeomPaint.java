package com.iutnc.geompaint.controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.view.Canvas;
import com.iutnc.geompaint.view.MenuAdd;
import com.iutnc.geompaint.view.MenuEdit;

/**
 * Controller of the GeomPaint program
 * @author francois
 *
 */
public class GeomPaint {
	
	// ATTRIBUTES

	private MenuEdit menuEdit;
	private MenuAdd menuAdd;
	private Canvas canvas;
	private ArrayList<Figure> figures;
	private State state;
	
	// CONSTRUCTOR
	
	/**
	 * Constructor
	 */
	public GeomPaint() {
		// TODO Auto-generated constructor stub
		figures = new ArrayList<>();
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
	
	// CANVAS HANDLER

	
	/**
	 * Calculates if a figure/point/blank was clicked
	 * and acts in function (adds a new point, selects a figure)
	 */
	public void canvasClicked(MouseEvent e) {
		
	}
	
	/**
	 * Calculates if a figure/point/blank was clicked
	 * and acts in function (adds a new point, selects a figure)
	 */
	public void canvasDragged(MouseEvent e) {
		
	}
	
	/**
	 * Cancels the current action (dragging, drawing new Figure, ...)
	 */
	public void cancelAction() {
		
	}
	
	// GETTER - SETTER
	
	public Figure[] getFigures() {
		return figures.toArray(new Figure[figures.size()]);
	}
}
