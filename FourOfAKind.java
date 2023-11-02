//James Bouchat
//CS110-A
//FourOfAKind.java

/**
 * The category for "Four of a Kind" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class FourOfAKind extends Category
{
	/** Constructor
	 * Creates object
	 */
	public FourOfAKind() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		int value = 0, count = 0, number;
		for(number = 1; number <= 6; number++)
		{
			count = d.count(number);
			if(count >= 4)
				value = number * 4;
		}
		return value;
	}
}
