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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#setRef(int, int)}.
	 */
	@Test
	public void testSetRef() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.iutnc.geompaint.controller.FigureAnalyzer#setNearTolerence(int)}.
	 */
	@Test
	public void testSetNearTolerence() {
		fail("Not yet implemented");
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
