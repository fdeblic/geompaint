package com.iutnc.geompaint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
*
* @author Loic Spacher
*
**/

public class Triangle extends Polygon {
	
	public Triangle() {
		super();
	}
	
	@Override
	public Triangle getCopie() {
		Triangle tbis = new Triangle();
		tbis.gripPoints = (ArrayList<Point>) this.gripPoints.clone();
		tbis.filled = this.filled;
		tbis.color = this.getColor();
		return tbis;
		
	}
	
	public boolean isFull() {
		return this.gripPoints.size()==3;
		
	}
	
	public boolean isValid() {
		return this.isFull();
		
	}
}
