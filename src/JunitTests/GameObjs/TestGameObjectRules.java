package JunitTests.GameObjs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import GameObjs.GameObj;
import GameObjs.GameObjectChoice;
import GameObjs.GameObjectRules;
import GameObjs.Pair;
import GameObjs.Paper;
import GameObjs.Scissors;

public class TestGameObjectRules {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void testCaluclateWin() 
	{
		
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		
		GameObj paper = GameObj.newGameObj("Paper");
		GameObj Scissors = GameObj.newGameObj("Scissors");
		int result = rules.caluclateWin(paper, Scissors);
		//hardcoded return -1
		assertEquals(result, -1);		
	}
	
	@Test
	public void testPairCreation()
	{
		GameObj paper = GameObj.newGameObj("Paper");
		Pair p1 = new Pair(paper, 0);
		Pair p2 = new Pair(paper.toString(), 1);
		assertTrue(p1.getObj() instanceof GameObj);
		assertEquals(p2.getObj(), "Paper");
	}
	
	@Ignore
	@Test
	public void testPairCreationAndSetting()
	{
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		List<Pair> paired = rules.getNumberedPairedGameObjects();
		assertEquals(paired.isEmpty(), true);		
	}
	
	@Test
	public void testPairCreationAndReturnArrayOfPairs()
	{
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		List<Pair> paired = rules.getNumberedPairedGameObjects();
		assertEquals(paired.isEmpty(), false);		
	}
	
	
	
	@Test
	public void testPairCreationAndReturnIndexZeroPair()
	{
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		List<Pair> paired = rules.getNumberedPairedGameObjects();
		assertEquals(paired.get(0).getObj().toString(), "Rock");		
		assertEquals(paired.get(0).getValue(), 0);	
	}
	
	@Ignore
	@Test
	public void testObtainValueAndObjFromArray()
	{
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		GameObj rock = GameObj.newGameObj("Paper");
		GameObj scissors = GameObj.newGameObj("Scissors");
		int num = rules.caluclateWin(rock, scissors);
		//rock is first in array and should have the value of 0
		assertEquals(num, -1);		
	}

	@Test
	public void testObtainWinFromCalculateWin()
	{
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		GameObj rock = GameObj.newGameObj("Paper");
		GameObj Scissors = GameObj.newGameObj("Paper");
		int num = rules.caluclateWin(rock, Scissors);
		//rock is first in array and should have the value of 0
		assertEquals(num, 0);		
	}
	
	
}
