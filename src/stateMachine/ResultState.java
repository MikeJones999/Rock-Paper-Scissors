package stateMachine;

import java.io.IOException;

public class ResultState implements GameState {

	private StateManager stateManager;

	public ResultState(StateManager stateManager) {
		
		this.stateManager = stateManager;
	}

	@Override
	public void updateState() throws IOException 
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
