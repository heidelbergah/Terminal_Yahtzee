//James Bouchat
//CS110-A
//Chance.java

/**
 * The category for "Chance" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class Chance extends Category
{
	/** Constructor
	 * Creates object
	 */
	public Chance() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		return d.sum();
	}
}
