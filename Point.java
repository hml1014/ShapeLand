package shapes;

/*
 * This class represents points on a coordinate
 * plane.  Point objects are used to construct
 * all other shapes.
 */

public class Point extends Shape
{
	private double x;
	private double y;
	private int idNum;
	
	/*
	 * This constructor accepts two doubles representing
	 * the X and Y coordinates of each point and an id
	 * number to uniquely identify each point object.
	 * It throws an exception if the point is outside
	 * the accepted range.
	 */
	public Point(double x, double y, int idNum) throws OutOfBoundsException
	{
		this.x = x;
		this.y = y;
		this.idNum = idNum;
		
		if (x < 0 || x > 20 || y < 0 || y > 20)
		{
			throw new OutOfBoundsException();
		}
	}
	
	/*
	 * This second constructor only accepts the X and Y
	 * coordinates and is used to construct other shapes.
	 */
	public Point(double x, double y) throws OutOfBoundsException
	{
		this.x = x;
		this.y = y;
		this.idNum = 0;
		
		if (x < 0 || x > 20 || y < 0 || y > 20)
		{
			throw new OutOfBoundsException();
		}
	}

	public double getX() 
	{
		return x;
	}

	public void setX(double x) 
	{
		this.x = x;
	}

	public double getY() 
	{
		return y;
	}

	public void setY(double y) 
	{
		this.y = y;
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
	 * This method returns true if two
	 * points have the same coordinates.
	 * Otherwise it returns false.
	 */
	public boolean equals(Point p){
		double x = getX();
		double y = getY();
		double x2 = p.getX();
		double y2 = p.getY();
		
		return (x==x2 && y==y2);
	}
	
	/*
	 * This method returns true if three
	 * points are colinear. Otherwise it
	 * returns false.
	 */
	public boolean colinear(Point p2, Point p3){
		double x = getX();
		double y = getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		double x3 = p3.getX();
		double y3 = p3.getY();
		
		double a = (y2-y)*(x3-x2);
		double b = (y3-y2)*(x2-x);
		
		return (a==b);
	}

	/*
	 * This method returns a String 
	 * representation of a Point.
	 * Example: P1(1.0,1.0)
	 */
	public String toString()
	{	
		return id() + "(" + getX() + "," + getY() + ")";
	}
	
	/*
	 * This method computes the distance 
	 * between two points and returns it
	 * as a double.
	 */
	public static double distance(Point p1, Point p2)
	{
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		
		double x3 = Math.pow((x2-x1), 2);
		double y3 = Math.pow((y2-y1), 2);
		return Math.sqrt(x3+y3);
	}
	
	/*
	 * This method returns the unique
	 * id of the Point, which consists
	 * of a P and the idNum.
	 */
	public String id()
	{
		return "P" + getIdNum();
	}
	
	/*
	 * This method overrides the Shape class's
	 * area method.  It returns zero since a
	 * Point has no area.
	 */
	public double area()
	{
		return 0;
	}
	
	/*
	 * This method overrides the Shape class's
	 * perimeter method.  It returns zero since a
	 * Point has no perimeter.
	 */
	public double perimeter()
	{
		return 0;
	}

	/*
	 * This method overrides the Shape class's
	 * hit method.  It returns true if the 
	 * input Point has the same coordinates
	 * as the Point. Otherwise it returns false.
	 */
	public boolean hit(Point p) 
	{
		return (equals(p));
	}
}
