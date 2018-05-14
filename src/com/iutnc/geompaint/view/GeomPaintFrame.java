package com.iutnc.geompaint.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iutnc.geompaint.controller.GeomPaintController;
import com.iutnc.geompaint.model.Figure;

public class GeomPaintFrame extends JFrame implements IGeomPaintView{
	
	private static final long serialVersionUID = -7316135187489253803L;
	private MenuEdit menuEdit;
	private MenuAdd menuAdd;
	private Canvas canvas;
	private GeomPaintController controller;
	
	public GeomPaintFrame(GeomPaintController c) {
		controller = c;
		JPanel global = new JPanel(new BorderLayout());
		canvas = new Canvas(c);
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
		// TODO Auto-generated method stub
		
	}

	public void fillFigure() {
		// TODO Auto-generated method stub
		
	}

	public void cloneFigure() {
		// TODO Auto-generated method stub
		
	}

	public void deleteFigure() {
		// TODO Auto-generated method stub
		
	}

	public void createCircle() {
		// TODO Auto-generated method stub
		
	}

	public void createPolygon() {
		// TODO Auto-generated method stub
		
	}

	public void createRectangle() {
		// TODO Auto-generated method stub
		
	}

	public void createTriangle() {
		// TODO Auto-generated method stub
		
	}

}
