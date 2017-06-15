package shapes;

/*
 * This class represents triangles on a coordinate
 * plane. It extends the Shape superclass.  
 */

public class Triangle extends Shape 
{
	private Point p1;
	private Point p2;
	private Point p3;
	private int idNum;
	
	/*
	 * This constructor accepts three Points representing the three
	 * vertices of the Triangle, and an id number to uniquely identify 
	 * each triangle object. It throws an exception if any points overlap
	 * or if all three points are colinear.
	 */
	public Triangle(Point p1, Point p2, Point p3, int idNum) throws InvalidArgumentException
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.idNum = idNum;
		
		if (p1.colinear(p2, p3)){
			throw new InvalidArgumentException();
		}
		
		if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)){
			throw new InvalidArgumentException();
		}
	}
	
	public Point getP1() 
	{
		return p1;
	}

	public void setP1(Point p1)
	{
		this.p1 = p1;
	}

	public Point getP2()
	{
		return p2;
	}

	public void setP2(Point p2)
	{
		this.p2 = p2;
	}

	public Point getP3() 
	{
		return p3;
	}

	public void setP3(Point p3)
	{
		this.p3 = p3;
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
	 * representation of a Triangle.
	 * Example: T1[(1.0,2.0),(5.0,6.0),(3.0,0.0)] 
	 */
	public String toString()
	{
		double t = p1.getX();
		double t2 = p1.getY();
		double t3 = p2.getX();
		double t4 = p2.getY();
		double t5 = p3.getX();
		double t6 = p3.getY();
	    return id() + "[(" + t + "," + t2 + ")," + " (" + t3 + "," + t4 + ")," + " (" + t5 + "," + t6 + ")]";
	}
	
	/*
	 * This method returns the unique
	 * id of the Triangle, which consists
	 * of a T and the idNum.
	 */
	public String id()
	{
		return "T" + getIdNum();
	}
	
	/*
	 * This method accepts three points and returns
	 * true if the third point falls on the line
	 * created by the first two points.
	 */
	public boolean between(Point l1, Point l2,Point p){
		double sx = l1.getX();
		double ex = l2.getX();
		double x = p.getX();
		
		if (sx > ex){
			double temp = sx;
			sx = ex;
			ex= temp;
		}
		
		return (p.colinear(l1, l2) && x >= sx && x <= ex);
	}
	
	/*
	 * This method overrides the Shape class's
	 * area method. It returns the area
	 * of the triangle as a double.
	 */
	public double area()
	{
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		double x3 = p3.getX();
		double y3 = p3.getY();
		double area = 0.5*((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1));
		area = Math.abs(area);
		return area;
	}
	
	/*
	 * This method overrides the Shape class's
	 * perimeter method.  It returns the perimeter
	 * of the triangle as a double.
	 */
	public double perimeter()
	{
		double side1 = Point.distance(p1,p2);
		double side2 = Point.distance(p2,p3);
		double side3 = Point.distance(p1,p3);
		return side1+side2+side3;
	}
	
	/*
	 * This method overrides the Shape class's
	 * hit method. It returns true if the 
	 * input Point is inside the triangle. 
	 * Otherwise it returns false.
	 */
	public boolean hit(Point p)
	{
		if (between(p1,p2,p)) return true;
		else if (between(p2,p3,p)) return true;
		else if (between(p3,p1,p)) return true;
		
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		double x3 = p3.getX();
		double y3 = p3.getY();
		double x = p.getX();
		double y = p.getY();
		
		double a = ((y2 - y3)*(x - x3) + (x3 - x2)*(y - y3)) / ((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
		double b = ((y3 - y1)*(x - x3) + (x1 - x3)*(y - y3)) / ((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
		double c = 1 - a - b;
		
		return (a>0 && a<1 && b>0 && b<1 && c>0 && c<1);
	}
}
