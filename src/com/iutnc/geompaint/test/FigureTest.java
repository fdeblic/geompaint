/**
 * 
 */
package com.iutnc.geompaint.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import com.iutnc.geompaint.model.Figure;

/**
 * @author Loic Spacher
 *
 */
class FigureTest extends Figure {
	
	public FigureTest() {
		super();
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.model.Figure#Figure()}.
	 */
	@Test
	void testFigure() {
		Figure f = new FigureTest();
		
		assertEquals(0,f.getGripPoints().length,"The figure should not have any grip points.");
		assertEquals(Color.black, f.getColor(), "The color should be black.");
		assertEquals(false, f.isFilled(), " The figure should not be filled.");
		
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.model.Figure#addGripPoint(java.awt.Point)}.
	 */
	@Test
	void testAddGripPoint() {
		Figure f = new FigureTest();
				
		assertEquals(true,f.addGripPoint(new Point(2, 3))," The figure should have one grip point");
		
		Point[] tab = f.getGripPoints();
		
		assertEquals(2, tab[0].x, "The X-coordonnate should be 2.");
		assertEquals(3, tab[0].y, "The Y-coordonnate should be 3.");

		

	}

	/**
	 * Test method for {@link com.iutnc.geompaint.model.Figure#getGripPoints()}.
	 */
	@Test
	void testGetGripPoints() {
		Figure f = new FigureTest();
		f.addGripPoint(new Point(2, 3));
		f.addGripPoint(new Point(3, 4));
		Point[] tab = f.getGripPoints();
		
		assertEquals(2, tab.length, "The table should be a size of 2.");
		assertEquals(2, tab[0].x, "The X-coordonnate should be 2.");
		assertEquals(3, tab[0].y, "The Y-coordonnate should be 3.");
		assertEquals(3, tab[1].x, "The X-coordonnate should be 3.");
		assertEquals(4, tab[1].y, "The Y-coordonnate should be 4.");

	}

	/**
	 * Test method for {@link com.iutnc.geompaint.model.Figure#getNbGripPoints()}.
	 */
	@Test
	void testGetNbGripPoints() {
		Figure f = new FigureTest();

		assertEquals(0, f.getNbGripPoints(), "The figure should not have any grip points at its creation.");
		
		Point g = new Point(4, 3);
		f.addGripPoint(g);
		
		assertEquals(1, f.getNbGripPoints(), "The figure should have one grip points.");
		
		f.removeGripPoint(g);
		
		assertEquals(0, f.getNbGripPoints(), " The figure should not have any grip points left.");
		
	}


	/**
	 * Test method for {@link com.iutnc.geompaint.model.Figure#translate(int, int)}.
	 */
	@Test
	void testTranslate() {
		Figure f = new FigureTest();
		Point g = new Point(2, 3);
		f.addGripPoint(g);
		f.translate(2, 3);
		Point[] tab = f.getGripPoints();
		
		assertEquals(4, tab[0].x, " The X-coordonnate should be 4.");
		assertEquals(6, tab[0].y, " The Y-coordonnate should be 6.");

		
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.model.Figure#removeGripPoint(java.awt.Point)}.
	 */
	@Test
	void testRemoveGripPoint() {
		Figure f = new FigureTest();
		Point g = new Point(2, 3);

		f.addGripPoint(g);
		f.addGripPoint(new Point(3, 4));
		
		f.removeGripPoint(g);
		assertEquals(1, f.getNbGripPoints(), " The figure should have only one grip point remaining.");
	}

	@Override
	public Figure getCopie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

}
