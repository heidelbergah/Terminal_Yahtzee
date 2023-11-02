//James Bouchat
//CS110-A
//Ones.java

/**
 * The category for "ones" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class Ones extends Category
{
	/** Constructor
	 * Creates object
	 */
	public Ones() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		int value = 0;
		int categoryNum = 1;
		for(int i = 0; i < d.getNumDice(); i++)
			if(d.getDie(i).getValue() == categoryNum)
				value += categoryNum;
		return value;
	}
}
