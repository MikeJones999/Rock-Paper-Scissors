package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

import java.io.IOException;

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
	public void testSetAndGetCurrentGameState() throws IOException
	{
		//StateManager man = StateManager.getNewInstance();
		SetUpState menuState = new SetUpState(man);
		man.setGameState(menuState);
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}

	
	@Test
	public void testStartStateManager() throws IOException
	{
		//StateManager man = StateManager.getNewInstance();
		man.startGame();
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}
	
	@Test
	public void testSwitchState() throws IOException
	{
		//StateManager man = StateManager.getNewInstance();
		man.startGame();
		PlayState play = new PlayState(man);
		man.switchState(play);
		GameState current = man.getGameState();
		assertTrue(current instanceof PlayState);
	}
	
	@Test
	public void testUpdateCurrentSetUpStatetoPlayState() throws IOException
	{
		//StateManager man = StateManager.getNewInstance();
		man.startGame();
		man.updateState();
		System.out.println(man.getGameState().toString());
		assertTrue(man.getGameState() instanceof PlayState);
	}

	@Test
	public void testUpdateCurrentPlayStatetoWonState() throws IOException
	{
		man.startGame();
		man.updateState();
		man.updateState();
		assertTrue(man.getGameState() instanceof ResultState);
	
	}

	@Test
	public void testActivateCurrentState() throws IOException
	{
		man.startGame();
		man.activateState();
	}
	
	@Test
	public void testGameSettingsCreation()
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
