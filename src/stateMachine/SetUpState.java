package stateMachine;

import consoleUI.GameSettings;
import consoleUI.SettingsMenu;

/**
 * SetUpState - this is the state this is initially called to start the game running upon each cycle.
 * The setUpstate passes the gameSettings object to the settingsMenu so that it can be populated and passed onto the playState
 * 
 * @author mike
 *
 */

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
		stateManager.switchState(new PlayState(stateManager, gameSettings));	
	}

	@Override
	public void initiateState() {		
		gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		menu.initController();
		updateState();
	}

	public GameSettings getGameSettings() {
		return gameSettings;
	}


}
