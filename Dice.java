//James Bouchat
//CS110-A
//Dice.java

/**
 * The Dice class contains an ArrayList of
 * Die objects. The Dice class' job is to
 * manage all game Die and return information about
 * them
 * @author James Bouchat
 */

import java.util.ArrayList;

public class Dice
{
	private ArrayList<Die> dice;
	private final int DEF_CAP = 5;

	/** Constructor
	 * Creates the ArrayList with a capacity
	 * of DEF_CAP
	 */
	public Dice()
	{
		dice = new ArrayList<>(DEF_CAP);
	}

	/** Constructor
	 * Creates the ArrayList with a capacity
	 * of num
	 * @param num Capacity to set
	 */
	public Dice(int num)
	{
		dice = new ArrayList<>(num);
	}

	/**
	 * Adds a Die to the ArrayList
	 * @param d Die to add
	 */
	public void addDie(Die d)
	{
		dice.add(d);
	}

	/**
	 * Get number of Die in ArrayList
	 * @return number of Die
	 */
	public int getNumDice()
	{
		return dice.size();
	}

	/**
	 * Get the Die at index i in ArrayList
	 * @param i index to get
	 * @return Die at index i
	 */
	public Die getDie(int i)
	{
		return dice.get(i);
	}

	/**
	 * Remove Die at index i in ArrayList
	 * @param i index to remove
	 */
	public void removeDie(int i)
	{
		dice.remove(i);
	}

	/**
	 * Get the number of Die in ArrayList
	 * that have a value of the specified val
	 * @param val value to check for
	 * @return num of Die of specified val
	 */
	public int count(int val)
	{
		int num = 0;
		for(Die d : dice)
			if(d.getValue() == val)
				num++;
		return num;
	}

	/**
	 * Return the sum of the Die values
	 * in ArrayList
	 * @return summed value
	 */
	public int sum()
	{
		int sum = 0;
		for(Die d : dice)
			sum += d.getValue();
		return sum;
	}

	/**
	 * Return true if at least one Die in
	 * the ArrayList has a value of val
	 * @param val value to check for
	 * @return ArrayList has value or not
	 */
	public boolean contains(int val)
	{
		for(Die d : dice)
			if(d.getValue() == val)
				return true;
		return false;
	}

	/**
	 * Creates a formatted string of all the Dies
	 * information
	 * @return formatted information
	 */
	@Override
	public String toString()
	{
		String rString = "";
		int dieNum = 1;
		for(Die d : dice)
		{
			rString += dieNum + ": value " + d.getValue() + "\n";
			dieNum++;
		}
		return rString;
	}
}
