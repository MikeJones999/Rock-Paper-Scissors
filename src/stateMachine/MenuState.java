package stateMachine;

public class MenuState implements GameState {

	private StateManager stateManager;

	
	public MenuState(StateManager man) 
	{		
		this.stateManager = man;
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


}
