package com.iutnc.geompaint.model;

import java.awt.Point;

/**
*
* @author Loic Spacher
*
**/

public class Rectangle extends Polygon{

	public Rectangle() {
		super();
	}
	
	@Override
	public Rectangle getCopie() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isFull() {
		return this.gripPoints.size()==2;
		
	}
	public boolean isValid() {
		return this.isFull();
		
	}/**
	 * Return all the points to draw
	 * @return Points
	 */
	public Point[] getPoints() {
		if (!isValid()) return new Point[]{};
		Point[] pts = new Point[4];
		Point pt1, pt2;
		pt1 = gripPoints.get(0);
		pt2 = gripPoints.get(1);
		pts[0] = pt1;
		pts[1] = new Point(pt2.x, pt1.y);
		pts[2] = pt2;
		pts[3] = new Point(pt1.x, pt2.y);
		return pts;
	}

}
