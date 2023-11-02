//James Bouchat
//CS110-A
//Scorecard.java

/**
 * the Scorecard class is a collection of
 * categories, as well as score of top/bottom
 * and total
 * @author James Bouchat
 */

import java.util.ArrayList;

public class Scorecard
{
	private ArrayList<Category> scorecard;
	private int yahtzeeBonus = 100;
	private final int NUM_CATS = 13;

	/** Constructor
	 * Creates all category objects and
	 * adds to the ArrayList
	 */
	public Scorecard()
	{
		scorecard = new ArrayList<>(NUM_CATS);
		scorecard.add(new Ones());
		scorecard.add(new Twos());
		scorecard.add(new Threes());
		scorecard.add(new Fours());
		scorecard.add(new Fives());
		scorecard.add(new Sixs());
		scorecard.add(new ThreeOfAKind());
		scorecard.add(new FourOfAKind());
		scorecard.add(new FullHouse());
		scorecard.add(new SmallStraight());
		scorecard.add(new LargeStraight());
		scorecard.add(new Yahtzee());
		scorecard.add(new Chance());
	}

	/**
	 * Choose which category you want to score
	 * @param cv Used to get appropriate category
	 * @param d Used to help evaluate category
	 */
	public void choose(CategoryValue cv, Dice d)
	{
		scorecard.get(cv.getValue()).addValue(d);	
	}

	/**
	 * Return the score that would be achieved
	 * in this category with the provided Dice object
	 * @param cv Used to get appropriate category
	 * @param d Used to help evaluate category
	 * @return value that would be achieved
	 */
	public int getEvaluation(CategoryValue cv, Dice d)
	{	
		return scorecard.get(cv.getValue()).evaluate(d);
	}

	/**
	 * Return true if Category has been used, false
	 * otherwise
	 * @param cv Category to check
	 * @return has been used or not
	 */
	public boolean checkScored(CategoryValue cv)
	{
		return scorecard.get(cv.getValue()).getUsed();
	}

	/**
	 * Return the current score for the specified
	 * Category
	 * @param cv Category to retrieve value from
	 * @return value
	 */
	public int getCategoryScore(CategoryValue cv)
	{
		return scorecard.get(cv.getValue()).getScore();
	}

	/**
	 * Return the total score for the top of the
	 * scorecard
	 * @return total top score
	 */
	public int scoreTop()
	{
		int total = 0;
		for(int i = 0; i <= 5; i++)
		{
			total += scorecard.get(i).getScore();
		}
		return total;
	}

	/**
	 * Return the total score for the bottom
	 * of the scorecard
	 * @return total bottom score
	 */
	public int scoreBottom()
	{
		int total = 0;
		for(int i = 6; i <= 12; i++)
		{
			total += scorecard.get(i).getScore();
		}
		return total;
	}

	/**
	 * Return the total score for the scorecard
	 * @return absolute total score
	 */
	public int score()
	{
		return scoreTop() + scoreBottom();
	}

	/**
	 * Creates a formatted string to represent
	 * all the information for a players scorecard
	 * @return formatted scorecard string
	 */
	@Override
	public String toString()
	{
		CategoryValue cv1 = CategoryValue.ONES;
		CategoryValue cv2 = CategoryValue.TWOS;
		CategoryValue cv3 = CategoryValue.THREES;
		CategoryValue cv4 = CategoryValue.FOURS;
		CategoryValue cv5 = CategoryValue.FIVES;
		CategoryValue cv6 = CategoryValue.SIXES;
		CategoryValue cv7 = CategoryValue.THREE_OF_A_KIND;
		CategoryValue cv8 = CategoryValue.FOUR_OF_A_KIND;
		CategoryValue cv9 = CategoryValue.FULL_HOUSE;
		CategoryValue cv10 = CategoryValue.SM_STRAIGHT;
		CategoryValue cv11 = CategoryValue.LG_STRAIGHT;
		CategoryValue cv12 = CategoryValue.YAHTZEE;
		CategoryValue cv13 = CategoryValue.CHANCE;	
		return String.format("%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n" +
				"%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n" + 
				"%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n" + 
				"%15s: %d\n%15s: %d\n%15s: %d\n%15s: %d\n",
				cv1, getCategoryScore(cv1),
				cv2, getCategoryScore(cv2),
				cv3, getCategoryScore(cv3),
				cv4, getCategoryScore(cv4),
				cv5, getCategoryScore(cv5),
				cv6, getCategoryScore(cv6),
				cv7, getCategoryScore(cv7),
				cv8, getCategoryScore(cv8),
				cv9, getCategoryScore(cv9),
				cv10, getCategoryScore(cv10),
				cv11, getCategoryScore(cv11),
				cv12, getCategoryScore(cv12),
				cv13, getCategoryScore(cv13),
				"Upper Total", scoreTop(),
				"Lower Total", scoreBottom(),
				"Total", score());
	}
}
