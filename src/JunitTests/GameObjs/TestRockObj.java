package JunitTests.GameObjs;

import static org.junit.Assert.*;

import org.junit.Test;

import GameObjs.Paper;
import GameObjs.Rock;
import GameObjs.Scissors;



public class TestRockObj {

	@Test
	public void testRockVersusScissors() 
	{
		
		Rock rock = new Rock();
		Scissors scissors = new Scissors();
		
		assertTrue(rock.beats(scissors) > 0);
		assertFalse(scissors.beats(rock) > 0);
	}
	
	@Test
	public void testRockVersusPaper()
	{
		Rock rock = new Rock();
		Paper paper = new Paper();		
	
		assertFalse(rock.beats(paper) > 0);	
		assertTrue(paper.beats(rock) > 0);
	}
	
	@Test
	public void testRockVersusRock()
	{
		Rock r1 = new Rock();
		Rock r2 = new Rock();
		
		assertTrue(r1.beats(r2) == 0);
		assertFalse(r2.beats(r1) > 0);
		
		
	}

}
