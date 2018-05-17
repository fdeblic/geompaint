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

	public void changeFigureColor() {
		if (canvas.getSelectedFigure() == null) return;
		Color newColor = JColorChooser.showDialog(null, "Couleur du fond", canvas.getSelectedFigure().getColor());
		controller.changeFigureColor(canvas.getSelectedFigure(), newColor);
	}

	public void fillFigure() {
		if (canvas.getSelectedFigure() == null) return;
		
		if (canvas.getSelectedFigure().isFilled()){
			controller.fillFigure(canvas.getSelectedFigure(), false);
		}
		else {
			controller.fillFigure(canvas.getSelectedFigure(), true);
		}
	}

	public void cloneFigure() {
		Figure newFigure = controller.cloneFigure(canvas.getSelectedFigure());
		canvas.setSelectedFigure(newFigure);
		
	}

	public void deleteFigure() {
		controller.deleteFigure(canvas.getSelectedFigure());
		canvas.setSelectedFigure(null);
		
	}

	public void createCircle() {
		canvas.setSelectedFigure(new Circle());
		canvas.setState(State.DRAWING);
	}

	public void createPolygon() {
		canvas.setSelectedFigure(new Polygon());
		canvas.setState(State.DRAWING);
		menuAdd.setEnabled(false);
		menuEdit.setEnabled(false);
	}

	public void createRectangle() {
		canvas.setSelectedFigure(new Rectangle());
		menuAdd.setEnabled(false);
		menuEdit.setEnabled(false);
		canvas.setState(State.DRAWING);
	}

	public void createTriangle() {
		canvas.setSelectedFigure(new Triangle());
		menuAdd.setEnabled(false);
		menuEdit.setEnabled(false);
		canvas.setState(State.DRAWING);
	}

	public Figure[] getFigures() {
		return controller.getFigures();
	}

	public void saveFigure(Figure f) {
		controller.addFigure(f);
		canvas.setState(State.NORMAL);
	}

	public void movePoint(Point p, int x, int y) {
		controller.movePoint(p, x, y);
	}
	
	public void moveFigure(Figure f, int x, int y){
		controller.moveFigure(f, x, y);
	}
	
	public Canvas getObserver() {
		return canvas;
	}

}
