package JunitTests.ConsoleLineUI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PlayerObjs.Computer;
import PlayerObjs.Human;
import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;
import consoleUI.GameSettings;

public class TestGameSettings {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGameSettingsCreationAndConstructor() {

		GameSettings GameSettings = new GameSettings();
		assertTrue(GameSettings instanceof GameSettings);		
	}
	
	
	@Test
	public void testGameSettingsGameRoundsOption()
	{
		GameSettings GameSettings = new GameSettings();
		GameSettings.setGameRounds(3);
		assertEquals(GameSettings.getGameRounds(), 3);		
	}
	
	@Test
	public void testPlayerOneHumanSetup()
	{
		GameSettings GameSettings = new GameSettings();
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Human");
		GameSettings.setPlayerOne(p1);
		assertTrue (GameSettings.getPlayerOne() instanceof Human);		
	}
	
	@Test
	public void testPlayerTwoComputerSetup()
	{
		GameSettings GameSettings = new GameSettings();
		PlayerFactory playFact = new PlayerFactory();
		Player p2 = playFact.getPlayer("Computer");
		GameSettings.setPlayerTwo(p2);
		assertTrue (GameSettings.getPlayerTwo() instanceof Computer);
	}
	
	@Test
	public void testRetrievePlayerOneName()
	{
		GameSettings GameSettings = new GameSettings();
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Human");
		p1.setName("Dave");
		GameSettings.setPlayerOne(p1);
		assertEquals(p1.getName(), "Dave");
	}
	

}
