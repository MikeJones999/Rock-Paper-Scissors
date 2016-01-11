package stateMachine;

import consoleUI.GameSettings;
import consoleUI.SettingsMenu;

public class SetUpState implements GameState {

	private StateManager stateManager;
	private GameSettings gameSettings;

	
	public SetUpState(StateManager man) 
	{		
		this.stateManager = man;
		initiateState();
	}

	public StateManager getStateManager() 
	{
		return stateManager;
	}

	@Override
	public void updateState() 
	{		
		stateManager.switchState(new PlayState(stateManager));	
	}

	@Override
	public void initiateState() {
		
		gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
	
		//oncompletion - updateState();
	}

	public GameSettings getGameSettings() {
		return gameSettings;
	}


}
