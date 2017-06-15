package shapes;

/*
 * This class represents squares on a coordinate
 * plane. It extends the Rectangle class.  
 */

public class Square extends Rectangle 
{
	private Point upperLeft;
	private Point lowerRight;
	private int idNum;
	
	/*
	 * This constructor accepts two Points representing the upper left
	 * and bottom right corners of the Square, and an id number to 
	 * uniquely identify each square object. It throws an exception 
	 * if the two points overlap, are colinear, if the upper left
	 * point is lower than or to the right of the lower right point,
	 * or if all four sides are not equal in length.
	 */
	public Square(Point upperLeft, Point lowerRight, int idNum) throws InvalidArgumentException 
	{
		super(upperLeft,lowerRight,idNum);
		
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
		
		Point ll = getLowerLeft();
		
		double d = Point.distance(upperLeft,ll);
		double d2 = Point.distance(ll, lowerRight);
		
		if (d != d2)
		{
			throw new InvalidArgumentException();
		}
		
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
	 * representation of a Square.
	 * Example: S1[(1.0,2.0),(3.0,2.0),(3.0,0.0),(1.0,0.0)] 
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
	 * id of the Square, which consists
	 * of an S and the idNum.
	 */
	public String id()
	{
		String id = "S" + getIdNum();
		return id;
	}

	/*
	 * This method overrides the Shape class's
	 * area method. It returns the area
	 * of the square as a double.
	 */
	public double area()
	{
		Point p = getUpperLeft();
		Point p2 = getLowerLeft();
		double side = Point.distance(p, p2);
		return side*side;
	}
	
	/*
	 * This method overrides the Shape class's
	 * perimeter method.  It returns the perimeter
	 * of the square as a double.
	 */
	public double perimeter()
	{
		Point p = getUpperLeft();
		Point p2 = getLowerLeft();
		double side = Point.distance(p, p2);
		return 4*side;
	}
	
	/*
	 * This method overrides the Shape class's
	 * hit method. It returns true if the 
	 * input Point is inside the square. 
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
