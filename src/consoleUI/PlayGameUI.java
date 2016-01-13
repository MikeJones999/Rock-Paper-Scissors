package consoleUI;

import java.util.ArrayList;
import java.util.List;

import gameManager.Game;

public class PlayGameUI {

	private GameSettings gameSettings;
	private List<Game> gameList;
	private Game currentGame;
	
	public PlayGameUI(GameSettings gameSettings) {
		this.gameSettings = gameSettings;
	}

	public GameSettings getGameSettings() {
		return gameSettings;
	}

	public List<Game> getGameResults() {

		return gameList;
	}

	public void initiateUI() {
		
		this.gameList = new ArrayList<>();

	}

	public void startNewGame() {

		Game game = new Game();		
		this.currentGame = game;
	}
	
	
	public void addNewGame(Game game)
	{
		gameList.add(game);
	}
	
	

}
