package stateMachine;

import java.util.List;

import consoleUI.ResultView;
import gameManager.Game;

/**
 * Result state deals with the transformation from Play state to ResultView (user interface)
 * The gameList containing all the completed games is passed to the ResultView object so that it can display all results
 * @author mike
 *
 */

public class ResultState implements GameState {

	private StateManager stateManager;
	private List<Game> gameList;

	public ResultState(StateManager stateManager) {		
		this.stateManager = stateManager;
	}

	public ResultState(StateManager stateManager, List<Game> gameArr)
	{
		this.stateManager = stateManager;
		this.gameList = gameArr;
		initiateState();
	}
	
	@Override
	public void updateState() 
	{
		stateManager.switchState(new SetUpState(stateManager));	
	}

	@Override
	public void initiateState() {			
		ResultView resV = new ResultView(gameList);
		resV.initController();
		updateState();
	}


	public StateManager getStateManager() {
		return stateManager;
	}

	public List<Game> getGameList() {
		return gameList;
	}



}
