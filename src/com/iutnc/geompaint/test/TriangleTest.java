package com.iutnc.geompaint.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import com.iutnc.geompaint.model.Triangle;

class TriangleTest {

	@Test
	void testIsValid() {
		Triangle t = new Triangle();
		t.addGripPoint(new Point(2,3));
		assertEquals(false,t.isValid(),"The triangle has only 1 grip point.");
		t.addGripPoint(new Point(4,7));
		t.addGripPoint(new Point(16,18));
		assertEquals(true,t.isValid(),"The triangle has 3 grip points, it's should be valid.");

	}

}
