package consoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GameObjs.GameObj;
import GameObjs.GameObjectChoice;
import GameObjs.NullObj;
import PlayerObjs.Human;
import PlayerObjs.Player;
import gameManager.Game;


/**
 * This is the PlayGameUI class - user Interface for the playing of the actual game.
 * Supposed to have used a MVC design pattern.
 * However time restrictions - use controller method instead to call and run other methods.
 * Model - data held in the passed GameSettings
 * view is a console display and input. 
 * Class is passed the gameSettings setup during initial setUpState. 
 */


public class PlayGameUI implements Controller {

	private GameSettings gameSettings;
	private List<Game> gameList;
	private Game currentGame;
	private int rounds = 0;
	
	private Player player1;
	private Player player2;
	
	public PlayGameUI(GameSettings gameSettings) {
		this.gameSettings = gameSettings;	
		initiateArray();
		setPlayersAndRounds();
	}

	public GameSettings getGameSettings() {
		return gameSettings;
	}

	public List<Game> getGameResults() {
		return gameList;
	}

	public void initiateArray() {		
		this.gameList = new ArrayList<>();
	}

	
	public void createNewGame()
	{
		Game game = new Game();
		this.currentGame = game;
		currentGame.setRounds(gameSettings.getGameRounds());
	}
	
	public void setPlayersAndRounds() {
	
		createNewGame();		
		this.rounds = gameSettings.getGameRounds();
		this.player1 = gameSettings.getPlayerOne();
		this.player2 = gameSettings.getPlayerTwo();
	}	
	
	/**
	 * Adds a completed game to the gameList so that it can be passed later to the resultView.
	 * @param Game
	 */
	public void addGameToList(Game game)
	{
		gameList.add(game);
	}

	
	public Game getCurrentGame() {
		return currentGame;
	}

	/**
	 * Initiates the user Interface for this current interaction
	 * Calls teh PlayGame method to start the game 
	 * adds competed games to the arrayList of Games
	 * @return boolean once complete
	 */
	public boolean initController() 
	{		
		boolean gameComplete = false;
		boolean session = false;
		while(!gameComplete || !session)
		{
			System.out.println("Game will start in a moment...");
			System.out.println("You have chosen " + gameSettings.getGameRounds() + " rounds per game.");
			System.out.println("Once the game is complete you will be asked if you wish to play another game with the same settings.");
			System.out.println("Game will now start...");
						
			gameComplete = playGame();
			//a single Game has been completed
			if (gameComplete)
			{
				addGameToList(currentGame);
			};
			session = endSessionAndExit();
			//if player chooses to play again - new Game
			if (!session)
			{
				createNewGame();
			}
		}
		return true;
	}

	/**
	 * Starts the games and continues through each round until the game round count stipulated in gamesSetting is met.
	 * @return boolean once complete
	 */
	public boolean playGame(){
		
		int p1Count = 0;
		int p2Count = 0;
		int draw = 0;
		boolean complete = false;
		int count = 1;
				
		while(count != rounds+1)
		{
			System.out.println("**************  Round: " + count + "  ***********************");
			
			displayGameObjectsOfChoice(player1);
			GameObj p1Obj = playerMakeAChoiceOfGameObject(player1);
			System.out.println("------- " + player1.getName() + " has made their choice" + "------- ");
			System.out.println("");
			displayGameObjectsOfChoice(player2);
			GameObj p2Obj = playerMakeAChoiceOfGameObject(player2);
			System.out.println("------- " + player2.getName() + " has made their choice" + "------- ");
			System.out.println("");
			System.out.print(player1.getName()+ " chose: " + p1Obj.toString() + ", ");
			System.out.println(player2.getName()+ " chose: " + p2Obj.toString());
			
			int res = p1Obj.beats(p2Obj);
			switch(res)
			{
				case(0): {draw++; System.out.println("Result: draw\n");break;}
				case(1): {p1Count++; System.out.println("Result: " + player1.getName() + " wins!!!!!!!!\n"); break;}
				case(-1): {p2Count++; System.out.println("Result: " + player2.getName() + " wins!!!!!!!\n"); break;}
			}
			
			count++;
		}		
		calculateWinnerFromScore(p1Count, p2Count, draw);
		complete = true;
		return complete;
	}
	
	/**
	 * Displays teh available game objects from which a user can choose. 
	 * @param Player
	 */
	public void displayGameObjectsOfChoice(Player player)
	{
		System.out.println(player.getName() + " : please choose and type one of the following...");
		GameObjectChoice[] gameObjectChoiceArr = GameObjectChoice.getAllGameObjects();
		for (int i = 0; i < gameObjectChoiceArr.length; i++)
		{
			System.out.print(gameObjectChoiceArr[i]);
			if(i != gameObjectChoiceArr.length - 1)
			{
				System.out.print(", ");
			}
		}
		System.out.print("\n");
	}
	
	/**
	 * Returns the gameObject chosen by the player.
	 * This method distinguishes between human and computer so that computer can make its own choice.
	 * This will exit once a correct gameObject type has been chosen.
	 * @param player
	 * @return GameObj
	 */
	public GameObj playerMakeAChoiceOfGameObject(Player player)
	{
		boolean complete = false;		
		GameObj obj = null;
		while (!complete)
		{
			if(player instanceof Human)
			{
				Scanner scan = new Scanner(System.in);
				String line = scan.nextLine();
				obj = player.chooseGameObj(line);
				if( !(obj instanceof NullObj))
				{
					complete = true;
				}
			}
			else
			{
				obj = player.chooseGameObj("NULL");
				complete = true;
			}
		}	
		return obj;
	}

	/**
	 * Calculates for each game the total winner, loser, and draws
	 * @param player1 scores int
	 * @param player2 scores int
	 * @param draw scores int
	 */
	public void calculateWinnerFromScore(int p1, int p2, int draw) {
		if(draw > p1 && draw > p2)
		{
			currentGame.setDraw(true);
		}
		else if(p1 > p2)
		{
			currentGame.setWinner(player1);
			currentGame.setWinnerWin(p1);			
			currentGame.setLooser(player2);
			currentGame.setLooserWins(p2);
		}
		else
		{
			currentGame.setWinner(player2);
			currentGame.setWinnerWin(p2);
			currentGame.setLooser(player1);
			currentGame.setLooserWins(p1);
		}			
	}

	/**
	 * Checks to see whether another game is to be player or not
	 * @return true for another game, false to exit
	 */
	public boolean endSessionAndExit() {

		boolean endSession = false;
		boolean complete = false;
		
		while (!complete)
		{
			System.out.println("Would you like to play another game? Y/N ");
			Scanner scan = new Scanner(System.in);
			String line = scan.nextLine();		
			if(line.equalsIgnoreCase("Y"))
			{
				complete = true;
				System.out.println("***DEBUG*** Chose to play again");				
			}
			else if(line.equalsIgnoreCase("N"))
			{
				endSession = true;
				complete = true;
			}
			else
			{
				System.out.println("Please enter a correct respone - Y or N");
			}			
		}
		return endSession;	
	}
}
