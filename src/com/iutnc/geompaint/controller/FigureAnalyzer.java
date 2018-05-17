package com.iutnc.geompaint.controller;

import java.awt.Point;

import com.iutnc.geompaint.exception.UnknownFigureException;
import com.iutnc.geompaint.model.Circle;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.model.Polygon;


/**
 * Permits to check if a coordinate is hover a Figure
 * @author François
 *
 */
public class FigureAnalyzer {
	
	//
	// ATTRIBUTES
	//	
	
	private Point ref = new Point(0, 0);
	private int tolerance = 5;

	
	//
	// CONSTRUCTORS
	//
	
	/**
	 * Constructor
	 * Default reference coordinates : position (0, 0)
	 * Default tolerance : 5 pixels
	 */
	public FigureAnalyzer() {
		
	}
	
	/**
	 * Constructor with coordinates
	 * @param refX X value used as reference for your tests
	 * @param refY Y value used as reference for your tests
	 * @param tolerance the tolerance for being hover a Figure or Point (in pixels, minimum 1)
	 */
	public FigureAnalyzer(int refX, int refY, int tolerance) {
		setRef(refX, refY);
		setTolerance(tolerance);
	}
	
	
	//
	// PUBLIC METHODS
	//
	
	/**
	 * Sets the coordinate which will be the reference for tests isNearFigure() and isHoverFigure()
	 * @param refX X value used as reference for your tests
	 * @param refY Y value used as reference for your tests
	 */
	public void setRef(int refX, int refY) {
		ref.x = refX;
		ref.y = refY;
	}
	
	
	/**
	 * Sets the tolerance for being hover a Figure or Point
	 * @param tolerance in pixels, minimum 1
	 */
	public void setTolerance(int tolerance) {
		if (tolerance >= 1)
			this.tolerance = tolerance;
	}
	
	
	/**
	 * Checks if the reference coordinates are hover the Figure given in parameter with the tolerance fixed before
	 * @param f the Figure
	 * @return true if the reference is hover the Figure (tolerance included), false otherwise
	 */
	public boolean isHoverFigure(Figure f) {
		if (f == null || !f.isValid()) return false;
		
		boolean res = false;
		if (f instanceof Polygon) {
			res = isOnPolygon((Polygon) f, tolerance);
		}
		else if (f instanceof Circle) {
			res = isOnCircle((Circle) f, tolerance);
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
	 * Checks if the reference coordinates are hover the Point given in parameter with the tolerance fixed before
	 * @param p the Point
	 * @return true if the reference is hover the Point (tolerance included), false otherwise
	 */
	public boolean isHoverPoint(Point p) {
		return ref.x + tolerance >= p.x
			&& ref.x - tolerance <= p.x
			&& ref.y + tolerance >= p.y
			&& ref.y - tolerance <= p.y;
	}
	
	//
	// GETTERS
	//
	
	public int getTolerence() {
		return tolerance;
	}
	
	public int getRefX() {
		return ref.x;
	}
	
	public int getRefY() {
		return ref.y;
	}
	
	//
	// PRIVATE METHODS
	//
	
	/**
	 * Checks if the reference coordinates are on the Circle given in parameter with the tolerance fixed before
	 * @param c the Circle
	 * @param tolerance the tolerance in pixels
	 * @return true if the reference is on the Circle (tolerance included), false otherwise
	 */
	private boolean isOnCircle(Circle c, int tolerance) {
		int x, y;
		Point centre = c.getCentre();

		x = ref.x - centre.x;
		y = ref.y - centre.y;

		// Calculates the complex module : |z| = sqrt(a*a + b*b)
		int z = (int) Math.sqrt(x*x + y*y);

		if (c.isFilled())
			return c.getRadius() + tolerance >= z;
		else
			return c.getRadius() + tolerance >= z && c.getRadius() - tolerance <= z;
	}
	
	/**
	 * Checks if the reference coordinates are on the Polygon given in parameter
	 * @param p the Polygon
	 * @param tolerance the tolerence in pixels
	 * @return true if the reference is on the Polygon (tolerance included), false otherwise
	 */
	private boolean isOnPolygon(Polygon p, int tolerance) {
		if (p.isFilled()) {
			java.awt.Polygon polygon = new java.awt.Polygon();
			for (Point pt : p.getPoints())
				polygon.addPoint(pt.x, pt.y);
			for (int x = ref.x - tolerance ; x <= ref.x + tolerance ; x++) {
				for (int y = ref.y - tolerance ; y <= ref.y + tolerance ; y++) {
					if (polygon.contains(new Point(x, y)))
						return true;
				}
			}
			return false;
		} else {
			Point[] pts = p.getPoints();
			boolean res = false;
			for (int i = 0 ; i < pts.length ; i++) {
				if (i == 0) {
					if (isOnLine(pts[i] , pts[pts.length-1], tolerance)) {
						res = true;
					}
				} else {
					if (isOnLine(pts[i-1] , pts[i], tolerance)) {
						res = true;
					}
				}
			}
			return res;
		}
	}
	
	/**
	 * Checks if the reference coordinates are on the segment between p1 and p2
	 * @param p1 first point of the segment
	 * @param p2 second point of the segment
	 * @param tolerance the tolerance in pixels
	 * @return true if the reference is on the line (tolerance included), false otherwise
	 */
	private boolean isOnLine(Point p1, Point p2, int tolerance) {
		if (ref.x + tolerance <= p1.x && ref.x + tolerance <= p2.x) return false;
		if (ref.x - tolerance >= p1.x && ref.x - tolerance >= p2.x) return false;
		if (ref.y + tolerance <= p1.y && ref.y + tolerance <= p2.y) return false;
		if (ref.y - tolerance >= p1.y && ref.y - tolerance >= p2.y) return false;
		
		// https://stackoverflow.com/questions/30559799/function-for-finding-the-distance-between-a-point-and-an-edge-in-java
		int A = ref.x - p1.x; // position of point rel one end of line
		int B = ref.y - p1.y;
		int C = p2.x - p1.x; // vector along line
		int D = p2.y - p1.y;
		int E = -D; // orthogonal vector
		int F = C;
		
		float dot = A * E + B * F;
		float len_sq = E * E + F * F;
		
		return (float) (Math.abs(dot) / Math.sqrt(len_sq)) <= tolerance;
	}
}
