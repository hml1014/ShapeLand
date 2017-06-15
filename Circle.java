package shapes;

/*
 * This class represents circles on a coordinate
 * plane. It extends the Ellipse class.  
 */

public class Circle extends Ellipse
{
	private final double pi = 3.14159265359;
	private Point center;
	private double radius;
	private int idNum;
	
	/*
	 * This constructor accepts a Point representing
	 * the center of the circle, a double as the circle's
	 * radius, and an id number to uniquely identify each 
	 * circle object.
	 */
	public Circle(Point center, double radius, int idNum)
	{
		super(center,radius,radius,idNum);
		this.center = center;
		this.radius = radius;
		this.idNum = idNum;
	}

	public Point getCenter() 
	{
		return center;
	}

	public void setCenter(Point center) 
	{
		this.center = center;
	}

	public double getRadius() 
	{
		return radius;
	}

	public void setRadius(double radius) 
	{
		this.radius = radius;
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
	 * representation of a Circle.
	 * Example: C1[(1.0,1.0), 2.0] 
	 */
	public String toString()
	{
		return id() + "[(" + center.getX() + "," + center.getY() + "), " + getRadius() + "]";
	}
	
	/*
	 * This method returns the unique
	 * id of the Circle, which consists
	 * of a C and the idNum.
	 */
	public String id()
	{
		return "C" + getIdNum();
	}
	
	/*
	 * This method overrides the Shape class's
	 * area method. It returns the area
	 * of the circle as a double.
	 */
	public double area()
	{
		return pi*Math.pow(getRadius(), 2);
	}
	
	/*
	 * This method overrides the Shape class's
	 * perimeter method.  It returns the perimeter
	 * of the circle as a double.
	 */
	public double perimeter()
	{
		return 2*pi*getRadius();
	}
	
	/*
	 * This method overrides the Shape class's
	 * hit method. It returns true if the 
	 * input Point is inside the circle. 
	 * Otherwise it returns false.
	 */
	public boolean hit(Point p)
	{
		Point c = getCenter();
		double r = getRadius();
		
		double d = Point.distance(p,c);
		
		return(d <= r);
	}

}
