package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;
import gameManager.Game;
import stateMachine.ResultState;
import stateMachine.SetUpState;
import stateMachine.StateManager;

public class TestResultState {

	private StateManager man;
	
	@Before
	public void setUp() throws Exception 
	{
		  man = StateManager.getNewInstance();
	}
	
	
	@Test
	public void testResultStateConstructor() 
	{			
		ResultState result = new ResultState(man);
		assertTrue(result.getStateManager() instanceof StateManager);	
	}
	
	@Ignore
	@Test
	public void testResultStateUpdateOfStateSwitchToSetUpState()
	{
		ResultState result = new ResultState(man);
		result.updateState();
		assertTrue(man.getGameState()instanceof SetUpState);		
	}
	
	@Ignore
	@Test
	public void testGetGameResultList()
	{
		List<Game> gameList = new ArrayList<Game>();
		Game g1 = new Game();
		Game g2 = new Game();
		g2.setDraw(true);
		gameList.add(g1);
		gameList.add(g2);		
		ResultState result = new ResultState(man, gameList);
		assertEquals(result.getGameList().get(0).isDraw(), false);
		assertEquals(result.getGameList().get(1).isDraw(), true);
	}
	
	
	@Test
	public void testGetWinnersCount()
	{
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Human");
		player1.setName("Jarvis");
		Player player2 = playFact.getPlayer("Computer");
		player2.setName("AL");	
		
		List<Game> gameList = new ArrayList<Game>();
		Game g1 = new Game();
		Game g2 = new Game();
		Game g3 = new Game();
		Game g4 = new Game();
		Game g5 = new Game();
		
		g1.setWinner(player1);
		g1.setLooser(player2);
		g1.setWinnerWin(3);
		g1.setLooserWins(0);
		gameList.add(g1);
		
		g2.setWinner(player1);
		g2.setLooser(player2);
		g2.setWinnerWin(2);
		g2.setLooserWins(0);
		
		gameList.add(g2);	
		
		g3.setWinner(player1);
		g3.setLooser(player2);
		g3.setWinnerWin(1);
		g3.setLooserWins(0);
		gameList.add(g3);
		
		
		g4.setWinner(player2);
		g4.setLooser(player1);
		g4.setWinnerWin(2);
		g4.setLooserWins(1);
		gameList.add(g4);
		
		g5.setDraw(true);
		gameList.add(g5);
		
		ResultState result = new ResultState(man, gameList);
		result.displayTotalResults();
		
		
	}
	
	@After
	public void tearDown() throws Exception 
	{
		//clears the stateMachine's currentState to null
	    man.setGameState(null);	   
	}
	
	
	
}
