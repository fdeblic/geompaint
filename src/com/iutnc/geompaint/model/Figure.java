package com.iutnc.geompaint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.*;
import com.iutnc.geompaint.*;

/**
*
* @author Loïc Spacher
*
**/

public abstract class Figure extends Observable{

    // ATTRIBUTES

    private ArrayList<Point> gripPoints ;
    private boolean filled;
    private Color color;
    private int maxGripPoints;

    //CONSTRUCTOR
    
    /**
     * 
     * Constructor 
     * 
     */
    
    protected Figure() {
    	
    }
    
    
    // METHODS 
    
    
    /**
     * Add a grip point to a figure
     * @return boolean 
     */
    public boolean addGripPoint( Point g) {
		return false;
    	
    }
    
    /**
     * Return the points of the figure
     * @return table of Point 
     */
    public Point getGripPoints() {
		return null;
    	
    }
    
    /**
     * The number of grip points of the figure
     * @return number of points 
     */
    public int getNbGripPoints() {
		return 0;
    	
    }
    
    /**
     * Return true if the figure is complete 
     * @return the completion of the figure
     */
    public boolean isComplete() {
		return false;
    	
    }
    
    /**
     * Translate the figure
     * @param x
     * @param y
     */
    public void translate(int x, int y) {
    	
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
    	return false;
    }

    /**
     * Set or change the color of a figure
     * @param c the choosen color
     */
    public void setColor(Color c) {
    	this.color=c;
    }
    
    /**
     * Fill a figure
     * @return boolean
     */
    public void setFilled(boolean b) {
		
    }
    
    /**
     * Verify if a figure is filled or not
     * @return boolean
     */
    public boolean isFilled() {
    	if(filled==true) 
    		return true;
    	return false;
    }
    
    /**
     * Return the color of the figure
     * @return color
     */
    public Color getColor() {
    	return this.color ;
    }
    
}
