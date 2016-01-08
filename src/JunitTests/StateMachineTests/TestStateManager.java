package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stateMachine.GameState;
import stateMachine.SetUpState;
import stateMachine.PlayState;
import stateMachine.StateManager;
import stateMachine.ResultState;

public class TestStateManager {

	private StateManager man;
	
	@Before
	public  void setUp()
	{
	    man = StateManager.getNewInstance();
	    System.out.println("Open");
	}
	

	
	@Test
	public void testGetSingletonStateManager() 
	{
		//StateManager man = StateManager.getNewInstance();
		assertTrue(man instanceof StateManager);
	}
	
	@Test
	public void testSetAndGetCurrentGameState()
	{
		//StateManager man = StateManager.getNewInstance();
		SetUpState menuState = new SetUpState(man);
		man.setGameState(menuState);
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}

	
	@Test
	public void testStartStateManager()
	{
		//StateManager man = StateManager.getNewInstance();
		man.startGameManager();
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}
	
	@Test
	public void testSwitchState()
	{
		//StateManager man = StateManager.getNewInstance();
		man.startGameManager();
		PlayState play = new PlayState(man);
		man.switchState(play);
		GameState current = man.getGameState();
		assertTrue(current instanceof PlayState);
	}
	
	@Test
	public void testUpdateCurrentSetUpStatetoPlayState()
	{
		//StateManager man = StateManager.getNewInstance();
		man.startGameManager();
		man.updateState();
		System.out.println(man.getGameState().toString());
		assertTrue(man.getGameState() instanceof PlayState);
	}

	@Test
	public void testUpdateCurrentPlayStatetoWonState()
	{
		man.startGameManager();
		man.updateState();
		man.updateState();
		assertTrue(man.getGameState() instanceof ResultState);
	
	}

	@Test
	public void testActivateCurrentState()
	{
		man.startGameManager();
		man.activateState();
	}
	
	@After
	public void tearDown()
	{
		//clears the stateMachine's currentState to null
	    man.setGameState(null);
	    System.out.println("close");

	}

	
}
