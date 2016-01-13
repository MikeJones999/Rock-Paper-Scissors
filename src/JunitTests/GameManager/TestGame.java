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
	
	public void testSetPlayerWinner()
	{
		Game game = new Game();
		PlayerFactory playFact = new PlayerFactory();			
		Player p1 = playFact.getPlayer("Human");
		game.setWinner(p1);
		assertEquals(game.getWinner(), p1);
	}

}
