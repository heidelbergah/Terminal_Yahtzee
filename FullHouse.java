//James Bouchat
//CS110-A
//FullHouse.java

/**
 * The category for "Full House" on the score card.
 * Inherits from the abstract Category class
 * @author James Bouchat
 */
public class FullHouse extends Category
{
	/** Constructor
	 * Creates object
	 */
	public FullHouse() {}

	/**
	 * Evaluates the Die in the Dice object
	 * and returns a score
	 * @param d Dice to evaluate
	 * @return value achieved
	 */
	public int evaluate(Dice d)
	{
		int value = 0;
		for(int i = 1; i <= 6; i++)
			for(int j = 1; j <= 6; j++)
				if(i != j)
					if(d.count(i) == 2 && d.count(j) == 3)
						value = 25;
		return value;
	}
}
