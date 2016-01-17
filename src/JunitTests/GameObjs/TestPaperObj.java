package JunitTests.GameObjs;

import static org.junit.Assert.*;

import org.junit.Test;

import GameObjs.GameObj;
import GameObjs.GameObjectChoice;
import GameObjs.GameObjectRules;
import GameObjs.Paper;
import GameObjs.Rock;
import GameObjs.Scissors;

public class TestPaperObj {

	@Test
	public void testPaperVersusRock()
	{
		Paper paper = new Paper();
		Rock rock = new Rock();
		
		assertTrue(paper.beats(rock) > 0);
		assertFalse(rock.beats(paper) > 0);		
	}
	
	
	@Test
	public void testPaperVersusScissors()
	{
		Paper paper = new Paper();
		Scissors scissors = new Scissors();
		
		assertTrue(scissors.beats(paper) > 0);
		assertFalse(paper.beats(scissors) > 0);
		
	}
	
	@Test
	public void testPaperVersusPaper()
	{
		Paper paper1 = new Paper();
		Paper paper2 = new Paper();
		
		assertTrue(paper1.beats(paper2) == 0);
		assertFalse(paper2.beats(paper1) > 0);
		
	}
	

	@Test
	public void testSingleBeatsMethodPaperVersusScissors()
	{
		
		GameObj paper = GameObj.newGameObj("Paper");
		GameObj scissors = GameObj.newGameObj("Scissors");;
		
		assertTrue(paper.beats(scissors) == -1);
		
	}
	
	
}
