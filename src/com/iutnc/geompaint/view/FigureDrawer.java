package com.iutnc.geompaint.view;

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
	private void drawPolygon(Polygon p, Graphics g) {}
	
	/**
	 * Draw a circle in the JPanel
	 * @param c the circle to draw
	 */
	private void drawCircle(Circle c, Graphics g) {}
	
	/**
	 * Draw a point in the JPanel
	 * @param p the point to draw
	 */
	private void drawPoint(Point p, Graphics g) {}
	
}
