/**
 * 
 */
package com.iutnc.geompaint.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iutnc.geompaint.controller.FigureAnalyzer;

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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#isNearFigure(com.iutnc.geompaint.model.Figure)}.
	 */
	@Test
	public void testIsNearFigure() {
		fail("Not yet implemented");
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
