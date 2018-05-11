package com.iutnc.geompaint.model;

import java.awt.Point;

/**
*
* @author Loic Spacher
*
**/

public class Circle extends Figure{

    //ATTRIBUTES

    private int radius;

    
    //CONSTRUCTOR
    
    public Circle() {
    	super();
    }
    
    //METHODS 
    
    public Point getCentre() {
    	return null;
    }
    
    public int getRadius() {
		return radius;
	}
    
	@Override
	public Circle getCopie() {
		// TODO Auto-generated method stub
		return null;
	}

}
