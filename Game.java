//James Bouchat
//CS110-A
//Game.java

/**
 * The Game object is responsible for running the game.
 * It wil handle the flow of the game.
 * ***NOTE***: You may notice scanner.nextLine() not being assigned
 * to any String. This is because scanner.nextInt() scans for
 * the next integer, but does not move to the next line.
 * scanner.nextLine() will move the scanner to the next line.
 * @author James Bouchat
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Game
{
	private final int MAX_ROLLS = 3;
	private final int NUM_TURNS = 13;
	private int numPlayers = 0;
	private DiceRoll dice;
	private Dice savedDice;
	private ArrayList<Player> players;
	private Scanner scanner;
	private CategoryValue cvs[] = {CategoryValue.ONES, CategoryValue.TWOS,
					CategoryValue.THREES, CategoryValue.FOURS, CategoryValue.FIVES,
					CategoryValue.SIXES, CategoryValue.THREE_OF_A_KIND,
					CategoryValue.FOUR_OF_A_KIND, CategoryValue.FULL_HOUSE,
					CategoryValue.SM_STRAIGHT, CategoryValue.LG_STRAIGHT,
					CategoryValue.YAHTZEE, CategoryValue.CHANCE};

	/** Constructor
	 * Initializes dice, player arraylist,
	 * and scanner
	 */
	public Game()
	{
		scanner = new Scanner(System.in);
		initializeDice(5);
		initializePlayers();
	}

	/**
	 * Initializes dice object and adds all die
	 * @param numDice Number of dice to add
	 */
	private void initializeDice(int numDice)
	{
		dice = new DiceRoll();
		savedDice = new Dice(numDice);
	}

	/**
	 * Set number of players and set player names
	 */
	private void initializePlayers()
	{
		System.out.println("How many players are playing?");
		while(numPlayers <= 0)
		{
			try
			{
				numPlayers = scanner.nextInt();
				scanner.nextLine();
				if(numPlayers <= 0)
					System.out.println("Please enter a positive integer");
			}
			catch(Exception e)
			{
				System.out.println("Please enter a valid number");
				scanner.nextLine();	
			}
		}
		players = new ArrayList<>(numPlayers);
		for(int i = 1; i <= numPlayers; i++)
		{
			try
			{
				System.out.println("Enter player " + i + "s name: ");
				String name = scanner.nextLine();
				players.add(new Player(name));
			}
			catch(Exception e)
			{
				System.out.println("Please enter a valid name");
				i--;
			}
		}
	}

	/**
	 * Runs the game of Yahtzee. Ends when all players
	 * have filled their scorecards.
	 */
	public void playGame()
	{
		System.out.println("*************************************************");
		System.out.println("                WELCOME TO YAHTZEE               ");
		System.out.println("*************************************************\n");

		for(int i = 1; i <= 13; i++)
		{
			for(Player p : players)
			{
				int rolls = 1;
				boolean scored = false;
				boolean error = false;
				System.out.println(p.getName() + ":");
				System.out.println("Current Scorecard:");
				System.out.println(p.getScorecard());
				System.out.println("Dice to reroll");
				System.out.println(dice);

				while(rolls < MAX_ROLLS && !scored)
				{
					if(!error) //Dont print help text again if ther was an error
						printHelpText();
					error = false; //Reset error flag

					String action = scanner.nextLine();
					if(action.equals(""))
					{
						System.out.println("Please enter an action");
						error = true;
					}
					else if(action.charAt(0) == '[' && 
							action.charAt(action.length()-1) == ']')
					{
						if(saveDice(action))
						{
							System.out.println("Dice to reroll");
							System.out.println(dice);
							System.out.println("Dice to save");
							System.out.println(savedDice);
						}
						else
						{
							error = true;
							System.out.println("Please enter a list of valid" + 
									" indicies seperated by a space");
							scanner.reset();
						}
					}
					else if(action.equals("roll"))
					{
						rolls++;
						dice.toss();
						if(rolls == MAX_ROLLS)
							System.out.println("Final roll:");
						else
						{
							System.out.println("Current Scorecard:");
							System.out.println(p.getScorecard());
							System.out.println("Dice to reroll");
							System.out.println(dice);
							if(savedDice.getNumDice() != 0)
							{
								System.out.println("Dice to save");
								System.out.println(savedDice);
							}
						}
					}
					else if(action.equals("score"))
					{
						scored = true; //Exit loop
					}
					else
					{
						error = true;
						System.out.println("Please enter a valid action");
					}
				}
				//Place all die in savedDice
				for(int j = dice.getNumDice()-1; j >= 0; j--)
				{
					savedDice.addDie(dice.getDie(j));
					dice.removeDie(j);
				}
				System.out.println(savedDice);
				System.out.println("Select a category that you have not" +
						" scored in yet:");
				printEvaluatedScorecard(p.getScorecard(), savedDice);
				int pick = 0;
				while(pick < 1 || pick > NUM_TURNS)
				{
					try
					{
						pick = scanner.nextInt();
						cvs[pick-1] = cvs[pick-1]; //Trigger IndexOutOfBounds
						while(p.getScorecard().checkScored(cvs[pick-1]))
						{
							System.out.println("That category has already been scored." 
									+ " Please enter an available category");
							pick = scanner.nextInt();
						}
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Please enter a valid category number");
					}
					catch(InputMismatchException ime)
					{
						System.out.println("Please enter an integer value");
						scanner.nextLine();
					}
				}
				scanner.nextLine();
				System.out.println("You scored " +
						p.getScorecard().getEvaluation(cvs[pick-1], savedDice) +
						" points in " + cvs[pick-1]);
				p.getScorecard().choose(cvs[pick-1], savedDice);
				resetDice();
				System.out.println("\n\n**********************" +
						"***************************\n\n");
			}
		}

		int highScore = 0;
		String name = "";
		for(Player p : players)
		{
			if(p.getScorecard().score() > highScore)
			{
				highScore = p.getScorecard().score();
				name = p.getName();
			}
		}
		if(players.size() > 1)
			System.out.println(name + " wins with a score of " + highScore + "!");
		else
			System.out.println("You scored " + highScore + " points!");
	}

	/**
	 * Determines which die should be saved from rolling
	 * @param string holding index of die to be saved
	 *	@return Dice saved successfully
	 */
	private boolean saveDice(String list)
	{
		int index = 0;
		ArrayList<Integer> indicies = new ArrayList<>();	
		for(int i = 1; i < list.length()-1; i++) //Skip first and last indicies
		{	
			if(Character.isDigit(list.charAt(i))) //Is the char an int?
			{
				if(list.charAt(i+1) == ' ' || list.charAt(i+1) == ']')
				{
					index = list.charAt(i) - '0'; //Subtract ASCII values
					indicies.add(index - 1);
				}
				else
					return false;	
			}
		}
		sort(indicies);
		for(int i : indicies)
			if(i > dice.getNumDice()-1 || i < 0) //Index out of bounds?
				return false;
		for(int i = indicies.size()-1; i >= 0; i--)
		{
			savedDice.addDie(dice.getDie(indicies.get(i)));
			dice.removeDie(indicies.get(i));
		}
		return true;
	}

	/**
	 * ArrayList implementation of selection sort
	 * @param list ArrayList of integers
	 */
	public void sort(ArrayList<Integer> list)
	{
		int length = list.size();
		for(int i = 0; i < length-1; i++)
		{
			int minIndex = i;
			for(int j = i+1; j < length; j++)
				if(list.get(j) < list.get(minIndex))
					minIndex = j;
			int min = list.get(minIndex);
			list.set(minIndex, list.get(i));
			list.set(i, min);
		}
	}

	/**
	 * Resets Dice containers
	 */
	private void resetDice()
	{
		savedDice = new Dice();
		dice = new DiceRoll();
	}

	/**
	 * Prints help text
	 */
	private void printHelpText()
	{
		System.out.println("Save dice with [  ] filled with index"
				+ " values seperated by spaces\n'roll' to reroll"
				+ ", 'score' to score");
	}

	/**
	 * Print scorecard with evaluated scores
	 */
	private void printEvaluatedScorecard(Scorecard scorecard, Dice dice)
	{
		for(int i = 1; i <= NUM_TURNS; i++)
		{
			if(!scorecard.checkScored(cvs[i-1]))
			{
				System.out.println(i + ": " + cvs[i-1] + ", " +
						scorecard.getEvaluation(cvs[i-1], dice) + " points");
			}	
		}
	}
}
