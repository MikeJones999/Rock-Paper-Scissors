package JunitTests.ConsoleLineUI;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;
import consoleUI.ResultView;
import gameManager.Game;

public class TestResutView {

	private List<Game> gameList;
	private Game g1; 
	private Game g2; 
	private Game g3;
	private Game g4;
	private Game g5;
	private PlayerFactory playFact;
	private Player player1;
	private Player player2;

	
	@Before
	public void setUp() throws Exception {
		
		playFact = new PlayerFactory();
		player1 = playFact.getPlayer("Human");
		player1.setName("Jarvis");
		player2 = playFact.getPlayer("Computer");
		player2.setName("AL");
				
		
		gameList = new ArrayList<Game>();
		
		g1 = new Game();
		g2 = new Game();
		g3 = new Game();
		g4 = new Game();
		g5 = new Game();
		
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
		
	}

	@After
	public void tearDown() throws Exception {
		
		gameList.clear();
		playFact = null;
	}

	@Test
	public void testCallingResultViewAndPassingThroughGameList()
	{		
		ResultView resV = new ResultView(gameList);
		assertEquals(resV.getGameList(), gameList);		
	}

	
	@Test
	public void testGetGameResultList()
	{
		ResultView result = new ResultView(gameList);
		assertEquals(result.getGameList().get(0).isDraw(), false);
		assertEquals(result.getGameList().get(4).isDraw(), true);
	}
	
	@Ignore
	@Test
	public void testGetIndividualsTotalWinsAndHands()
	{
		ResultView result = new ResultView(gameList);
		result.calculateIndividualWins();	
		assertEquals(result.getPlayerOneTotalWins(), 3);
		assertEquals(result.getPlayerTwoTotalWins(), 3);				
	}

	@Ignore
	@Test
	public void testDisplayTotalResult()
	{
		ResultView result = new ResultView(gameList);
		result.calculateIndividualWins();	
		result.	displayTotalResult();	
		assertTrue(true);
		//visual inspection	
	}

	
	@Ignore
	@Test
	public void testDisplayIndividualGameResults()
	{
		ResultView result = new ResultView(gameList);
		result.calculateIndividualWins();	
		result.	displayIndividualGames();	
		assertTrue(true);
		//visual inspection			
	}
	
	@Ignore
	@Test
	public void testDisplayOverallWinner()
	{
		ResultView result = new ResultView(gameList);
		result.calculateIndividualWins();	
		result.displayOverallWinner();	
		assertTrue(true);
		//visual inspection			
	}
	
	@Test
	public void testCallToControllerToDisplayAllResults()
	{
		ResultView result = new ResultView(gameList);		
		result.initController();	
		assertTrue(true);
		//visual inspection			
	}
	
	
	
	
	
}
