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
    	this.maxGripPoints=2;
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
		Circle cbis = new Circle();
		cbis.gripPoints = this.gripPoints;
		cbis.filled = this.filled;
		cbis.color = this.color;
		cbis.maxGripPoints = this.maxGripPoints;
		cbis.radius = this.radius;
		return cbis;
	}

	@Override
	public boolean isFull() {
		return this.gripPoints.size()==this.maxGripPoints;
	}

	@Override
	public boolean isValid() {
		return this.isFull();
	}

}
