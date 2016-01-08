package stateMachine;


public class StateManager {

	public static StateManager manager;
	
	private GameState currentState;	
	
	private StateManager()
	{
		
	}	

	public static StateManager getNewInstance() 
	{
		if(manager == null)
		{
			manager = new StateManager();
		}
		
		return manager;					
	}

	public void setGameState(GameState currentState) {

		this.currentState = currentState;
	}

	public GameState getGameState() 
	{
		return currentState;
	}

	public void startGameManager() {

		if (currentState == null)
		{
			currentState = new SetUpState(this);
		}
	}
	
	public void updateState()
	{
		if(currentState != null)
		{
			currentState.updateState();
		}
	}

	public void switchState(GameState newState) 
	{		
		currentState = newState;
	}

	public void activateState() {
		
		if(currentState != null)
		{
			currentState.initiateState();
		}
		
	}








}
