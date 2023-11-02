//James Bouchat
//CS110-A
//Fours.java

/**
 * The category for "fours" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class Fours extends Category
{
	/** Constructor
	 * Creates object
	 */
	public Fours() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		int value = 0;
		int categoryNum = 4;
		for(int i = 0; i < d.getNumDice(); i++)
			if(d.getDie(i).getValue() == categoryNum)
				value += categoryNum;
		return value;
	}
}
