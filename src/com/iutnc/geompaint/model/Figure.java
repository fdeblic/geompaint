package com.iutnc.geompaint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

/**
*
* @author Loic Spacher
*
**/

public abstract class Figure extends Observable {

    // ATTRIBUTES

    protected ArrayList<Point> gripPoints ;
    protected boolean filled;
    protected Color color;
    protected int maxGripPoints;
    protected final int INFINITE = 0;

    //CONSTRUCTOR
    
    /**
     * 
     * Constructor 
     * 
     */
    
    protected Figure() {
    	
    	this.gripPoints = new ArrayList<>();
    	this.filled = false;
    	this.color = Color.black;
    	this.maxGripPoints = INFINITE;
    	
    	
    }
    
    
    // METHODS 
    
    
    /**
     * Add a grip point to a figure
     * @return boolean 
     */
    public boolean addGripPoint( Point g) {

    	if(isComplete())
    		return false;
    	return this.gripPoints.add(g);
    	
    }
    
    /**
     * Return the points of the figure
     * @return table of Point 
     */
    public Point[] getGripPoints() {
    	
		return this.gripPoints.toArray(new Point[this.gripPoints.size()]);
    	
    }
    
    /**
     * The number of grip points of the figure
     * @return number of points 
     */
    public int getNbGripPoints() {
    	
		return gripPoints.size();
    	
    }
    
    /**
     * Return true if the figure accept the new grip point
     * @return the completion of the figure
     */
    public abstract boolean isComplete();
    
    /**
     * Translate the figure
     * @param x
     * @param y
     */
    public void translate(int x, int y) {
    	
    	for(int i = 0; i< gripPoints.size(); i++) {
    		gripPoints.get(i).translate(x, y);
    	}
    }
    
    /**
     * Create a copie of the figure
     * @return a figure
     */
    public abstract Figure getCopie();
    
    /**
     * Remove a grip point from a figure
     * @param g the grip point to erase
     * @return boolean
     */
    public boolean removeGripPoint( Point g) {
    	return this.gripPoints.remove(g);
    	
    }

    /**
     * Set or change the color of a figure
     * @param c the chosen color
     */
    public void setColor(Color c) {
    	this.color=c;
    }
    
    /**
     * Fill a figure
     * @return boolean
     */
    public void setFilled(boolean b) {
		this.filled=b;
    }
    
    /**
     * Verify if a figure is filled or not
     * @return boolean
     */
    public boolean isFilled() {
    	return this.filled;
    }
    
    /**
     * Return the color of the figure
     * @return color
     */
    public Color getColor() {
    	return this.color ;
    }
    
}
