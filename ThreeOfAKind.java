//James Bouchat
//CS110-A
//ThreeOfAKind.java

/**
 * The category for "Three of a Kind" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class ThreeOfAKind extends Category
{
	/** Constructor
	 * Creates object
	 */
	public ThreeOfAKind() {}

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
			if(count >= 3)
				value = number * 3;
		}
		return value;
	}
}
