package com.iutnc.geompaint.model;

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
		tbis.gripPoints = getCopieGripPoints();
		tbis.filled = this.filled;
		tbis.colorBorder = this.getBorderColor();
		return tbis;
		
	}
	
	public boolean isFull() {
		return this.gripPoints.size()==3;
		
	}
	
	public boolean isValid() {
		return gripPoints.size() >= 2;
		
	}
	
	@Override
	public String getFigureName() {
		return "Triangle";
	}
}
