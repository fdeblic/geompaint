package com.iutnc.geompaint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
*
* @author Loic Spacher
*
**/

public abstract class Figure extends Observable {

    // ATTRIBUTES

    protected ArrayList<Point> gripPoints ;
    protected boolean filled;
    protected Color colorBorder;
    protected Color colorFill;
    protected int maxGripPoints;
    protected final int INFINITE = 0;
    private static Random random = new Random();

    //CONSTRUCTOR
    
    /**
     * 
     * Constructor 
     * 
     */
    
    protected Figure() {
    	
    	this.gripPoints = new ArrayList<>();
    	this.filled = false;
    	float hue = random.nextFloat();
    	
    	this.colorBorder = Color.getHSBColor(hue, 0.8f, 0.8f);
    	this.colorFill = Color.LIGHT_GRAY;
    	this.maxGripPoints = INFINITE;
    	
    	
    }
    
    
    // METHODS 
    
    
    /**
     * Add a grip point to a figure
     * @return boolean 
     */
    public boolean addGripPoint( Point g) {

    	if(isFull())
    		return false;
    	setChanged();
    	this.gripPoints.add(g);
    	notifyObservers();
    	return true;
    	
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
    
    public abstract boolean isValid();
    
    /**
     * Return true if the figure accept the new grip point
     * @return the completion of the figure
     */
    public abstract boolean isFull();
    
    /**
     * Translate the figure
     * @param x
     * @param y
     */
    public void translate(int x, int y) {
    	
    	for(int i = 0; i< gripPoints.size(); i++) {
    		gripPoints.get(i).translate(x, y);
    	}
    	setChanged();
    	notifyObservers();
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
    	if(this.gripPoints.remove(g)) {
    		setChanged();
    		notifyObservers();
    		return true;
    	}
    	return false;
    	
    }

    /**
     * Sets the color of the figure's borders
     * @param c the chosen color
     */
    public void setBorderColor(Color c) {
    	this.colorBorder = c;
    	setChanged();
    	notifyObservers();
    }

    /**
     * Sets the filling color of the figure
     * @param c the chosen color
     */
    public void setFillColor(Color c) {
    	this.colorFill = c;
    	this.filled = true;
    	setChanged();
    	notifyObservers();
    }
    
    /**
     * Fill a figure
     * @return boolean
     */
    public void setFilled(boolean b) {
		this.filled=b;
		setChanged();
		notifyObservers();
    }
    
    /**
     * Verify if a figure is filled or not
     * @return boolean
     */
    public boolean isFilled() {
    	return this.filled;
    }
    
    /**
     * Return the color of the border's figure
     * @return color
     */
    public Color getBorderColor() {
    	return this.colorBorder;
    }
    
    /**
     * Return the fill color of the figure
     * @return color
     */
    public Color getFillColor() {
    	return this.colorFill;
    }
    
    
    protected ArrayList<Point> getCopieGripPoints(){
		ArrayList<Point> res = new ArrayList<Point>();
    	for(int i = 0; i< gripPoints.size(); i++) {
    		Point p = new Point();
    		p.x = this.gripPoints.get(i).x;
    		p.y = this.gripPoints.get(i).y;
    		res.add(p);
    	}
    	return res;
    }


	public Figure clear() {
		gripPoints.clear();
		return this;
	}

	/**
	 * Returns the figure name ("Circle", "Rectangle", ...)
	 * @return the Figure's name
	 */
	public abstract String getFigureName();
}
