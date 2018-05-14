package com.iutnc.geompaint.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import com.iutnc.geompaint.model.Rectangle;

class RectangleTest {

	@Test
	void testIsValid() {
		Rectangle r = new Rectangle();
		r.addGripPoint(new Point(2,3));
		assertEquals(false,r.isValid(),"The rectangle has only 1 grip point.");
		r.addGripPoint(new Point(3,2));
		assertEquals(true,r.isValid(),"The rectangle has only 2 grip points, it's should be valid.");

	}

}
