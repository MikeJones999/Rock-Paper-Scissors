package gameManager;

import stateMachine.StateManager;
/**
 * This class calls creates the GameEngine object and obtains an instance of the stateManager.
 * The start method is then called to initiate the game.
 * @author mike
 *
 */

public class InitiateGame {

	public static void main(String[] args) {

		StateManager man = StateManager.getNewInstance();
		GameEngine game = new GameEngine(man);
		game.startStateManager();
	}

}
