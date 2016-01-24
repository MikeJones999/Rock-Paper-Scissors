package stateMachine;

import java.util.List;

import consoleUI.GameSettings;
import consoleUI.PlayGameUI;
import gameManager.Game;

/**
 * Play State compiles a List of games and passes it from the view (user interface) to the resultState.
 * @author mike
 *
 */

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

	public StateManager getStateManager()
	{	
		return stateManager;
	}

	@Override
	public void initiateState() {
		//call game screen and functions
		PlayGameUI play = new PlayGameUI(gameSettings);
		boolean complete = play.initController();
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
