package stateMachine;

/**
 * StateManager class is a singleton...
 * Once this object is created it will continue its life until the GameEngine Object it was passed through finishes.
 * The stateManager cycles in the following sequence...
 * SetUpState, PlayState, ResultState
 * Each state updates the statemanager when it is ready to do so. 
 * @author mike
 *
 */
public class StateManager {

	public static StateManager manager;
	
	private GameState currentState;	
	
	private StateManager(){}	

	/**
	 * Obtain access to the stateManager - this is a singleton
	 * Only one object created and returned. This method returns the StateManager in existance. 
	 * @return stateManager
	 */
	public static StateManager getNewInstance() 
	{
		if(manager == null)
		{
			manager = new StateManager();
		}
		
		return manager;					
	}

	/**
	 * Sets the statemanager's current state to a new state
	 * @param GameState - current assigned to StateManager
	 */
	public void setGameState(GameState currentState) {

		this.currentState = currentState;
	}

	/**
	 * Returns the current stateManager's gameState
	 * @return
	 */
	public GameState getGameState() 
	{
		return currentState;
	}

	/**
	 * This method initiates the stateManager and creates a new setUpState object. 
	 * The newly created SetUpState Object becomes the statemanager's current gameState
	 */
	public void startGame() {

		if (currentState == null)
		{
			currentState = new SetUpState(this);
		}
	}
	
	/**
	 * Calls an update on the gameStates updateState method.
	 */
	public void updateState()
	{
		if(currentState != null)
		{
			currentState.updateState();
		}
	}

	/**
	 * Switches the current stateManager's GameState
	 * @param GameState
	 */
	public void switchState(GameState newState) 
	{		
		currentState = newState;
	}

	@Deprecated
	public void activateState() {
		
		if(currentState != null)
		{
			currentState.initiateState();
		}		
	}








}
