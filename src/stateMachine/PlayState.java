package stateMachine;

import java.util.List;

import consoleUI.GameSettings;
import consoleUI.PlayGameUI;
import gameManager.Game;

public class PlayState implements GameState {

		
	private StateManager stateManager;
	private GameSettings gameSettings;
	private List<Game> results;

	public PlayState(StateManager stateManager) 
	{
		this.stateManager = stateManager;	
		initiateState();
	}

	public PlayState(StateManager stateManager, GameSettings gameSettings)
	{
		this.stateManager = stateManager;
		this.gameSettings = gameSettings;
		initiateState();
	}

	@Override
	public void updateState() 
	{
		stateManager.switchState(new ResultState(stateManager, results));		
	}

	public StateManager getStateManager() {
	
		return stateManager;
	}

	@Override
	public void initiateState() {
		//call game screen and functions
		
		//can pass players through, and rounds. rather than gamesettings
		PlayGameUI play = new PlayGameUI(gameSettings);
		boolean complete = play.playGameController();
		if (complete){this.results = play.getGameResults();}
		updateState();
	}

	public List<Game> getResults() {
		return results;
	}

	public GameSettings getGameSettings() 
	{
		return gameSettings;
	}

}
