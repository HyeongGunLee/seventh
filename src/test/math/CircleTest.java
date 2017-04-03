package test.math;

import static org.junit.Assert.*;

import org.junit.Test;

import seventh.math.Circle;
import seventh.math.Line;
import seventh.math.Rectangle;
import seventh.math.Vector2f;

public class CircleTest {

	/*
	 * Purpose: a point is in Circle 
	 * Input: Circle => (0,0) radius 3, point => (0,0) 
	 * Expected: 
	 * 			the point is in the circle
	 */
	@Test
	public void testPointInCircle() {
		final boolean contain = true;
		final boolean noContain = false;
		Vector2f vector2f = new Vector2f(0,0);
		Vector2f point = new Vector2f(0,0);
		Circle circle = new Circle(vector2f,3);
		assertEquals(contain,Circle.circleContainsPoint(circle, point));
		assertNotEquals(noContain,Circle.circleContainsPoint(circle, point));
	}

	/*
	 * Purpose: a point is on Circle line
	 * Input: Circle => (0,0) radius 3, point => (4,0) 
	 * Expected: 
	 * 			the point is on the circle line
	 */
	@Test
	public void testPointOnCircleLine() {
		final boolean contain = true;
		final boolean noContain = false;
		Vector2f point = new Vector2f(3,0);
		Circle circle = new Circle(new Vector2f(0,0),3);
		assertEquals(contain,Circle.circleContainsPoint(circle, point));
		assertNotEquals(noContain,Circle.circleContainsPoint(circle, point));
	}
	
	/*
	 * Purpose: a point is out of Circle
	 * Input: Circle => (0,0) radius 3, point => (100,0) 
	 * Expected: 
	 * 			return fail
	 * 			the point is out of the circle line.
	 * 			but it is error that calculating distance
	 */
	@Test
	public void testPointOutCircle() {
		final boolean contain = true;
		final boolean noContain = false;
		Vector2f point = new Vector2f(100,0);
		Circle circle = new Circle(new Vector2f(0,0),3);
		assertEquals(noContain,Circle.circleContainsPoint(circle, point));
		assertNotEquals(contain,Circle.circleContainsPoint(circle, point));
	}
	
	/*
	 * Purpose: a circle is in Rectangle
	 * Input: Circle => (3,3) radius 1, rectangle => (0,0) width 4 height 4 
	 * Expected: 
	 * 			the circle is in the rectangle
	 */
	@Test
	public void testCircleInRectangle() {
		final boolean contain = true;
		final boolean noContain = false;
		Circle circle = new Circle(new Vector2f(3,3),1);
		Rectangle rectangle = new Rectangle(new Vector2f(0,0),4,4);
		assertEquals(contain,Circle.circleContainsRect(circle, rectangle));
		assertNotEquals(noContain,Circle.circleContainsRect(circle, rectangle));
	}
	
	/*
	 * Purpose: a circle is out of Rectangle
	 * Input: Circle => (10,10) radius 1, rectangle => (0,0) width 4 height 4 
	 * Expected: 
	 * 			the circle is out of the rectangle
	 */
	@Test
	public void testCircleOutRectangle() {
		final boolean contain = true;
		final boolean noContain = false;
		Circle circle = new Circle(new Vector2f(10,10),1);
		Rectangle rectangle = new Rectangle(new Vector2f(0,0),4,4);
		assertEquals(noContain,Circle.circleContainsRect(circle, rectangle));
		assertNotEquals(contain,Circle.circleContainsRect(circle, rectangle));
	}
	
	/*
	 * Purpose: a circle intersect Rectangle
	 * Input: Circle => (0,0) radius 3, rectangle => (2,2) width 4 height 4 
	 * Expected: 
	 * 			the circle intersect the rectangle
	 */
	@Test
	public void testCircleIntersectRectangle() {
		final boolean intersect = true;
		final boolean noIntersect = false;
		Circle circle = new Circle(new Vector2f(0,0),3);
		Rectangle rectangle = new Rectangle(new Vector2f(2,2),4,4);
		assertEquals(intersect,Circle.circleIntersectsRect(circle, rectangle));
		assertNotEquals(noIntersect,Circle.circleIntersectsRect(circle, rectangle));
	}
	
