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

public class PlayGameUI {

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
	
	
	public void addGameToList(Game game)
	{
		gameList.add(game);
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public boolean playGameController() {
		
		
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
			System.out.println(player1.getName() + " has made their choice");
			displayGameObjectsOfChoice(player2);
			GameObj p2Obj = playerMakeAChoiceOfGameObject(player2);
			System.out.println(player2.getName() + " has made their choice");
			System.out.print(player1.getName()+ " chose: " + p1Obj.toString() + ", ");
			System.out.println(player2.getName()+ " chose: " + p2Obj.toString());
			
			int res = p1Obj.beats(p2Obj);
			switch(res)
			{
				case(0): {draw++; System.out.println("Result: draw");break;}
				case(1): {p1Count++; System.out.println("Result: " + player1.getName() + " wins"); break;}
				case(-1): {p2Count++; System.out.println("Result: " + player2.getName() + " wins"); break;}
			}
			count++;
		}
		
		calculateWinnerFromScore(p1Count, p2Count, draw);
		complete = true;
		return complete;
	}
	
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
