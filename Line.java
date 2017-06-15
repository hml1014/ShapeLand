package shapes;

/*
 * This class represents lines on a coordinate
 * plane. It extends the Shape superclass.  
 */

public class Line extends Shape {
	private Point p1;
	private Point p2;
	private int idNum;
	
	/*
	 * This constructor accepts two Points representing 
	 * both ends of the line, and an id number to uniquely identify each 
	 * line object. It throws an exception if the two points overlap
	 * or if the first point is right of the second point.
	 */
	public Line(Point p1, Point p2, int idNum) throws InvalidArgumentException
	{
		this.p1 = p1;
		this.p2 = p2;
		this.idNum = idNum;
		
		if (p1.equals(p2)){
			throw new InvalidArgumentException();
		}
		
		if (p1.getX()>p2.getX()){
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

	public int getIdNum() 
	{
		return idNum;
	}

	public void setIdNum(int idNum) 
	{
		this.idNum = idNum;
	}
	
	/*
	 * This method returns the unique
	 * id of the Line, which consists
	 * of a L and the idNum.
	 */
	public String id()
	{
		return "L" + getIdNum();
	}
	
	/*
	 * This method returns a String 
	 * representation of a Line.
	 * Example: L1[(1.0,1.0),(2.0,3.0)] 
	 */
	public String toString()
	{	
		return id() + "[("+p1.getX()+ ","+p1.getY()+"),("+p2.getX()+ "," + p2.getY() + ")]";
	}
	
	/*
	 * This method overrides the Shape class's
	 * area method.  It returns zero since a
	 * Line has no area.
	 */
	public double area()
	{
		return 0;
	}
	
	/*
	 * This method overrides the Shape class's
	 * perimeter method.  It returns zero since a
	 * Line has no perimeter.
	 */
	public double perimeter()
	{
		return 0;
	}

	/*
	 * This method overrides the Shape class's
	 * hit method.  It returns true if the 
	 * input Point falls on the Line. Otherwise 
	 * it returns false.
	 */
	public boolean hit(Point p) {
		double x = p.getX();
		double p1x = p1.getX();
		double p2x = p2.getX();
		return (p.colinear(p1, p2) && x>=p1x && x <=p2x);
	}
}
