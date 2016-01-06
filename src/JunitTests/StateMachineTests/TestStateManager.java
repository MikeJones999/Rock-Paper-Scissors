package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

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
		assertTrue(man instanceof StateManager);
	}
	
	@Test
	public void testSetAndGetCurrentGameState()
	{
		StateManager man = StateManager.getNewInstance();
		MenuState menuState = new MenuState(man);
		man.setGameState(menuState);
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}
	
	@Test
	public void testStartStateManager()
	{
		StateManager man = StateManager.getNewInstance();
		man.startGameManager();
		GameState current = man.getGameState();		
		assertTrue(current instanceof GameState);
	}
	
	@Test
	public void testSwitchState()
	{
		StateManager man = StateManager.getNewInstance();
		man.startGameManager();
		PlayState play = new PlayState(man);
		man.switchState(play);
		GameState current = man.getGameState();
		assertTrue(current instanceof PlayState);
	}
	
	
	@Test
	public void testUpdateCurrentMenuStatetoPlayState()
	{
		StateManager man = StateManager.getNewInstance();
		man.startGameManager();
		man.updateState();
		assertTrue(man.getGameState() instanceof PlayState);
	}

	
}
