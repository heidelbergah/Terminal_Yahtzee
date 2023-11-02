//James Bouchat
//CS110-A
//Fives.java

/**
 * The category for "fives" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class Fives extends Category
{
	/** Constructor
	 * Creates object
	 */
	public Fives() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		int value = 0;
		int categoryNum = 5;
		for(int i = 0; i < d.getNumDice(); i++)
			if(d.getDie(i).getValue() == categoryNum)
				value += categoryNum;
		return value;
	}
}
