package GameObjs;

import java.util.ArrayList;
import java.util.List;


/**
 * GameObjectRules class is designed to obtain all the objects specified in the GameObjectChoice class and provide each object with an integer value.
 * The interger value is used to compare a win based upon the math detailed below.
 * Thus it is important to place newly created objects into GameObjectChoice Enum according to the math.
 * stackoverflow.com/questions/9553058/scalable-solution-for-rock-paper-scissor
 * @author mike
 *
 */


public class GameObjectRules {

	
	
	private List<Pair<String, Integer>> paired;
	private GameObjectChoice[] gameObjArr; 

	public GameObjectRules(GameObjectChoice[] gameObjArr)
	{
		   this.gameObjArr = gameObjArr;
		   getNumberedPairedGameObjects();
	}
	
	
	/**
	 * calculates the win of two objects that have inherited from GameObj.class
	 * @param GameObj.class
	 * @param GameObj.class
	 * @return Integer value which is read by the calling object.
	 */
	public int caluclateWin(GameObj obj1, GameObj obj2)
	{
		//Taken from stackoverflow.com/questions/9553058/scalable-solution-for-rock-paper-scissor
		//result = (gameObjArr.length - 1 + obj1.getValue - obj2.getValue) % gameObjArr.length - 1
		int result = -2;
		int valueObj1 = -1;
		int valueObj2 = -1;
		for (Pair<?, ?> p: paired)
		{
			if(p.getObj().equals(obj1.toString()))
			{
				valueObj1 = (int) p.getValue();
			}
			if(p.getObj().equals(obj2.toString()))
			{
				valueObj2 = (int) p.getValue();
			}
		}
		
		int numOfGameObjs = gameObjArr.length;
		int res = (numOfGameObjs + (valueObj1 - valueObj2)) % numOfGameObjs;
		switch(res)
		{
			case(0): { result = 0; break;}  //tie
			case(1): { result = 1; break;}  //obj1 wins
			case(2): { result = -1; break;} //obj2wins
			case(3): { result = 1; break;} //obj1 wins
			case(4): { result = -1; break;} //obj2wins		
		}		
		return result;
	}
	
	
	/**
	 * Obtains from the provided GameObjectChoice array all available GameObj and provides them with an increasing Integer value.  
	 * The gameObjs name is placed in a pair (Pair.class) with the integer. //could have used a hashmap just the same.
	 * @return paired array - although this is not necessary as this method is encapsulated and only used in the class - was returning pair array for testing purposes.
	 */
	public List<Pair<String, Integer>> getNumberedPairedGameObjects()
	{
		paired = new ArrayList<Pair<String, Integer>>();		
		for (int i = 0; i < gameObjArr.length; i++ )
		{
			String obj = gameObjArr[i].toString();
			int value = i;
			Pair<String, Integer> temp = new Pair<String, Integer>(obj, value);
			paired.add(temp);
		}		
		return paired;
	}
	
}
