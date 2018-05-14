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
    	this.radius = 1;
    }

    public Circle(Point centre, Point radius) {
    	addGripPoint(centre);
    	addGripPoint(radius);
	}
    
    //METHODS 

	public Point getCentre() {
    	if(this.gripPoints.size()>0)
    		return this.gripPoints.get(0);
    	else return null;
    }
    
    public int getRadius() {
		if(isFull()) {
			int xa, xb, ya, yb;
			xa = getCentre().x;
			ya = getCentre().y;
			
			xb = gripPoints.get(1).x;
			yb = gripPoints.get(1).y;
			
			return (int) Math.sqrt(Math.pow((xb-xa), 2) + Math.pow((yb - ya),2));
		}
		return 0;
	}
    
	@Override
	public Circle getCopie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		return this.gripPoints.size()==2;
	}

	@Override
	public boolean isValid() {
		return this.isFull();
	}

}
