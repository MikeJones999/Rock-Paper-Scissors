package JunitTests.Player;

import static org.junit.Assert.*;

import org.junit.Test;

import computerIntelligence.Intelligence;
import computerIntelligence.NoviceAI;
import PlayerObjs.Computer;
import PlayerObjs.Human;
import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

public class TestPlayerObj {

	@Test
	public void testPlayerCreationOfHuman() {
		
		Player human = new Human();
		assertTrue(human instanceof Player);		
	}

	
	@Test
	public void testPlayerCreationOfComputer() {
		
		Player comp = new Computer();
		assertTrue(comp instanceof Player);		
	}
	
	
	@Test
	public void testSettingPlayerIntelligence() throws Exception
	{
		Player p1 = new Computer();
		Intelligence novice = new NoviceAI();
		p1.setIntelLevel(novice);
		
		String result = p1.intelChooseGameObj();
		
		assertTrue(result.equals("Rock") || result.equals("Paper") || result.equals("Scissors"));
	}
	
	
//	//Only ever going to be two player types - AI or Humans - no need for further reflection
//	@Test
//	public void testPlayerfactoryHuman() throws Exception
//	{
//		PlayerFactory playFact = new PlayerFactory();
//		Player p1 = playFact.getPlayer("Human");		
//		assertTrue(p1 instanceof Human);
//		
//	}
//	
//	@Test
//	public void testPlayerfactoryComputer() throws Exception
//	{
//		PlayerFactory playFact = new PlayerFactory();
//		Player p1 = playFact.getPlayer("Computer");		
//		assertTrue(p1 instanceof Computer);		
//	}
//	
	
	
}
