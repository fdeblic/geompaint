package com.iutnc.geompaint.model;

/**
*
* @author Loic Spacher
*
**/

public class Rectangle extends Polygon{

	public Rectangle() {
		super();
	}
	
	@Override
	public Rectangle getCopie() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isFull() {
		return this.gripPoints.size()==2;
		
	}
	public boolean isValid() {
		return this.isFull();
		
	}

}
