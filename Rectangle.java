package shapes;

/*
 * This class represents rectangles on a coordinate
 * plane. It extends the Shape superclass.  
 */

public class Rectangle extends Shape 
{
	private Point upperLeft;
	private Point lowerRight;
	private int idNum;
	
	/*
	 * This constructor accepts two Points representing the upper left
	 * and bottom right corners of the Rectangle, and an id number to 
	 * uniquely identify each rectangle object. It throws an exception 
	 * if the two points overlap, are colinear, or if the upper left
	 * point is lower than or to the right of the lower right point.
	 */
	public Rectangle(Point upperLeft, Point lowerRight, int idNum) throws InvalidArgumentException
	{
		this.upperLeft = upperLeft;
		this.lowerRight = lowerRight;
		this.idNum = idNum;
		
		double l = upperLeft.getX();
		double r = lowerRight.getX();
		double l2 = upperLeft.getY();
		double r2 = lowerRight.getY();
		
		if (l == r || l2 == r2)
		{
			throw new InvalidArgumentException();
		}
		
		if (r < l || r2 > l2)
		{
			throw new InvalidArgumentException();
		}
	}
	
	public Point getUpperLeft() 
	{
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) 
	{
		this.upperLeft = upperLeft;
	}

	public Point getLowerRight() 
	{
		return lowerRight;
	}

	public void setLowerRight(Point lowerRight) 
	{
		this.lowerRight = lowerRight;
	}

	/*
	 * This method calculates the location of 
	 * the upper right point and returns a
	 * Point with those coordinates.
	 */
	public Point getUpperRight() 
	{
		double u = lowerRight.getX();
		double u2 = upperLeft.getY();
		
		Point e = null;
		try 
		{
			e = new Point(u,u2);
		} catch (OutOfBoundsException e1) 
		{
			e1.printStackTrace();
		}
		return e;
	}
	
	/*
	 * This method calculates the location of 
	 * the lower left point and returns a
	 * Point with those coordinates.
	 */
	public Point getLowerLeft() 
	{
		double g = upperLeft.getX();
		double g2 = lowerRight.getY();
		
		Point f = null;
		try 
		{
			f = new Point(g,g2);
		} catch (OutOfBoundsException e) 
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public int getIdNum() 
	{
		return idNum;
	}

	public void setIdNum(int idNum) 
	{
		this.idNum = idNum;
	}
	
	/*
	 * This method returns a String 
	 * representation of a Rectangle.
	 * Example: R1[(1.0,2.0),(5.0,2.0),(5.0,0.0),(1.0,0.0)] 
	 */
	public String toString()
	{
		Point ur = getUpperRight();
		Point ll = getLowerLeft();
		
		double c1 = upperLeft.getX();
		double c2 = upperLeft.getY();
		double c3 = ur.getX();
		double c4 = ur.getY();
		double c5 = lowerRight.getX();
		double c6 = lowerRight.getY();
		double c7 = ll.getX();
		double c8 = ll.getY();
		return id() + "[("+c1+","+c2+"),("+c3+","+c4+"),("+c5+","+c6+"),("+c7+","+c8+")]";
	}
	
	/*
	 * This method returns the unique
	 * id of the Rectangle, which consists
	 * of an R and the idNum.
	 */
	public String id()
	{
		return "R" + getIdNum();
	}

	/*
	 * This method overrides the Shape class's
	 * area method. It returns the area
	 * of the rectangle as a double.
	 */
	public double area() 
	{
		Point p = getUpperLeft();
		Point p2 = getLowerLeft();
		Point p3 = getLowerRight();
		double side = Point.distance(p, p2);
		double side2 = Point.distance(p2, p3);
		return side*side2;
	}
	
	/*
	 * This method overrides the Shape class's
	 * perimeter method.  It returns the perimeter
	 * of the rectangle as a double.
	 */
	public double perimeter() 
	{
		Point p = getUpperLeft();
		Point p2 = getLowerLeft();
		Point p3 = getLowerRight();
		double side = Point.distance(p, p2);
		double side2 = Point.distance(p2, p3);
		return 2*side + 2*side2;
	}
	
	/*
	 * This method overrides the Shape class's
	 * hit method. It returns true if the 
	 * input Point is inside the rectangle. 
	 * Otherwise it returns false.
	 */
	public boolean hit(Point p) 
	{
		double x = p.getX();
		double y = p.getY();
		
		double xr = lowerRight.getX();
		double xl = upperLeft.getX();
		double yt = upperLeft.getY();
		double yb = lowerRight.getY();
		
		return (x>=xl && x<=xr && y>=yb && y<=yt);
	}
}
