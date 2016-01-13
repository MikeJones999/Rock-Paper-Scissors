package JunitTests.ConsoleLineUI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;
import consoleUI.GameSettings;
import consoleUI.PlayGameUI;
import gameManager.Game;

public class TestPlayGameUI {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayGameUIConstructorReceiveGameSettings() {

	GameSettings gameSettings = new GameSettings();
	PlayGameUI play = new PlayGameUI(gameSettings);
	assertEquals (play.getGameSettings(), gameSettings);
	
	}
	
	@Test
	public void testPlayGameGetResults()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		assertTrue(play.getGameResults() == null);
	}
	
	@Test
	public void testPlayGameInitiateGameSetupArraytoHoldGames()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		play.initiateUI();
		assertTrue(play.getGameResults().isEmpty());
	}
	
	@Test
	public void testCreateNewGameAndAddToArray()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		play.initiateUI();
		play.startNewGame();
		Game game = new Game();
		play.addNewGame(game);
		assertEquals(play.getGameResults().size(), 1);
	}
	
	
	

}
