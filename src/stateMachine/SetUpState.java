package stateMachine;

public class SetUpState implements GameState {

	private StateManager stateManager;

	
	public SetUpState(StateManager man) 
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

	@Override
	public void initiateState() {
		
		//call menu screen
		
	}


}
