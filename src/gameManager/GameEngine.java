package gameManager;

import java.io.IOException;

import stateMachine.GameState;
import stateMachine.StateManager;

public class GameEngine {

	private StateManager stateManager;
	
	public GameEngine(StateManager man) throws IOException 
	{
		this.stateManager = man;
		startStateManager();
		
	}


	public StateManager getStateManager() 
	{
		return stateManager;
	}	
	

	private void startStateManager() throws IOException 
	{
		stateManager.startGameManager();
		
	}


	public GameState getCurrentGameState() 
	{
		return stateManager.getGameState();
	}




	

}
