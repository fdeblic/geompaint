/**
 * 
 */
package com.iutnc.geompaint.test;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import com.iutnc.geompaint.controller.FigureAnalyzer;
import com.iutnc.geompaint.model.Circle;
import com.iutnc.geompaint.model.Polygon;

/**
 * @author deblic3u
 *
 */
public class FigureAnalyzerTest {

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#FigureAnalyzer()}.
	 */
	@Test
	public void testFigureAnalyzer() {
		FigureAnalyzer a = new FigureAnalyzer();
		assertEquals("Default hover tolerance should be 0", 0, a.getHoverTolerence());
		assertEquals("Default near tolerance should be 5", 5, a.getNearTolerence());
		assertEquals("Default coordinates should be (0, 0)", 0, a.getRefX());
		assertEquals("Default coordinates should be (0, 0)", 0, a.getRefY());
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#FigureAnalyzer(int, int, int, int)}.
	 */
	@Test
	public void testFigureAnalyzerIntIntIntInt() {
		FigureAnalyzer a = new FigureAnalyzer(2, 4, 10, 3);
		assertEquals("The hover tolerance should be 0", 3, a.getHoverTolerence());
		assertEquals("The near tolerance should be 5", 10, a.getNearTolerence());
		assertEquals("The coordinates should be (2, 4)", 2, a.getRefX());
		assertEquals("The coordinates should be (2, 4)", 4, a.getRefY());
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#setRef(int, int)}.
	 */
	@Test
	public void testSetRef() {
		FigureAnalyzer a = new FigureAnalyzer();
		a.setRef(5, 10);
		assertEquals("The coordinates should be (5, 10)", 5, a.getRefX());
		assertEquals("The coordinates should be (5, 10)", 10, a.getRefY());
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#setNearTolerence(int)}.
	 */
	@Test
	public void testSetNearTolerence() {
		FigureAnalyzer a = new FigureAnalyzer();
		a.setNearTolerence(42);
		assertEquals("The near tolerance should be 42", 42, a.getNearTolerence());
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#setHoverTolerence(int)}.
	 */
	@Test
	public void testSetHoverTolerence() {
		FigureAnalyzer a = new FigureAnalyzer();
		a.setHoverTolerence(42);
		assertEquals("The hover tolerance should be 42", 42, a.getHoverTolerence());
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#isNearFigure(com.iutnc.geompaint.model.Figure)}.
	 */
	@Test
	public void testIsNearFigure() {
		System.out.println("Not finished");
		FigureAnalyzer a = new FigureAnalyzer();
		a.setHoverTolerence(0);
		a.setNearTolerence(5);
		
		// Circle tests
		
		Circle c = new Circle(new Point(0, 0), new Point(10, 0));
		// X axis
		a.setRef(0, 0);
		assertEquals("The analysis should return true", true, a.isNearFigure(c));
		assertEquals("The analysis should return true", true, a.isHoverFigure(c));
		a.setRef(11, 0);
		assertEquals("The analysis should return true", true, a.isNearFigure(c));
		assertEquals("The analysis should return false", false, a.isHoverFigure(c));
		a.setRef(16, 0);
		assertEquals("The analysis should return false", false, a.isNearFigure(c));
		assertEquals("The analysis should return false", false, a.isHoverFigure(c));
		// Y axis
		a.setRef(0, 11);
		assertEquals("The analysis should return true", true, a.isNearFigure(c));
		assertEquals("The analysis should return false", false, a.isHoverFigure(c));
		a.setRef(0, 16);
		assertEquals("The analysis should return false", false, a.isNearFigure(c));
		assertEquals("The analysis should return false", false, a.isHoverFigure(c));
		// Diagonal
		a.setRef(10, 10);
		System.out.println(c.getCentre().x + " - " + c.getCentre().y + " - " + c.getRadius());
		assertEquals("The analysis should return false", false, a.isNearFigure(c));
		assertEquals("The analysis should return false", false, a.isHoverFigure(c));
		a.setRef(7, 7);
		assertEquals("The analysis should return true", true, a.isNearFigure(c));
		assertEquals("The analysis should return true", true, a.isHoverFigure(c));

		// Polygon tests
		
		Polygon p = new Polygon();
		// No points
		a.setRef(0, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		// A single point
		p.addGripPoint(new Point(0, 0));
		a.setRef(0, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		a.setRef(2, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return true", true, a.isNearFigure(p));
		a.setRef(6, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		// A line
		p.addGripPoint(new Point(0, 6));
		a.setRef(2, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return true", true, a.isNearFigure(p));
		a.setRef(6, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		a.setRef(0, 6);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		a.setRef(2, 6);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return true", true, a.isNearFigure(p));
		a.setRef(6, 6);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		// A triangle
		p.addGripPoint(new Point(7, 4));
		a.setRef(0, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		// A quadrilateral
		p.addGripPoint(new Point(8, 1));
		a.setRef(0, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
		// Polygon not convex
		p.addGripPoint(new Point(4, 2));
		a.setRef(0, 0);
		assertEquals("The analysis should return false", false, a.isHoverFigure(p));
		assertEquals("The analysis should return false", false, a.isNearFigure(p));
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#isHoverFigure(com.iutnc.geompaint.model.Figure)}.
	 */
	@Test
	public void testIsHoverFigure() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#isNearPoint(java.awt.Point)}.
	 */
	@Test
	public void testIsNearPoint() {
		fail("Not yet implemented");
	}

}
