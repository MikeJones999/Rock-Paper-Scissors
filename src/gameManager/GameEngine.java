package gameManager;

import stateMachine.GameState;
import stateMachine.StateManager;

public class GameEngine {

	private StateManager stateManager;
	
	public GameEngine(StateManager man) 
	{
		this.stateManager = man;
		startStateManager();
		
	}


	public StateManager getStateManager() 
	{
		return stateManager;
	}	
	

	private void startStateManager() 
	{
		stateManager.startGameManager();
		
	}


	public GameState getCurrentGameState() 
	{
		return stateManager.getGameState();
	}




	

}
