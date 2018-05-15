package com.iutnc.geompaint.model;

/**
*
* @author Loic Spacher
*
**/

public class Rectangle extends Polygon{

	public Rectangle() {
		super();
		this.maxGripPoints=2;
	}
	
	@Override
	public Rectangle getCopie() {
		Rectangle rbis = new Rectangle();
		rbis.gripPoints = this.gripPoints;
		rbis.filled = this.filled;
		rbis.color = this.color;
		rbis.maxGripPoints = this.maxGripPoints;
		return rbis;
	}

	public boolean isFull() {
		return this.gripPoints.size()==this.maxGripPoints;
		
	}
	public boolean isValid() {
		return this.isFull();
		
	}

}
