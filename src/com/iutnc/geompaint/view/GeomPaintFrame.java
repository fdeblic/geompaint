package com.iutnc.geompaint.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iutnc.geompaint.model.Figure;

public class GeomPaintFrame extends JFrame implements IGeomPaintView{
	
	private MenuEdit menuEdit;
	private MenuAdd menuAdd;
	private JPanel canvas;

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
	public void addFigure(Figure f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableEdition(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableAdding(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
