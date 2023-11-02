//James Bouchat
//CS110-A
//SmallStraight.java

/**
 * The category for "Small Straight" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class SmallStraight extends Category
{
	/** Constructor
	 * Creates object
	 */
	public SmallStraight() {}

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
				&& d.contains(3) && d.contains(4))
		{
			value = 30;
		}
		else if(d.contains(2) && d.contains(3)
				&& d.contains(4) && d.contains(5))
		{
			value = 30;
		}
		else if(d.contains(3) && d.contains(4)
				&& d.contains(5) && d.contains(6))
		{
			value = 30;
		}
		return value;
	}
}
