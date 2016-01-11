package stateMachine;

import java.io.IOException;

public class StateManager {

	public static StateManager manager;
	
	private GameState currentState;	
	
	private StateManager(){}	

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

	public void startGameManager() throws IOException {

		if (currentState == null)
		{
			currentState = new SetUpState(this);
		}
	}
	
	public void updateState() throws IOException
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

	@Deprecated
	public void activateState() throws IOException {
		
		if(currentState != null)
		{
			currentState.initiateState();
		}
		
	}








}
