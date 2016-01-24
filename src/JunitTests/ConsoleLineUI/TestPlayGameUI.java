package JunitTests.ConsoleLineUI;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import GameObjs.GameObj;
import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;
import consoleUI.GameSettings;
import consoleUI.PlayGameUI;
import gameManager.Game;

public class TestPlayGameUI {

	private GameSettings gameSettings;
	private PlayGameUI play;
	@Before
	public void setUp() throws Exception {
		gameSettings = new GameSettings();
		play = new PlayGameUI(gameSettings);
	}

	@After
	public void tearDown() throws Exception {
		gameSettings = null;
		play = null;
	}

	@Test
	public void testPlayGameUIConstructorReceiveGameSettings() {

	
	assertEquals (play.getGameSettings(), gameSettings);
	
	}
	
	@Ignore
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
		play.initiateArray();
		assertTrue(play.getGameResults().isEmpty());
	}
	
	@Ignore
	@Test
	public void testCreateNewGameAndAddToArray()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		play.initiateArray();
		play.setPlayersAndRounds();
		play.addGameToList(play.getCurrentGame());
		assertEquals(play.getGameResults().size(), 1);
	}
	
	@Ignore
	@Test 
	public void testGameBegins()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		gameSettings.setGameRounds(3);
		play.initiateArray();
		play.setPlayersAndRounds();
		//simulate returning true once game is complete
	    assertEquals(play.initController(), true);
	}
	
	@Ignore
	@Test 
	public void testPlayingGameViaStartNewGame()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		gameSettings.setGameRounds(3);
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Human");
		Player p2 = playFact.getPlayer("Human");
		p1.setName("Mike");
		p1.setName("Dave");
		play.initiateArray();
		play.setPlayersAndRounds();
		//simulate returning true once game is complete
	    assertEquals(play.initController(), true);	    
	}
	
	@Ignore
	@Test
	public void testDisplayGameObjectsOfChoice()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		gameSettings.setGameRounds(3);
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Human");
		player1.setName("Mike");
		play.displayGameObjectsOfChoice(player1);
		//visually inspect game objects
	}

	@Ignore
	@Test
	public void testplayerHumanMakeAChoiceOfGameObject()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		gameSettings.setGameRounds(3);
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Human");
		player1.setName("Mike");
		play.displayGameObjectsOfChoice(player1);
		GameObj obj = play.playerMakeAChoiceOfGameObject(player1);
		//player manually typing Scissors. 
		assertEquals(obj.toString(), "Scissors");		
	}
	
	@Ignore
	@Test
	public void testplayerComputerNoviceAIMakeAChoiceOfGameObject()
	{
		GameSettings gameSettings = new GameSettings();
		PlayGameUI play = new PlayGameUI(gameSettings);
		gameSettings.setGameRounds(3);
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Computer");
		player1.setName("Jarvis");
		play.displayGameObjectsOfChoice(player1);
		GameObj obj = play.playerMakeAChoiceOfGameObject(player1);		
		assertTrue(obj instanceof GameObj);		
	}
	
	@Ignore
	@Test
	public void testComputerPlayerVersusComputerPlayerSuccessfullyCompletes()
	{
		GameSettings gameSettings = new GameSettings();		
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Computer");
		player1.setName("Jarvis");
		Player player2 = playFact.getPlayer("Computer");
		player2.setName("AL");		
		
		gameSettings.setGameRounds(3);
		gameSettings.setPlayerOne(player1);
		gameSettings.setPlayerTwo(player2);
		PlayGameUI play = new PlayGameUI(gameSettings);
		assertEquals(play.initController(), true);		
	}

	@Ignore
	@Test
	public void testCalculateWinnerAndLooserFromScore()
	{		
		GameSettings gameSettings = new GameSettings();	
		gameSettings.setGameRounds(3);
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Computer");
		player1.setName("Jarvis");
		Player player2 = playFact.getPlayer("Computer");
		player2.setName("AL");	
		gameSettings.setPlayerOne(player1);
		gameSettings.setPlayerTwo(player2);

		PlayGameUI play = new PlayGameUI(gameSettings);
		int p1 = 3;
		int p2 = 0;
		int draw = 0;
		play.calculateWinnerFromScore(p1, p2, draw);
		assertEquals(play.getCurrentGame().getWinner(), player1);
		assertEquals(play.getCurrentGame().getLooser(), player2);
		assertEquals(play.getCurrentGame().getWinnerWins(), 3);
		assertEquals(play.getCurrentGame().getLooserWins(), 0);
	}
	
	
	@Ignore
	@Test
	public void testCalculateDrawFromScore()
	{		
		GameSettings gameSettings = new GameSettings();	
		gameSettings.setGameRounds(3);

		PlayGameUI play = new PlayGameUI(gameSettings);
		int p1 = 0;
		int p2 = 0;
		int draw = 3;
		play.calculateWinnerFromScore(p1, p2, draw);
		assertEquals(play.getCurrentGame().isDraw(), true);		
	}
	
	@Ignore
	@Test
	public void testCheckIfGameIsToBeRepeated()
	{
		GameSettings gameSettings = new GameSettings();	
		gameSettings.setGameRounds(3);
		PlayGameUI play = new PlayGameUI(gameSettings);
		
		boolean result = play.endSessionAndExit();
		//respond yes to play another game - should return false
		assertEquals(result, false);
	}
	
	@Test
	public void testPlayControllerCompleteAndGamesAddedToList()
	{
		GameSettings gameSettings = new GameSettings();	
		gameSettings.setGameRounds(3);
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Human");
		player1.setName("Jarvis");
		Player player2 = playFact.getPlayer("Computer");
		player2.setName("AL");	
		gameSettings.setPlayerOne(player1);
		gameSettings.setPlayerTwo(player2);

		PlayGameUI play = new PlayGameUI(gameSettings);
		play.initController();
		List<Game> results = play.getGameResults();
		//play two games - cannot predict outcome - testing array of games is complete
		assertTrue(results.get(0) instanceof Game);
		assertTrue(results.get(1) instanceof Game);
		assertNotEquals(results.get(1), results.get(0));
	}
	
}