	/*
	 * Purpose: a circle intersect Rectangle in Rectangle
	 * Input: Circle => (0,0) radius 10, rectangle => (3,3) width 2 height 2 
	 * Expected: 
	 * 			the circle intersect the rectangle
	 */	
	@Test
	public void testCircleIntersectInRectangle() {
		final boolean intersect = true;
		final boolean noIntersect = false;
		Circle circle = new Circle(new Vector2f(0,0),10);
		Rectangle rectangle = new Rectangle(new Vector2f(3,3),2,2);
		assertEquals(intersect,Circle.circleIntersectsRect(circle, rectangle));
		assertNotEquals(noIntersect,Circle.circleIntersectsRect(circle, rectangle));
	}
	
	/*
	 * Purpose: a circle don't intersect Rectangle on same Y axis
	 * Input: Circle => (0,0) radius 3, rectangle => (10,0) width 5 height 5 
	 * Expected: 
	 * 			the circle don't intersect the rectangle
	 */
	@Test
	public void testCircleNoIntersectRectangleSameYaxis() {
		final boolean intersect = true;
		final boolean noIntersect = false;
		Circle circle = new Circle(new Vector2f(0,0),3);
		Rectangle rectangle = new Rectangle(new Vector2f(10,0),5,5);
		assertEquals(noIntersect,Circle.circleIntersectsRect(circle, rectangle));
		assertNotEquals(intersect,Circle.circleIntersectsRect(circle, rectangle));
	}
	
	/*
	 * Purpose: a circle don't intersect Rectangle on same X axis
	 * Input: Circle => (0,0) radius 3, rectangle => (0,10) width 5 height 5 
	 * Expected: 
	 * 			the circle don't intersect the rectangle
	 */
	@Test
	public void testCircleNoIntersectRectangleSameXaxis() {
		final boolean intersect = true;
		final boolean noIntersect = false;
		Circle circle = new Circle(new Vector2f(0,0),3);
		Rectangle rectangle = new Rectangle(new Vector2f(0,10),5,5);
		assertEquals(noIntersect,Circle.circleIntersectsRect(circle, rectangle));
		assertNotEquals(intersect,Circle.circleIntersectsRect(circle, rectangle));
	}
	
	/*
	 * Purpose: a line intersect Circle
	 * Input: Circle => (0,0) radius 3, line => line(0,0)~(0,10) 
	 * Expected: 
	 * 			the line intersect the circle
	 */
	@Test
	public void testCircleIntersectLine(){
		final boolean intersect = true;
		final boolean noIntersect = false;
		Circle circle = new Circle(new Vector2f(0,0),3);
		Line line = new Line(new Vector2f(0,0),new Vector2f(0,10));
		assertEquals(intersect,Circle.circleIntersectsLine(circle, line));
		assertNotEquals(noIntersect,Circle.circleIntersectsLine(circle, line));
	}
	
	/*
	 * Purpose: a line don't intersect Circle
	 * Input: Circle => (0,0) radius 3, line => line(9,9)~(10,10) 
	 * Expected: 
	 * 			return FAILURE
	 * 			line shouldn't have intersected the circle
	 * 			However, the line intersect the circle
	 */
	@Test
	public void testCircleNoIntersectLine(){
		final boolean intersect = true;
		final boolean noIntersect = false;
		Circle circle = new Circle(new Vector2f(0,0),3);
		Line line = new Line(new Vector2f(9,9),new Vector2f(10,10));
		assertNotEquals(intersect,Circle.circleIntersectsLine(circle, line));
		assertEquals(noIntersect,Circle.circleIntersectsLine(circle, line));
	}
}
