package JunitTests.Player;


import static org.junit.Assert.*;

import org.junit.Test;

import GameObjs.GameObj;
import GameObjs.Paper;
import GameObjs.Rock;
import GameObjs.Scissors;
import PlayerObjs.Human;

public class TestHumanObj {

	@Test
	public void testHumaChoosePaper() throws Exception {

		Human p1 = new Human();
		GameObj paper = p1.chooseGameObj("Paper");
		assertTrue(paper instanceof Paper);
	}

	@Test 
	public void testHumanChooseScissors() throws Exception
	{
		Human p1 = new Human();
		GameObj scissors = p1.chooseGameObj("Scissors");
		assertTrue(scissors instanceof Scissors);
		
	}
	
	@Test 
	public void testHumanChooseRock() throws Exception
	{
		Human p1 = new Human();
		GameObj rock = p1.chooseGameObj("Rock");
		assertTrue(rock instanceof Rock);
		
	}
	
}
