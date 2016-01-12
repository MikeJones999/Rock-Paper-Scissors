package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import consoleUI.GameSettings;
import stateMachine.PlayState;
import stateMachine.ResultState;
import stateMachine.StateManager;

public class TestPlayState {

	private StateManager man;
	
	@Before
	public void beforeSetUp()
	{
	    man = StateManager.getNewInstance();
	}
	
	@Test
	public void testPlayStateConstructor() 
	{
		PlayState playState = new PlayState(man);
		assertTrue(playState.getStateManager() instanceof StateManager);		
	}
	
	@Ignore
	@Test
	public void testPlayStateUpdateOfState()
	{
		PlayState playState = new PlayState(man);
		playState.updateState();
		//hardcoded swicth to OutCome state within method
		assertTrue(man.getGameState() instanceof ResultState);		
	}
	
	
	@Test
	public void testGetGameSettingsAndUpdatedConstructor()
	{
		GameSettings gameSettings = new GameSettings();
		PlayState playState = new PlayState(man, gameSettings);
		assertEquals(playState.getGameSettings(), gameSettings);	
	}
	
	@Ignore
	@Test
	public void testInitiateState()
	{
		
	}
	
	@After
	public void tearDown()
	{
		//clears the stateMachine's currentState to null
	    man.setGameState(null);
	    System.out.println("close");

	}

	

}
