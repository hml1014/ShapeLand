package shapes;

/*
 * This class serves as a custom exception for
 * shapes whose parameters don't meet the 
 * appropriate requirements. 
 */

public class InvalidArgumentException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidArgumentException()
	{
		super("Invalid input.");
	}
}
