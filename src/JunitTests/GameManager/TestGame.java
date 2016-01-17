package JunitTests.GameManager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;
import gameManager.Game;

public class TestGame {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturnPlayerWinner() {
		
		Game game = new Game();
		Player winner = game.getWinner();
		assertEquals(winner, null);	
	}
	
	@Test
	public void testSetAndGetPlayerWinner()
	{
		Game game = new Game();
		PlayerFactory playFact = new PlayerFactory();			
		Player p1 = playFact.getPlayer("Human");
		game.setWinner(p1);
		assertEquals(game.getWinner(), p1);
	}

	@Test
	public void testSetAndGetPlayerLooser()
	{
		Game game = new Game();
		PlayerFactory playFact = new PlayerFactory();
		Player looser = playFact.getPlayer("Human");
		game.setLooser(looser);
		assertEquals(game.getLooser(), looser);
	}
	
	@Test
	public void testSetAndGetWinnerWinCount()
	{
		Game game = new Game();
		game.setWinnerWin(2);
		assertEquals(game.getWinnerWins(), 2);
	}
	
	@Test
	public void testSetAndGetTotalRoundsPerGame()
	{
		Game game = new Game();
		game.setRounds(3);
		assertEquals(game.getRounds(), 3);
	}
	
	@Test
	public void testReturnNumberOfLosesByWinner()
	{
		Game game = new Game();
		game.setRounds(3);
		game.setWinnerWin(2);
		game.setLooserWins(0);
		assertEquals(game.getWinnerLoses(), 0);
	}
	
	
	@Test
	public void testReturnNumberOfdraws()
	{
		Game game = new Game();
		game.setRounds(3);
		game.setWinnerWin(2);
		game.setLooserWins(0);
		assertEquals(game.getNumberOfDraws(), 1);
		
	}
	
	@Test
	public void testReturnNumberOfWinsByLoser()
	{
		Game game = new Game();
		game.setRounds(3);
		game.setWinnerWin(1);
		assertEquals(game.getLooserWins(), 0);
	}
	
}
