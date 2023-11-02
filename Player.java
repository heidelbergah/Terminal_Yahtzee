//James Bouchat
//CS110-A
//Player.java

/**
 * The Player class contains a scorecard and a
 * name. Players have the ability to role dice,
 * choose which ones to keep or roll again, and 
 * select a category to fill out.
 * @author James Bouchat
 */
public class Player
{
	private static int playerNum = 1;
	private Scorecard scorecard;
	private String name;

	/** Constructor
	 * Initializes scorecard and
	 * sets player name to default value
	 */
	public Player()
	{
		scorecard = new Scorecard();
		name = "Player" + playerNum;
		playerNum++;
	}

	/** Constructor
	 * Initializes scorecard and sets
	 * player name to specified value
	 * @param name Name of player
	 */
	public Player(String name)
	{
		scorecard = new Scorecard();
		this.name = name;
		playerNum++;
	}

	/**
	 * Gets name of player
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the scorecard of player
	 * @return scorecard
	 */
	public Scorecard getScorecard()
	{
		return scorecard;
	}
}
