package JunitTests.StateMachineTests;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import stateMachine.ResultState;
import stateMachine.SetUpState;
import stateMachine.StateManager;

public class TestResultState {

	private StateManager man;
	
	@Before
	public void setUp() throws Exception 
	{
		  man = StateManager.getNewInstance();
	}
	
	
	@Test
	public void testResultStateConstructor() 
	{			
		ResultState result = new ResultState(man);
		assertTrue(result.getStateManager() instanceof StateManager);	
	}
	
	@Ignore
	@Test
	public void testResultStateUpdateOfStateSwitchToSetUpState()
	{
		ResultState result = new ResultState(man);
		result.updateState();
		assertTrue(man.getGameState()instanceof SetUpState);	
		//visual inspection shows newGame menu
	}
	

	
	@After
	public void tearDown() throws Exception 
	{
		//clears the stateMachine's currentState to null
	    man.setGameState(null);	   
	}
	
	
	
}
