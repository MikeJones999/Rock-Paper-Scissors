package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

<<<<<<< HEAD
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
=======
import org.junit.Test;

import stateMachine.GameState;
import stateMachine.MenuState;
import stateMachine.PlayState;
import stateMachine.StateManager;

public class TestStateManager {

	@Test
	public void testGetSingletonStateManager() 
	{
		StateManager man = StateManager.getNewInstance();
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
		assertTrue(man instanceof StateManager);
	}
	
	@Test
	public void testSetAndGetCurrentGameState()
	{
<<<<<<< HEAD
		//StateManager man = StateManager.getNewInstance();
		SetUpState menuState = new SetUpState(man);
=======
		StateManager man = StateManager.getNewInstance();
		MenuState menuState = new MenuState(man);
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
		man.setGameState(menuState);
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}
<<<<<<< HEAD

=======
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
	
	@Test
	public void testStartStateManager()
	{
<<<<<<< HEAD
		//StateManager man = StateManager.getNewInstance();
=======
		StateManager man = StateManager.getNewInstance();
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
		man.startGameManager();
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}
	
	@Test
	public void testSwitchState()
	{
<<<<<<< HEAD
		//StateManager man = StateManager.getNewInstance();
=======
		StateManager man = StateManager.getNewInstance();
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
		man.startGameManager();
		PlayState play = new PlayState(man);
		man.switchState(play);
		GameState current = man.getGameState();
		assertTrue(current instanceof PlayState);
	}
	
<<<<<<< HEAD
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

=======
	
	@Test
	public void testUpdateCurrentMenuStatetoPlayState()
	{
		StateManager man = StateManager.getNewInstance();
		man.startGameManager();
		man.updateState();
		assertTrue(man.getGameState() instanceof PlayState);
	}

>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
	
}
