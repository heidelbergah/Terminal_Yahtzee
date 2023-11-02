//James Bouchat
//CS110-A
//Die.java

/**
 * The Die class is able to be rolled, which
 * will yield a random number between 1 and 6.
 * @author James Bouchat
 */

import java.util.Random;

public class Die
{
	private int value;
	private final int SIDES = 6;
	private Random r;

	/** Constructor
	 * initializes value to a random
	 * number between 1 and SIDES.
	 */
	public Die()
	{
		r = new Random();
		value = r.nextInt(SIDES) + 1;
	}

	/**
	 * Changes value to a random number
	 * between 1 and SIDES.
	 */
	public void roll()
	{
		value = r.nextInt(SIDES) + 1;
	}

	/**
	 * Retrive the value of the Die
	 * @return value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * Formats Die information
	 * @return Die information
	 */
	@Override
	public String toString()
	{
		return String.format("%d", value);
	}
}
