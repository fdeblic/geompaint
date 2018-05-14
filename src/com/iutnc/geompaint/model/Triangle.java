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
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isFull() {
		return this.gripPoints.size()==3;
		
	}
	
	public boolean isValid() {
		return this.isFull();
		
	}
}
