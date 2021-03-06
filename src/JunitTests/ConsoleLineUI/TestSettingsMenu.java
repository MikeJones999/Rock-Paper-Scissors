package JunitTests.ConsoleLineUI;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import PlayerObjs.Computer;
import PlayerObjs.Human;
import consoleUI.GameSettings;
import consoleUI.SettingsMenu;

public class TestSettingsMenu {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void testConstructor() {
		
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		assertEquals(gameSettings.getGameRounds(), 0);
	}
	
	@Ignore
	@Test
	public void testDefaultGameRounds()
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		menu.setGameRounds(3);
		assertEquals(gameSettings.getGameRounds(), 3);
	}
	@Ignore
	@Test
	public void testAutomaticDefaultGameRounds()
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		assertEquals(gameSettings.getGameRounds(), 3);
	}
	
    @Ignore
	@Test
	public void testMenuControllerReturnsBooleanuponCompletion() throws IOException
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		menu.initController();
		assertEquals(menu.getComplete(), true);
	}
	
    @Ignore
	@Test
	public void testParseErrorCatchFacility()
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		String str = "1";
		assertEquals(menu.parseErrorCatch(str), 1);
	}
	
	@Ignore
	@Test
	public void testParseErrorCatchFacilityStringError()
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		String str = "one";
		assertEquals(menu.parseErrorCatch(str), 0);
	}
	
//	@Ignore
//	@Test
//	public void testCreateNewPlayerMethod()
//	{
//		GameSettings gameSettings = new GameSettings();
//		SettingsMenu menu = new SettingsMenu(gameSettings);
//		//createPlayers was public but through encapsulation has been made private
//		menu.createPlayers("Human", "Computer");
//		assertTrue(gameSettings.getPlayerOne() instanceof Human);
//		assertTrue(gameSettings.getPlayerTwo() instanceof Computer);		
//	}
	
	@Ignore
	@Test
	public void testNewGameOptionSelectionCreatingOneHumanPlayer() throws IOException
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		menu.newGameSelected();
		assertTrue(gameSettings.getPlayerOne() instanceof Human);
		assertTrue(gameSettings.getPlayerTwo() instanceof Computer);
	}
	
	@Ignore
	@Test
	public void testNewGameOptionSelectionCreatingTwoHumanPlayer() throws IOException
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);
		menu.newGameSelected();
		assertTrue(gameSettings.getPlayerOne() instanceof Human);
		assertTrue(gameSettings.getPlayerTwo() instanceof Human);
	}
	
	
	@Ignore
	@Test
	public void testConstructionOfSettingMenuToCreateTwoPlayers() throws IOException
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);		
		menu.initController();
		//Console input enter Dave and Jarvis - Human and Computer Players
		assertEquals(gameSettings.getPlayerOne().getName(), "Dave");
		assertEquals(gameSettings.getPlayerTwo().getName(), "(Computer) Jarvis");			
	}
	
	@Ignore
	@Test
	public void testConstructionOfSettingMenuToPopulateGameSetting() throws IOException
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);		
		menu.initController();
		//Console input enter Dave and Jarvis - Human and Computer Players
		assertEquals(gameSettings.getPlayerOne().getName(), "Dave");
		assertEquals(gameSettings.getGameRounds(), 5);
		
	}
	
	@Test
	public void testExitOption()
	{
		GameSettings gameSettings = new GameSettings();
		SettingsMenu menu = new SettingsMenu(gameSettings);		
		boolean complete = menu.initController();
		
		assertEquals(complete, false);
	}
	
}
