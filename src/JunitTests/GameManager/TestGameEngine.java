package JunitTests.GameManager;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
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

	@Test
	public void testGameEngineConstructor() throws IOException 
	{
		GameEngine engine = new GameEngine(man);
		//engine.setStateManager(man);
		assertTrue(engine.getStateManager() instanceof StateManager);		
	}
	
	@Test
	public void testGameEngineStateManagerSetUpState() throws IOException
	{
		GameEngine engine = new GameEngine(man);
		assertTrue(engine.getStateManager().getGameState() instanceof SetUpState);		
	}
	
	@Test
	public void testGameEngineReturnGameStateDirect() throws IOException
	{
		GameEngine engine = new GameEngine(man);
		GameState state = engine.getCurrentGameState();
		assertTrue(state instanceof SetUpState);
	}
	

	
	
	
	
	
	

}
