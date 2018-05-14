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
		if(f.isValid() && figures.add(f)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	
	public boolean removeFigure(Figure f) {
		if(f.isValid() && figures.remove(f)) {
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}
	
	public void moveUp(Figure f) {
		
	}
	
	public void moveDown(Figure f) {
		
	}
	
	public void exchange(Figure f1, Figure f2) {
		
	}
	
	public int getPos(Figure f) {
		return figures.indexOf(f);
		
	}
}
