package JunitTests.StateMachineTests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import consoleUI.GameSettings;
import consoleUI.SettingsMenu;
import gameManager.GameEngine;
import stateMachine.SetUpState;
import stateMachine.PlayState;
import stateMachine.StateManager;

public class TestSetUpState {

	private StateManager man;
	
	@Before
	public void beforeSetUp()
	{
	    man = StateManager.getNewInstance();
	}
	

	@Test
	public void testSetUpStateConstructor() 
	{		
		SetUpState menu = new SetUpState(man);
		assertTrue(menu.getStateManager() instanceof StateManager);
	}
	
	
	@Test
	public void testSetUpStateUpdateofState()
	{
		SetUpState menu = new SetUpState(man);
		menu.updateState();
		//hard coded a switch to new PlayState
		assertTrue(man.getGameState() instanceof PlayState);		
	}
	
	@Test
	public void testGameSettingCreation()
	{
		SetUpState menu = new SetUpState(man);
		assertTrue(menu.getGameSettings() instanceof GameSettings);
	}
	
	@Ignore
	@Test
	public void testInitiateStateCreateGameSettings()
	{
		SetUpState menu = new SetUpState(man);
		SettingsMenu settings = new SettingsMenu(menu.getGameSettings());			
		assertEquals(menu.getGameSettings().getGameRounds(), 0);		
	}
	
	@Test
	public void testInitiateStateSettingsAutomaticallyConfigured()
	{
		SetUpState menu = new SetUpState(man);
		assertEquals(menu.getGameSettings().getGameRounds(), 0);
	}
	
	@After
	public void tearDown()
	{
		//clears the stateMachine's currentState to null
	    man.setGameState(null);
	    System.out.println("close");

	}
	

}
