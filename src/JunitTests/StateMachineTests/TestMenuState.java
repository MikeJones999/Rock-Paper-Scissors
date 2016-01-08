package JunitTests.StateMachineTests;


import static org.junit.Assert.*;

import org.junit.Test;

import stateMachine.MenuState;
import stateMachine.PlayState;
import stateMachine.StateManager;

public class TestMenuState {


	@Test
	public void testMenuStateConstructor() 
	{		
		StateManager man = StateManager.getNewInstance();
		MenuState menu = new MenuState(man);
		assertTrue(menu.getStateManager() instanceof StateManager);
	}
	
	
	@Test
	public void testMenuStateUpdateofState()
	{
		StateManager man = StateManager.getNewInstance();
		MenuState menu = new MenuState(man);
		menu.updateState();
		//hard coded a switch to new PlayState
		assertTrue(man.getGameState() instanceof PlayState);		
	}

}
