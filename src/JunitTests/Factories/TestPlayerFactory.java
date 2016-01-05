package JunitTests.Factories;

import static org.junit.Assert.*;

import org.junit.Test;


import PlayerObjs.Computer;
import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

public class TestPlayerFactory {

	
	
	@Test (expected = Exception.class)
	public void testPlayerFactoryNullThrowExcpetion() throws Exception
	{
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer(null);
	}
	
	@Test (expected = Exception.class)
	public void testPlayerFactoryInvalidChoiceThrowException() throws Exception
	{
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Chicken");		
	}
	
	
	@Test
	public void testPlayerFactoryGetComputer() throws Exception 
	{			
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Computer");			
		assertTrue(p1 instanceof Computer);		
	}
	
	
	

//	Intelligence novice = new NoviceAI();
//		String noviceChoice = novice.makeChoice();
//		p1.chooseGameObj(noviceChoice);
}
