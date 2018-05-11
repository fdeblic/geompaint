package com.iutnc.geompaint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.iutnc.geompaint.model.Circle;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.model.Polygon;

public class FigureDrawer {
	/**
	 * Attributes
	 */
	private Canvas context;
	
	public FigureDrawer(Canvas context) {
		super();
		this.context = context;
	}
	
	/**
	 * Draw a figure in the JPanel
	 * @param f the figure to draw
	 */
	public void drawFigure(Figure f, Graphics g) {
		if (f == null){return;}
		if (f instanceof Polygon ) this.drawPolygon((Polygon)f,g);
		if (f instanceof Circle) this.drawCircle((Circle)f, g);
	}
	
	/**
	 * Draw a polygon in the JPanel
	 * @param p the polygon to draw
	 */
	private void drawPolygon(Polygon p, Graphics g) {
		g.setColor(p.getColor());
		Point[] points = p.getPoints();
		int[] pointX = {};
		int[] pointY = {};
		for (int i = 0; i < points.length; i++){
			pointX[i] = points[i].x;
			pointY[i] = points[i].y;
		}
		g.drawPolygon(pointX, pointY, points.length);
	}
	
	/**
	 * Draw a circle in the JPanel
	 * If selected, draw the grip points
	 * @param c the circle to draw
	 */
	private void drawCircle(Circle c, Graphics g) {
		Point centre = c.getCentre();
		int radius = c.getRadius(); 
		g.setColor(c.getColor());
		g.drawOval(centre.x, centre.y, c.getRadius(), c.getRadius());
		if (context.isSelected(c)){
			Point[] pts = {new Point(centre.x+radius, centre.y), centre};
			drawPoints(pts,g);
		}
	}
	
	/**
	 * Draw multiple points from an array
	 * @param pts
	 * @param g
	 */
	private void drawPoints(Point[] pts, Graphics g){
		for (int i = 0; i < pts.length; i++){
			drawPoint(pts[i], g);
		}
	}
	
	/**
	 * Draw a point in the JPanel
	 * @param p the point to draw
	 */
	private void drawPoint(Point p, Graphics g) {
		g.setColor(Color.black);
		g.drawRect(p.x-1, p.y-1, 2, 2);
	}
	
}
