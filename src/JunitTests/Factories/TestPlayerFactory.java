package JunitTests.Factories;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


import PlayerObjs.Computer;
import PlayerObjs.Human;
<<<<<<< HEAD
import PlayerObjs.NullPlayerObj;
=======
>>>>>>> 932b832c4e054b4aebb7c5aca0f7b4ee066bfdf0
import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

public class TestPlayerFactory {

	
	@Ignore
	@Test (expected = Exception.class)
	public void testPlayerFactoryNullThrowExcpetion() throws Exception
	{
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer(null);
	}
	
	@Ignore
	@Test (expected = Exception.class)
	public void testPlayerFactoryInvalidChoiceThrowException() throws Exception
	{
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Chicken");		
	}
	
	@Ignore
	@Test
	public void testPlayerFactorReturnNullPlayer() throws Exception
	{
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer("Chicken");
		assertTrue(p1 instanceof NullPlayerObj);
	}
	
	
	@Test
	public void testPlayerFactoryGetNullPlayerFromNullEntry()
	{			
		PlayerFactory playFact = new PlayerFactory();
		Player p1 = playFact.getPlayer(null);			
		assertTrue(p1 instanceof NullPlayerObj);		
	}
	
	@Test
	public void testPlayerFactoryGetComputer()
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
