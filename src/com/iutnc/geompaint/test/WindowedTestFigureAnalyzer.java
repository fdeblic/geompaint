package com.iutnc.geompaint.test;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import com.iutnc.geompaint.controller.FigureAnalyzer;
import com.iutnc.geompaint.model.Circle;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.model.Polygon;
import com.iutnc.geompaint.model.Triangle;

import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class WindowedTestFigureAnalyzer {
	
	private class Figures extends JPanel implements MouseMotionListener {
		Figure figHover = null;
		Figure figNear = null;
		FigureAnalyzer analyzer;
		
		Circle circle = new Circle(new Point(50, 50), new Point(50, 75));
		ArrayList<Polygon> polygons = new ArrayList<Polygon>();
		
		public Figures(int hoverTolerance, int nearTolerance) {
			analyzer = new FigureAnalyzer();
			analyzer.setHoverTolerence(hoverTolerance);
			analyzer.setNearTolerence(nearTolerance);
			
			Polygon line = new Polygon();
			line.addGripPoint(new Point(90, 25));
			line.addGripPoint(new Point(90, 75));
			
			Polygon triangle = new Polygon();
			triangle.addGripPoint(new Point(100,  25));
			triangle.addGripPoint(new Point(150,  25));
			triangle.addGripPoint(new Point(150,  75));
			
			Polygon quadrilatere = new Polygon();
			quadrilatere.addGripPoint(new Point(175, 25));
			quadrilatere.addGripPoint(new Point(200, 60));
			quadrilatere.addGripPoint(new Point(300, 30));
			quadrilatere.addGripPoint(new Point(325, 75));
			
			polygons.add(line);
			polygons.add(triangle);
			polygons.add(quadrilatere);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (circle == figHover) {
				g.setColor(Color.GREEN);
				g.fillOval(circle.getCentre().x-circle.getRadius(), circle.getCentre().x-circle.getRadius(), circle.getRadius()*2, circle.getRadius()*2);
			} else if (circle == figNear) {
				g.setColor(Color.RED);
				g.drawOval(circle.getCentre().x-circle.getRadius(), circle.getCentre().x-circle.getRadius(), circle.getRadius()*2, circle.getRadius()*2);
			} else {
				g.drawOval(circle.getCentre().x-circle.getRadius(), circle.getCentre().x-circle.getRadius(), circle.getRadius()*2, circle.getRadius()*2);
			}
			
			

			for (int i = 0 ; i < polygons.size() ; i++) {
				Polygon polygon = polygons.get(i);
				g.setColor(Color.BLACK);
				
				Point[] pts = polygon.getGripPoints();
				int [] x = new int[pts.length];
				int [] y = new int[pts.length];
				for (int j = 0 ; j < pts.length ; j++) {
					x[j] = pts[j].x;
					y[j] = pts[j].y;
				}
				
				if (polygon == figHover) {
					g.setColor(Color.GREEN);
					g.fillPolygon(x, y, pts.length);
				} else if (polygon == figNear) {
					g.setColor(Color.RED);
					g.drawPolygon(x, y, pts.length);
				} else {
					g.drawPolygon(x, y, pts.length);
				}
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			analyzer.setRef(e.getX(), e.getY());
			
			figHover = null;
			figNear = null;
			
			if (analyzer.isHoverFigure(circle)) {
				figHover = circle;
			} else if (analyzer.isNearFigure(circle)) {
				figNear = circle;
			}
			
			
			for (int i = 0 ; i < polygons.size() ; i++) {
				if (analyzer.isHoverFigure(polygons.get(i))) {
					figHover = polygons.get(i);
				} else if (analyzer.isNearFigure(polygons.get(i))) {
					figNear = polygons.get(i);
				}
			}
			
			repaint();
		}
	}
	
	public WindowedTestFigureAnalyzer() {
	}

	public static void main(String[] args) {
		JFrame fen = new JFrame("Test d'analyses de figure");
		
		Figures panel = new WindowedTestFigureAnalyzer().new Figures(0, 5);
		panel.addMouseMotionListener(panel);
		fen.getContentPane().add(panel);
		
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setPreferredSize(new Dimension(500,500));
		fen.pack();
		fen.setVisible(true);
	}
}
