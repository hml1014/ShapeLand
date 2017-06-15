package shapes;

/*
 * This class represents ellipses on a coordinate
 * plane. It extends the Shape superclass.  
 */

public class Ellipse extends Shape {
	private final double pi = 3.14159265359;
	private Point center;
	private double vRadius;
	private double hRadius;
	private int idNum;
	
	/*
	 * This constructor accepts a Point representing the
	 * center of the ellipse and two doubles as the
	 * vertical and horizontal radiuses, and and an id 
	 * number to uniquely identify each ellipse object.
	 */
	public Ellipse(Point center, double vRadius, double hRadius, int idNum){
		this.center = center;
		this.vRadius = vRadius;
		this.hRadius = hRadius;
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
	
	public double getvRadius() 
	{
		return vRadius;
	}
	
	public void setvRadius(double vRadius) 
	{
		this.vRadius = vRadius;
	}
	
	public double gethRadius() 
	{
		return hRadius;
	}
	
	public void sethRadius(double hRadius) 
	{
		this.hRadius = hRadius;
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
	 * representation of a Ellipse.
	 * Example: E1[(1.0,1.0), 2.0, 3.0] 
	 */
	public String toString()
	{
		return id() + "[("+center.getX()+","+center.getY()+"), "+getvRadius()+", "+gethRadius()+"]";
	}
	
	/*
	 * This method returns the unique
	 * id of the Ellipse, which consists
	 * of a E and the idNum.
	 */
	public String id()
	{
		return "E" + getIdNum();
	}
	
	/*
	 * This method overrides the Shape class's
	 * area method. It returns the area
	 * of the ellipse as a double.
	 */
	public double area()
	{
		return pi*getvRadius()*gethRadius();
	}
	
	/*
	 * This method overrides the Shape class's
	 * perimeter method.  It returns the perimeter
	 * of the ellipse as a double.
	 */
	public double perimeter()
	{
		double h = Math.pow((getvRadius() - gethRadius()), 2)/Math.pow((getvRadius()+gethRadius()), 2);
		return pi*(getvRadius()+gethRadius())*(1 + (3*h/(10+ Math.sqrt(4-3*h))));
	}
	
	/*
	 * This method overrides the Shape class's
	 * hit method. It returns true if the 
	 * input Point is inside the ellipse. 
	 * Otherwise it returns false.
	 */
	public boolean hit(Point p)
	{
		double x = p.getX();
		double y = p.getY();
		double h = getCenter().getX();
		double k = getCenter().getY();
		double rv = Math.pow(getvRadius() , 2);
		double rh = Math.pow(gethRadius() , 2);
		double t = (Math.pow((x-h), 2)/rh) + (Math.pow((y-k), 2)/rv);
		return (t<=1);
	}
	

}
