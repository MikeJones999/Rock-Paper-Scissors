package JunitTests.GameManager;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import gameManager.GameEngine;
import stateMachine.GameState;
import stateMachine.SetUpState;
import stateMachine.StateManager;

public class TestGameEngine {

	
	private StateManager man;
	
	@Before
	public void setUp() throws Exception {		
		man = StateManager.getNewInstance();		
	}

	@After
	public void tearDown() throws Exception 
	{		
		man.switchState(null);		
	}

	@Ignore
	@Test
	public void testGameEngineConstructor()  
	{
		GameEngine engine = new GameEngine(man);
		//engine.setStateManager(man);
		assertTrue(engine.getStateManager() instanceof StateManager);		
	}
	
	@Ignore
	@Test
	public void testGameEngineStateManagerSetUpState() 
	{
		GameEngine engine = new GameEngine(man);
		assertTrue(engine.getStateManager().getGameState() instanceof SetUpState);		
	}
	
	@Test
	public void testGameEngineReturnGameStateDirect() 
	{
		GameEngine engine = new GameEngine(man);
		GameState state = engine.getCurrentGameState();
		assertTrue(state instanceof SetUpState);
	}
	

	
	
	
	
	
	

}
