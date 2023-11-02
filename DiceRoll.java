//James Bouchat
//CS110-A
//DiceRoll.java

/**
 * The DiceRoll class is a specialization of
 * the Dice class that allows tossing of Die
 * (rolling a specified amount of Die in collection)
 * @author James Bouchat
 */
public class DiceRoll extends Dice
{
	private final int NUM_DIE = 5;

	/** Constructor
	 * Fills the super class ArrayList with NUM_DIE
	 */
	public DiceRoll()
	{
		super();
		for(int i = 0; i < NUM_DIE; i++)
		{
			Die d = new Die();
			addDie(d);
		}
	}

	/**
	 * Rolls each Die in Dice ArrayList
	 */
	public void toss()
	{
		for(int i = 0; i < getNumDice(); i++)
			getDie(i).roll();
	}	
}
