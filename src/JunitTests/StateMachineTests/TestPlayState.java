package JunitTests.StateMachineTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;
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
	
	
	@Ignore
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
	
	@Ignore
	@Test
	public void testGetGameSettingsAndUpdatedConstructor()
	{
		GameSettings gameSettings = new GameSettings();
		PlayState playState = new PlayState(man, gameSettings);
		assertEquals(playState.getGameSettings(), gameSettings);	
	}
	
	@Test
	public void testConstructorCallToInitiateStateAndChangeToResultState()
	{
		GameSettings gameSettings = new GameSettings();
		gameSettings.setGameRounds(3);
		PlayerFactory playFact = new PlayerFactory();
		Player player1 = playFact.getPlayer("Human");
		player1.setName("Jarvis");
		Player player2 = playFact.getPlayer("Computer");
		player2.setName("AL");	
		gameSettings.setPlayerOne(player1);
		gameSettings.setPlayerTwo(player2);		
		
		
		PlayState playState = new PlayState(man, gameSettings);
		//playState.initiateState();
		//play Two games
		assertEquals(playState.getResults().size(), 2);
		assertTrue(man.getGameState() instanceof ResultState);
	}
	
	@After
	public void tearDown()
	{
		//clears the stateMachine's currentState to null
	    man.setGameState(null);
	    System.out.println("close");

	}

	

}
