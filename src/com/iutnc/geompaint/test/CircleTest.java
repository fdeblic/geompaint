package com.iutnc.geompaint.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import com.iutnc.geompaint.model.Circle;

class CircleTest {

	@Test
	void testIsComplete() {
		Circle c = new Circle();
		
		c.addGripPoint(new Point(2,3));
		assertEquals(false,c.isComplete(),"The circle has only 1 point, it's not complete");
		c.addGripPoint(new Point(6,7));
		assertEquals(true,c.isComplete(),"The circle should have 2 points.");
		c.addGripPoint(new Point(5,3));
		assertEquals(true,c.isComplete(),"The circle should have 2 points.");
		
	}

	@Test
	void testGetCentre() {
		Circle c = new Circle();
		Point g = new Point(2,3);
		c.addGripPoint(g);
		c.addGripPoint(new Point(6,7));
		
		assertEquals(g, c.getCentre(), "The center should be the point (2,3)");
	}

	@Test
	void testGetRadius() {
		Circle c = new Circle();
		
		assertEquals(0, c.getRadius(), " There is no points, the radius should be at 0.");
		
		c.addGripPoint(new Point(0,0));
		c.addGripPoint(new Point(0,5));
		
		assertEquals(5, c.getRadius(), " The radius should be 5.");
		
		c = new Circle();
		c.addGripPoint(new Point(0,0));
		c.addGripPoint(new Point(5,0));
		
		assertEquals(5, c.getRadius(), " The radius should be 5.");
		
		
		c = new Circle();
		c.addGripPoint(new Point(0,0));
		c.addGripPoint(new Point(0,-5));
		
		assertEquals(5, c.getRadius(), " The radius should be 5.");
		
		c = new Circle();
		c.addGripPoint(new Point(0,0));
		c.addGripPoint(new Point(-5,0));
		
		assertEquals(5, c.getRadius(), " The radius should be 5.");
	
		
	}

	@Test
	void testAddGripPoint() {
		Circle c = new Circle();
		c.addGripPoint(new Point(2,3));
		c.addGripPoint(new Point(6,7));
		assertEquals(2,c.getNbGripPoints()," The circle should have 2 grip points.");
		c.addGripPoint(new Point(5,3));
		assertEquals(2,c.getNbGripPoints()," The new grip point should have been refused.");

	}

}
