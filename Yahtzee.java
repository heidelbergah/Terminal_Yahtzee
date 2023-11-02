//James Bouchat
//CS110-A
//Yahtzee.java

/**
 * The category for "Yahtzee" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class Yahtzee extends Category
{
	/** Constructor
	 * Creates object
	 */
	public Yahtzee() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		int value = 0, number;
		for(number = 1; number <= 6; number++)
		{
			if(d.count(number) == 5)
			{
				if(getScore() > 0)
					value = 100;
				else
					value = 50;
			}
		}
		return value;
	}
}
