package com.iutnc.geompaint.controller;

import java.awt.Point;

import com.iutnc.geompaint.exception.UnknownFigureException;
import com.iutnc.geompaint.model.Circle;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.model.Polygon;


/**
 * Permits to check if a coordinate is :
 * - near a Figure
 * - hover a Figure
 * @author François
 *
 */
public class FigureAnalyzer {
	
	//
	// ATTRIBUTES
	//	
	
	private int refX = 0;
	private int refY = 0;
	private int nearTolerence = 5;
	private int hoverTolerence = 0;

	
	//
	// CONSTRUCTORS
	//
	
	/**
	 * Constructor
	 * Default reference coordinates : position (0, 0)
	 * Default near tolerance : 5 pixels
	 * Default hover tolerance : 0 pixel
	 */
	public FigureAnalyzer() {
		
	}
	
	/**
	 * Constructor with coordinates
	 * @param refX X value used as reference for your tests
	 * @param refY Y value used as reference for your tests
	 * @param nearTolerence the tolerance for being near a Figure or Point (in pixels, min 1)
	 * @param hoverTolerence the tolerance for being hover a Figure or Point (in pixels, minimum 0)
	 */
	public FigureAnalyzer(int refX, int refY, int nearTolerence, int hoverTolerence) {
		setReferenceCoordinates(refX, refY);
		setNearTolerence(nearTolerence);
		setHoverTolerence(hoverTolerence);
	}
	
	
	//
	// PUBLIC METHODS
	//
	
	/**
	 * Sets the coordinate which will be the reference for tests isNearFigure() and isHoverFigure()
	 * @param refX X value used as reference for your tests
	 * @param refY Y value used as reference for your tests
	 */
	public void setReferenceCoordinates(int refX, int refY) {
		this.refX = refX;
		this.refY = refY;
	}
	
	
	/**
	 * Sets the tolerance for being near a Figure or Point
	 * @param tolerance in pixels, minimum 1
	 */
	public void setNearTolerence(int tolerance) {
		if (tolerance >= 1)
			this.nearTolerence = tolerance;
	}
	
	
	/**
	 * Sets the tolerance for being hover a Figure or Point
	 * @param tolerance in pixels, minimum 0
	 */
	public void setHoverTolerence(int tolerance) {
		if (tolerance >= 0)
			this.hoverTolerence = tolerance;
	}
	
	
	/**
	 * Checks if the reference coordinates are Near the Figure given in parameter with the tolerance fixed before
	 * @param f the Figure
	 * @return true if the reference is near the Figure (tolerance included), false otherwise
	 */
	public boolean isNearFigure(Figure f) {
		if (f == null) return false;
		
		boolean res = false;
		if (f instanceof Polygon) {
			res = isNearPolygon((Polygon) f);
		}
		else if (f instanceof Circle) {
			res = isNearCircle((Circle) f);
		}
		else {
			try {
				throw new UnknownFigureException();
			} catch (UnknownFigureException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	/**
	 * Checks if the reference coordinates are Near the Point given in parameter with the tolerance fixed before
	 * @param p the Point
	 * @return true if the reference is near the Point (tolerance included), false otherwise
	 */
	public boolean isNearPoint(Point p) {
		return refX + nearTolerence > p.x
			&& refX - nearTolerence < p.x
			&& refY + nearTolerence > p.y
			&& refY - nearTolerence < p.y;
	}
	
	//
	// PRIVATE METHODS
	//
	
	/**
	 * Checks if the reference coordinates are Near the Circle given in parameter with the tolerance fixed before
	 * @param c the Circle
	 * @return true if the reference is near the Circle (tolerance included), false otherwise
	 */
	private boolean isNearCircle(Circle c) {
		// TODO isNearCircle()
		return false;
	}
	
	/**
	 * Checks if the reference coordinates are Near the Polygon given in parameter with the tolerance fixed before
	 * @param p the Polygon
	 * @return true if the reference is near the Polygon (tolerance included), false otherwise
	 */
	private boolean isNearPolygon(Polygon p) {
		// TODO isNearPolygon()
		return false;
	}
}
