package stateMachine;


public class StateManager {

	static StateManager manager;
	
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
			currentState = new MenuState(this);
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








}
