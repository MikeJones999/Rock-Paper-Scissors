package consoleUI;



import java.util.List;

import gameManager.Game;

/**
 * ResultView - is a view only display on the console.
 * The results from the games played are displayed here.
 * Again no MVC pattern - initController is used to call other methods.
 */

public class ResultView implements Controller{

	private List<Game> gameList;
	//private HashMap<String, int[]> hm;
	private String playerOne;
	private String playerTwo;
	private int playerOneTotalWins;
	private int playerOneIndividualHandWins;
	private int playerTwoTotalWins;
	private int playerTwoIndividualHandWins;
	private int totalDraws;
	

	public int getTotalDraws() {
		return totalDraws;
	}

	public int getPlayerOneTotalWins() {
		return playerOneTotalWins;
	}

	public int getPlayerTwoTotalWins() {
		return playerTwoTotalWins;
	}

    //constructor
	public ResultView(List<Game> gameList) {

		this.gameList = gameList;
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public boolean initController() {
		calculateIndividualWins();
		displayTotalResult();
		displayIndividualGames();
		displayOverallWinner();
		returningToMainMenuDisplay();
		return true;
	}

	private void returningToMainMenuDisplay()
	{
		System.out.println("*************************************************");
		System.out.println("           Returning to Main Menu                ");
		System.out.println("*************************************************");	
	}
	
	/**
	 * Calculates the wins by players of games - NOT HANDS 
	 */
	public void calculateIndividualWins() 
	{	
		boolean playersFound = false;
		int count = 0;
		while(!playersFound)
		{
			if(!gameList.get(count).isDraw())
			{
				playerOne = gameList.get(count).getWinner().getName();
				playerTwo = gameList.get(count).getLooser().getName();
				playersFound = true;
			}
			count++;
		}
		
		for(Game g: gameList)
		{
			if(!g.isDraw())
			{
				if(g.getWinner().getName().equals(playerOne))
				{
					playerOneTotalWins++;
					playerOneIndividualHandWins += g.getWinnerWins();
					playerTwoIndividualHandWins += g.getLooserWins();	
				}
				else if (g.getWinner().getName().equals(playerTwo))
				{
					playerTwoTotalWins++;
					playerTwoIndividualHandWins += g.getWinnerWins();
					playerOneIndividualHandWins += g.getLooserWins();
				}
			}
			else
			{
				totalDraws++;
			}			
		}
	}

	
	/**
	 *  Displays the results of the Games
	 */
	public void displayTotalResult() 
	{		
		if(playerOne.equals("") || playerTwo.equals(""))
			System.out.println("No players set - you have not called - calculateIndividualWins()");
		else
		{		
			System.out.println("*********** RESULTS ***************");
			
			System.out.print(playerOne + " won: " + playerOneTotalWins + " games overall,");
			System.out.println(" whilst they won: " + playerOneIndividualHandWins + " individual hands.");		
			System.out.print(playerTwo + " won: " + playerTwoTotalWins + " games overall,");
			System.out.println(" whilst they won: " + playerTwoIndividualHandWins + " individual hands.");		
			System.out.println("There were: " + totalDraws + " drawn games (NOT HANDS)" );			
		}
	}
	
	/**
	 * Displays the results of each round. NOT GAMES
	 */
	public void displayIndividualGames() {

		int count = 1;
		for(Game g: gameList)
		{
			if(!g.isDraw())
			{
				String winner = g.getWinner().getName();
				System.out.print("Game:" + count + " - ");
				System.out.print("Winner: " + winner);
				System.out.println(" who won: " + g.getWinnerWins()+ " v " + g.getLooserWins());
			}
			else
			{
				System.out.print("Game:" + count + " - ");
				System.out.println("was a draw.");
			}
			count++;
		}
	}

	/**
	 * Displays the overall winner of all games.
	 */
	public void displayOverallWinner() {
		if (playerOneTotalWins > playerTwoTotalWins)
			System.out.println("Overall WINNER ***** " + playerOne + " *****");
		else if (playerOneTotalWins < playerTwoTotalWins)
			System.out.println("Overall WINNER ***** " + playerTwo + " *****");
		else
			System.out.println("IT WAS A DRAW!!!!!!!");		
	}

	
	
	
}
