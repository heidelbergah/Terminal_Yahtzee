//James Bouchat
//CS110-A
//LargeStraight.java

/**
 * The category for "Large Straight" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class LargeStraight extends Category
{
	/** Constructor
	 * Creates object
	 */
	public LargeStraight() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		int value = 0;
		if(d.contains(1) && d.contains(2)
				&& d.contains(3) && d.contains(4)
				&& d.contains(5))
		{
			value = 40;
		}
		else if(d.contains(2) && d.contains(3)
				&& d.contains(4) && d.contains(5)
				&& d.contains(6))
		{
			value = 40;
		}
		return value;
	}
}
