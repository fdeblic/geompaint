package com.iutnc.geompaint.model;

import java.util.ArrayList;
import java.util.Observable;

public class Drawing extends Observable {
	private ArrayList<Figure> figures;
	
	public Drawing() {
		figures = new ArrayList<>();
	}
	
	public ArrayList<Figure> getFigures() {
		return figures;
	}
	
	public boolean addFigure(Figure f) {
		return figures.add(f);
	}
	
	public boolean removeFigure(Figure f) {
		return figures.remove(f);
	}
}
