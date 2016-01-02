package JunitTests.GameObjs;

import static org.junit.Assert.*;

import org.junit.Test;

import GameObjs.Paper;
import GameObjs.Rock;
import GameObjs.Scissors;

public class TestScissorsObj {

	@Test	
	public void testScissorsVersusRock() 
	{
		Scissors scissors = new Scissors();
		Rock rock = new Rock();
		
		assertTrue(rock.beats(scissors) > 0);
		assertFalse(scissors.beats(rock) > 0);
	}

	
	@Test
	public void testScissorsVersusPaper()
	{
		
		Scissors scissors = new Scissors();
		Paper paper = new Paper();
		
		assertTrue(scissors.beats(paper) > 0);
		assertFalse(paper.beats(scissors) > 0);
		
	}
	
	
	@Test
	public void testScissorsVersusScissors()
	{
		Scissors s1 = new Scissors();
		Scissors s2 = new Scissors();
		
		assertTrue(s1.beats(s2) == 0);
		assertFalse(s2.beats(s1) > 0);
	}
}
