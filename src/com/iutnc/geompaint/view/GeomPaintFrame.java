package com.iutnc.geompaint.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iutnc.geompaint.model.Figure;

public class GeomPaintFrame extends JFrame implements IGeomPaintView{
	
	private static final long serialVersionUID = -7316135187489253803L;
	private MenuEdit menuEdit;
	private MenuAdd menuAdd;
	private Canvas canvas;
	
	public GeomPaintFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel global = new JPanel(new BorderLayout());
		canvas = new Canvas(null);
		menuAdd = new MenuAdd();
		menuEdit = new MenuEdit();
		
		JPanel menus = new JPanel(new BorderLayout());
		menus.add(menuAdd,BorderLayout.NORTH);
		menus.add(menuEdit,BorderLayout.CENTER);
		global.add(canvas,BorderLayout.CENTER);
		global.add(menus,BorderLayout.WEST);
		
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

}
