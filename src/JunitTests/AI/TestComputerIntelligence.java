package JunitTests.AI;

import static org.junit.Assert.*;

import org.junit.Test;

import computerIntelligence.ComputerIntelFactory;
import computerIntelligence.Intelligence;
import computerIntelligence.IntermediateAI;
import computerIntelligence.NoviceAI;
import GameObjs.GameObj;
import GameObjs.GameObjectChoice;
import GameObjs.Rock;
import PlayerObjs.Computer;
import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

public class TestComputerIntelligence {

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
	
	
	@Test
	public void testComputerIntelligence()
	{
		Intelligence novice = new NoviceAI();
		String choice = novice.makeChoice();		
		assertTrue(choice.equalsIgnoreCase("rock"));		
	}
	
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
	
//	@Test
//	public void tesComputerNoviceChooseRandomGameObj() throws Exception {		
//		
//		PlayerFactory playFact = new PlayerFactory();
//		Player p1 = playFact.getPlayer("Computer");		
//		
//		//novice AI - playerfactory creates this
//		ComputerIntelFactory intelFact = new ComputerIntelFactory();
//		Intelligence intel = intelFact.getIntel("Novice");
//		
//		
//		
//		GameObj obj = p1.chooseGameObj(intel.makeChoice());
//		
//		System.out.println(obj);		
//
//		
//	}

}
