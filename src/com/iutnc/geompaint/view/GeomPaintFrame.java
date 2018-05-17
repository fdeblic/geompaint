package com.iutnc.geompaint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iutnc.geompaint.controller.GeomPaintController;
import com.iutnc.geompaint.controller.State;
import com.iutnc.geompaint.model.Circle;
import com.iutnc.geompaint.model.Figure;
import com.iutnc.geompaint.model.Polygon;
import com.iutnc.geompaint.model.Rectangle;
import com.iutnc.geompaint.model.Triangle;

public class GeomPaintFrame extends JFrame implements IGeomPaintView {
	
	private static final long serialVersionUID = -7316135187489253803L;
	private MenuEdit menuEdit;
	private MenuAdd menuAdd;
	private Canvas canvas;
	private GeomPaintController controller;
	
	public GeomPaintFrame(GeomPaintController c) {
		super("GeomPaint");
		controller = c;
		JPanel global = new JPanel(new BorderLayout());
		canvas = new Canvas(this);
		menuAdd = new MenuAdd(this);
		menuEdit = new MenuEdit(this);
		
		JPanel menus = new JPanel(new BorderLayout());
		menus.add(menuAdd,BorderLayout.NORTH);
		menus.add(menuEdit,BorderLayout.CENTER);
		global.add(canvas,BorderLayout.CENTER);
		global.add(menus,BorderLayout.WEST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,500));
		setContentPane(global);
		pack();
	}

	@Override
	public boolean isSelectedFigure(Figure f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSelectedFigure(Figure f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Enable Menu Edition
	 */
	public void enableEdition(boolean b) {
		menuEdit.setEnabled(b);		
	}

	@Override
	/**
	 * Enable Menu Adding
	 */
	public void enableAdding(boolean b) {
		menuAdd.setEnabled(b);
	}
	
	/**
	 * Change the color of the selected figure
	 */
	public void changeFigureColor() {
		if (canvas.getSelectedFigure() == null) return;
		Color newColor = JColorChooser.showDialog(null, "Couleur du fond", canvas.getSelectedFigure().getColor());
		controller.changeFigureColor(canvas.getSelectedFigure(), newColor);
	}

	/**
	 * Fill and clean the selected figure 
	 */
	public void fillFigure() {
		if (canvas.getSelectedFigure() == null) return;
		
		if (canvas.getSelectedFigure().isFilled()){
			controller.fillFigure(canvas.getSelectedFigure(), false);
		}
		else {
			controller.fillFigure(canvas.getSelectedFigure(), true);
		}
	}

	/**
	 * Clone the selected figure
	 */
	public void cloneFigure() {
		Figure newFigure = controller.cloneFigure(canvas.getSelectedFigure());
		canvas.setSelectedFigure(newFigure);
		
	}

	/**
	 * Delete the selected figure
	 */
	public void deleteFigure() {
		controller.deleteFigure(canvas.getSelectedFigure());
		canvas.setSelectedFigure(null);
		
	}

	/**
	 * Create a circle
	 */
	public void createCircle() {
		canvas.cancelDrawing();
		canvas.setSelectedFigure(new Circle());
		canvas.setState(State.DRAWING);
	}

	/**
	 * Create a polygon
	 */
	public void createPolygon() {
		menuAdd.setEnabled(false);
		menuEdit.setEnabled(false);
		canvas.setSelectedFigure(new Polygon());
		canvas.setState(State.DRAWING);
	}

	/**
	 * Create a rectangle
	 */
	public void createRectangle() {
		canvas.setSelectedFigure(new Rectangle());
		canvas.setState(State.DRAWING);
	}

	/**
	 * Create a triangle
	 */
	public void createTriangle() {
		canvas.setSelectedFigure(new Triangle());
		canvas.setState(State.DRAWING);
	}

	/**
	 * Get the figures's list
	 * @return the figures's list
	 */
	public Figure[] getFigures() {
		return controller.getFigures();
	}

	/**
	 * Save a figure in the figures's list
	 * @param f the figure to save
	 */
	public void saveFigure(Figure f) {
		controller.addFigure(f);
		canvas.setState(State.NORMAL);
	}

	/**
	 * Move a point 
	 * @param p the point to move
	 * @param x the abscissa 
	 * @param y the ordinate
	 */
	public void movePoint(Point p, int x, int y) {
		controller.movePoint(p, x, y);
	}
	
	/**
	 * Move a figure 
	 * @param f the figure to move
	 * @param x the abscissa 
	 * @param y the ordinate
	 */
	
	public void moveFigure(Figure f, int x, int y){
		controller.moveFigure(f, x, y);
	}
	

	public Canvas getObserver() {
		return canvas;
	}

	/**
	 * Move the selected figure on the front
	 */
	public void moveUp() {
		controller.moveUp(canvas.getSelectedFigure());
		
	}

	/**
	 * Move the selected figure on the back
	 */
	public void moveDown() {
		controller.moveDown(canvas.getSelectedFigure());		
	}

}
