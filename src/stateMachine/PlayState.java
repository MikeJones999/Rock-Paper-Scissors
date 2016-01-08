package stateMachine;

public class PlayState implements GameState {

	
	
	private StateManager stateManager;

	public PlayState(StateManager stateManager) 
	{
		this.stateManager = stateManager;		
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
	}

}
