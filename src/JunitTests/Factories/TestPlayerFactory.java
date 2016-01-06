package JunitTests.Factories;

import static org.junit.Assert.*;

import org.junit.Test;


import PlayerObjs.Computer;
import PlayerObjs.Human;
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
	
	
	@Test
	public void testPlayerFactoryGetHuman() throws Exception
	{
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Human");
		assertTrue(p1 instanceof Human);		
	}
	
}
