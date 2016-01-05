package JunitTests.AI;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import computerIntelligence.Intelligence;
import computerIntelligence.IntermediateAI;
import computerIntelligence.NoviceAI;
import GameObjs.GameObj;
import GameObjs.GameObjectChoice;

import PlayerObjs.Computer;


public class TestComputerIntelligence {

	@Ignore
	@Test
	public void testComputerNoviceRock()
	{
		NoviceAI novice = new NoviceAI();
		String choice = novice.makeChoice();		
		//hard coded string return as rock
		assertTrue(choice.equalsIgnoreCase("rock"));
		assertFalse(choice.equalsIgnoreCase("Scissors"));
	}
	
	
	@Test
	public void testComputerIntermidiateRock()
	{		
		IntermediateAI inter = new IntermediateAI();
		String choice = inter.makeChoice();		
		//hard coded string return as rock
		assertTrue(choice.equalsIgnoreCase("rock"));
		assertFalse(choice.equalsIgnoreCase("Scissors"));
	}
	
	@Ignore
	@Test
	public void testComputerIntelligence()
	{
		Intelligence novice = new NoviceAI();
		String choice = novice.makeChoice();		
		assertTrue(choice.equalsIgnoreCase("rock"));		
	}
	
	@Ignore
	@Test
	public void testComputerintelligenceEnumRock()
	{		
		GameObjectChoice rock = GameObjectChoice.Rock;
		String choice = rock.toString();		
		assertTrue(choice.equalsIgnoreCase("rock"));	
	}
	
	@Test
	public void testComputerintelligenceEnumPaper()
	{		
		GameObjectChoice paper = GameObjectChoice.Paper;
		String choice = paper.toString();		
		assertTrue(choice.equalsIgnoreCase("paper"));	
	}
	
	@Test
	public void testComputerintelligenceEnumScissors()
	{		
		GameObjectChoice scissors = GameObjectChoice.Scissors;
		String choice = scissors.toString();		
		assertTrue(choice.equalsIgnoreCase("scissors"));	
	}	
	
    
	@Test
	public void testComputerEnumRandomChoice() throws Exception
	{
		String rand = GameObjectChoice.getRandomGameObjectChoice();
		Computer comp = new Computer();
		GameObj obj = comp.chooseGameObj(rand);	
		assertTrue(obj instanceof GameObj);			
	}
	
	
	@Test
	public void testComputerNoviceAIRandomChoice() throws Exception
	{
		Intelligence novice = new NoviceAI();
		String returnedGameObjString = novice.makeChoice();
		Computer comp = new Computer();
		GameObj obj = comp.chooseGameObj(returnedGameObjString);	
		assertTrue(obj instanceof GameObj);			
	}
	
	
}
