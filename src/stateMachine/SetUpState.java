package stateMachine;

import java.io.IOException;

import consoleUI.GameSettings;
import consoleUI.SettingsMenu;

public class SetUpState implements GameState {

	private StateManager stateManager;
	private GameSettings gameSettings;

	
	public SetUpState(StateManager man) throws IOException 
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
	public void initiateState() throws IOException {
		
		gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
	
		//oncompletion - updateState();
	}

	public GameSettings getGameSettings() {
		return gameSettings;
	}


}
