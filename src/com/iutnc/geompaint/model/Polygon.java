package com.iutnc.geompaint.model;

import java.awt.Point;

/**
*
* @author Loic Spacher
*
**/

public class Polygon extends Figure{

	
	public Polygon() {
		super();
	}
	
	@Override
	public Polygon getCopie() {
		Polygon pbis = new Polygon();
		pbis.gripPoints = getCopieGripPoints();
		pbis.filled = this.filled;
		pbis.color = this.getColor();
		pbis.maxGripPoints = this.maxGripPoints;
		return pbis;
	}
	
	
	/**
	 * Return all the points to draw
	 * @return Points
	 */
	public Point[] getPoints() {
		return getGripPoints();
	}
	
	

	@Override
	public boolean isFull() {
		return false;
		
	}

	@Override
	public boolean isValid() {
		return this.gripPoints.size()>1;		
	}

}
