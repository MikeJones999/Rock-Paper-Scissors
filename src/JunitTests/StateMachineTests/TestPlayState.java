package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stateMachine.PlayState;
import stateMachine.StateManager;
import stateMachine.ResultState;

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
	
	@Test
	public void testPlayStateUpdateOfState()
	{
		PlayState playState = new PlayState(man);
		playState.updateState();
		//hardcoded swicth to OutCome state within method
		assertTrue(man.getGameState() instanceof ResultState);		
	}
	
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
