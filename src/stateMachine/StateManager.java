package stateMachine;


public class StateManager {

<<<<<<< HEAD
	public static StateManager manager;
=======
	static StateManager manager;
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
	
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
<<<<<<< HEAD
			currentState = new SetUpState(this);
=======
			currentState = new MenuState(this);
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
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

<<<<<<< HEAD
	public void activateState() {
		
		if(currentState != null)
		{
			currentState.initiateState();
		}
		
	}

=======
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0







}
