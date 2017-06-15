package shapes;

/*
 * This class acts as the base superclass
 * for all different shapes implemented by 
 * this program.
 */

public abstract class Shape 
{
	public abstract String id();
	
	public abstract double area(); 
	
	public abstract double perimeter();
	
	public abstract boolean hit(Point p);
}
