package com.iutnc.geompaint.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import com.iutnc.geompaint.model.Polygon;

class PolygonTest {

	@Test
	void testIsComplete() {
		Polygon p = new Polygon();
		p.addGripPoint(new Point(2,3));
		assertEquals(false, p.isComplete(),"The polygon has only one point, it can be completed.");
		p.addGripPoint(new Point(4,7));
		p.addGripPoint(new Point(18,12));
		p.addGripPoint(new Point(1,2));
		assertEquals(true, p.isComplete(), "The polygon should be complete, it has more than 1 point.");
	}

	@Test
	void testGetPoints() {
		Polygon p = new Polygon();
		p.addGripPoint(new Point(4,7));
		p.addGripPoint(new Point(18,12));
		p.addGripPoint(new Point(1,2));
		Point[] tab = p.getPoints();
		
		assertEquals(3, tab.length, "The table should be a size of 3.");
		assertEquals(4, tab[0].x, "The X-coordonnate should be 4.");
		assertEquals(7, tab[0].y, "The Y-coordonnate should be 7.");
		assertEquals(18, tab[1].x, "The X-coordonnate should be 18.");
		assertEquals(12, tab[1].y, "The Y-coordonnate should be 12.");
		assertEquals(1, tab[2].x, "The X-coordonnate should be 1");
		assertEquals(2, tab[2].y, "The Y-coordonnate should be 2");

	}

}
