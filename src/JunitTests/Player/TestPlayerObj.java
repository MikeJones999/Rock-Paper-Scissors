package JunitTests.Player;

import static org.junit.Assert.*;

import org.junit.Test;

import computerIntelligence.Intelligence;
import computerIntelligence.NoviceAI;
import PlayerObjs.Computer;
import PlayerObjs.Human;
import PlayerObjs.Player;

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
		
	
}
