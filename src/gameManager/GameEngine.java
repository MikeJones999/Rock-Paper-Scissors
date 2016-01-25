package gameManager;



import stateMachine.GameState;
import stateMachine.StateManager;

/**
 * 
 * Game Engine class...
 * This is the main object required to run the game. It takes one StateManager object to run.
 * Once created the game Engine calls its statemanagers startGame method. 
 * This in turn starts the game process, beginning with the setupState. 
 * The StateManager then moves through the states following the completion of each state. 
 * The same StateManager is used throughout the gameEngines instance. 
 *
 * @author mike
 *
 */

public class GameEngine {

	private StateManager stateManager;
	
	public GameEngine(StateManager man)  
	{
		this.stateManager = man;
		//startStateManager();	
	}

	//Used only for Testing purposes
	public StateManager getStateManager() 
	{
		return stateManager;
	}	
	
	/**
	 * Calls the stateManager's startGame Method. 
	 * Can only be called once. Game process will start
	 */
	public void startStateManager()
	{
		stateManager.startGame();		
	}

	//Used only for Testing purposes
	public GameState getCurrentGameState() 
	{
		return stateManager.getGameState();
	}




	

}
