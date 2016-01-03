package JunitTests.Player;

import static org.junit.Assert.*;

import org.junit.Test;

import GameObjs.GameObj;
import GameObjs.Paper;
import GameObjs.Rock;
import GameObjs.Scissors;
import PlayerObjs.Computer;

public class TestComputerObj {

	@Test
	public void testComputerChooseRock() throws Exception 
	{
		
		Computer comp = new Computer();
		GameObj rock = comp.chooseGameObj("Rock");	
		assertTrue(rock instanceof Rock);		
	}
	
	
	@Test 
	public void testComputerChoosePaper() throws Exception
	{
		Computer comp = new Computer();
		GameObj paper = comp.chooseGameObj("Paper");		
		assertTrue(paper instanceof Paper);
		
	}
	
	@Test 
	public void testComputerChooseScissors() throws Exception
	{
		Computer comp = new Computer();
		GameObj scissors = comp.chooseGameObj("Scissors");		
		assertTrue(scissors instanceof Scissors);		
	}
	
	
	
}
