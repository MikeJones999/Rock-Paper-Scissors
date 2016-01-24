package stateMachine;

/**
 * Interface to be implemented by the three states
 * Another interface was going to be added but was later ignored. Thus this could have been abstract class
 * @author mike
 *
 */

public interface GameState {

	/**
	 * The state requests that the stateManager switch its state and provide a new state to switch to
	 */
	public void updateState();

	/**
	 * initiate this actual state.
	 */
	public void initiateState();
	
	
}
