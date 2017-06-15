package shapes;

/*
 * This class serves as a custom exception for
 * points that are outside the first Quadrant
 * or greater than twenty. Points must be
 * between zero and twenty.
 */

public class OutOfBoundsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public OutOfBoundsException()
	{
		super("Values less than zero or greater than twenty are not accepted.");
	}
}
