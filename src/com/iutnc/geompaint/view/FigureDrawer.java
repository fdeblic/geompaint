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
		if (f == null) return;
		boolean selected = context.isSelected(f);
		boolean hovered = context.isHovered(f);
		
		// Color of the figure
		g.setColor(f.getBorderColor());

		// Draws the figure
		if (f instanceof Polygon) {
			this.drawPolygon((Polygon)f,g);
		} else if (f instanceof Circle) {
			this.drawCircle((Circle)f, g);
		}
		
		// If hovered, draws a border
		if (!selected && hovered) {
			g.setColor(Color.GREEN);
			boolean filled = f.isFilled();
			f.setFilled(false);
			if (f instanceof Polygon) {
				this.drawPolygon((Polygon)f,g);
			} else if (f instanceof Circle) {
				this.drawCircle((Circle)f, g);
			}
			f.setFilled(filled);
		}
	}
	
	/**
	 * Draw a polygon in the JPanel
	 * @param p the polygon to draw
	 */
	private void drawPolygon(Polygon p, Graphics g) {
		if (p == null || !p.isValid()) return;
		Point[] points = p.getPoints();
		int[] pointX = new int[points.length];
		int[] pointY = new int[points.length];
		for (int i = 0; i < points.length; i++){
			pointX[i] = points[i].x;
			pointY[i] = points[i].y;
		}

		if (p.isFilled()){
			g.setColor(p.getFillColor());
			g.fillPolygon(pointX, pointY, points.length);
		}
		g.setColor(p.getBorderColor());
		if (points.length > 2)
			g.drawPolygon(pointX, pointY, points.length);
		else
			g.drawPolyline(pointX, pointY, points.length);
	}
	
	/**
	 * Draw a circle in the JPanel
	 * If selected, draw the grip points
	 * @param c the circle to draw
	 */
	private void drawCircle(Circle c, Graphics g) {
		if (c == null || !c.isValid()) return;
		Point centre = c.getCentre();
		int radius = c.getRadius();
		if (c.isFilled()) {
			g.setColor(c.getFillColor());
			g.fillOval(centre.x-radius, centre.y-radius, radius*2, radius*2);
		}
		g.setColor(c.getBorderColor());
		g.drawOval(centre.x-radius, centre.y-radius, radius*2, radius*2);
	}
	
	/**
	 * Draw multiple points from an array
	 * @param pts
	 * @param g
	 */
	public void drawPoints(Point[] pts, Graphics g){
		for (int i = 0; i < pts.length; i++){
			drawPoint(pts[i], g);
		}
	}
	
	/**
	 * Draw a point in the JPanel
	 * @param p the point to draw
	 */
	private void drawPoint(Point p, Graphics g) {
		int r = 4; // pixels
		g.setColor(Color.white);
		g.fillRect(p.x-r, p.y-r, 2*r, 2*r);
		g.setColor(Color.black);
		g.drawRect(p.x-r, p.y-r, 2*r, 2*r);
	}
	
}
