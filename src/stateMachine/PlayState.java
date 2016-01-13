package stateMachine;

import consoleUI.GameSettings;
import consoleUI.PlayGameUI;

public class PlayState implements GameState {

		
	private StateManager stateManager;
	private GameSettings gameSettings;

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
		stateManager.switchState(new ResultState(stateManager));		
	}

	public StateManager getStateManager() {
	
		return stateManager;
	}

	@Override
	public void initiateState() {

		//call game screen and functions
		
		//can pass players through, and rounds. rather than gamesettings
		//PlayGameUI playManager = new PlayGameUI(gameSettings);
		//playManager.getResults();
	}

	public GameSettings getGameSettings() 
	{
		return gameSettings;
	}

}
