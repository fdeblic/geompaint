package com.iutnc.geompaint.model;

import java.util.ArrayList;
import java.util.Collections;
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
		try {
			Collections.swap(figures, figures.indexOf(f), figures.indexOf(f)+1);
			setChanged();
			notifyObservers();
		} catch (Exception e) {
		}
	}
	
	public void moveDown(Figure f) {
		try {
			Collections.swap(figures, figures.indexOf(f), figures.indexOf(f)-1);
			setChanged();
			notifyObservers();
		} catch (Exception e) {
		}
	}
		
	public int getPos(Figure f) {
		return figures.indexOf(f);
		
	}
}
