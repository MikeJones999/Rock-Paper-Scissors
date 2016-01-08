package stateMachine;

public class PlayState implements GameState {

<<<<<<< HEAD
	
	
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
=======
	public PlayState(StateManager stateManager) 
	{
		
		
	}

	@Override
	public void updateState() {
		
		
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
	}

}
