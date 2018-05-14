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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Return all the points to draw
	 * @return Points
	 */
	public Point[] getPoints() {
		return getGripPoints();
	}
	
	

	@Override
	public boolean isComplete() {
		return false;
		
	}

}
