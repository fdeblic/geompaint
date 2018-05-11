package com.iutnc.geompaint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.iutnc.geompaint.model.Circle;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.model.Polygon;

public class FigureDrawer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8290765604021368933L;
	
	public FigureDrawer(JPanel context) {
		super();
		this.context = context;
	}

	private JPanel context;
	
	/**
	 * Draw a figure in the JPanel
	 * @param f the figure to draw
	 */
	public void drawFigure(Figure f, Graphics g) {}
	
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
	 * @param c the circle to draw
	 */
	private void drawCircle(Circle c, Graphics g) {
		Point centre = c.getCentre();
		g.setColor(c.getColor());
		g.drawOval(centre.x, centre.y, c.getRadius(), c.getRadius());
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
