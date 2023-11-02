//James Bouchat
//CS110-A
//Category.java

/**
 * An abstract base class for all categories
 * on the score card.
 * @author James Bouchat
 */
public abstract class Category
{
	private int score = 0;
	private boolean used = false;

	/** Abstract
	 * evaluates the Die in the Dice object
	 * and return a score
	 */
	public abstract int evaluate(Dice d);

	/**
	 * Add the value the Dice would produce
	 * to the score. Marks category as used
	 * @param d Collection of Die
	 */
	public void addValue(Dice d)
	{
		score += evaluate(d);
		used = true;
	}

	/**
	 * Get current score for this category
	 * @return current score
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * Gets value of used indicating if the
	 * category has been used
	 * @return used
	 */
	public boolean getUsed()
	{
		return used;
	}
}
