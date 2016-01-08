package stateMachine;

public class ResultState implements GameState {

	private StateManager stateManager;

	public ResultState(StateManager stateManager) {
		
		this.stateManager = stateManager;
	}

	@Override
	public void updateState() 
	{
			stateManager.switchState(new SetUpState(stateManager));	
	}

	@Override
	public void initiateState() {
	
		
	}


	public StateManager getStateManager() {
		return stateManager;
	}

}
