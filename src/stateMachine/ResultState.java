package stateMachine;

import java.io.IOException;
import java.util.List;

import PlayerObjs.Player;
import gameManager.Game;

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
	}
	
	@Override
	public void updateState() 
	{
		stateManager.switchState(new SetUpState(stateManager));	
	}

	@Override
	public void initiateState() {
	
		
	}


	public StateManager getStateManager() {
		return stateManager;
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public void displayTotalResults() {
		
		int playerOneTotalWins = 0;
		int playerOneIndividualHandWins = 0;
		int playerOneIndividualsHandLoses = 0;
		int playerTwoTotalWins = 0;
		int playerTwoIndividualHandWins = 0;
		int playerTwoIndividualsHandLoses = 0;


		int totalDraws = 0;
		
		String playerOne = gameList.get(0).getWinner().getName();
		String playerTwo = gameList.get(0).getLooser().getName();
		
		for(Game g: gameList)
		{
			if(!g.isDraw())
			{
				if(g.getWinner().getName().equals(playerOne))
				{
					playerOneTotalWins++;
					playerOneIndividualHandWins =+ g.getWinnerWins();
					playerOneIndividualsHandLoses =+ g.getWinnerLoses();
					playerTwoIndividualHandWins =+ g.getLooserWins();

				}
				else if (g.getWinner().getName().equals(playerTwo))
				{
					playerTwoTotalWins++;
					playerTwoIndividualHandWins =+ g.getWinnerWins();
					playerTwoIndividualsHandLoses =+ g.getWinnerLoses();
					playerOneIndividualHandWins =+ g.getLooserWins();

				}
			}
			else
			{
				totalDraws++;
			}
			
		}
		
		System.out.print(playerOne + " won: " + playerOneTotalWins + " games overall,");
		System.out.println(" whilst they won: " + playerOneIndividualHandWins + " individual hands.");

		System.out.print(playerTwo + " won: " + playerTwoTotalWins + " games overall,");
		System.out.println(" whilst they won: " + playerTwoIndividualHandWins + " individual hands.");

		System.out.println("There were: " + totalDraws + " drawn games" );
		

	}

}
