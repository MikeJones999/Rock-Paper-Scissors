package GameObjs;

import java.util.ArrayList;
import java.util.List;

public class GameObjectRules {

	
	
	private ArrayList<Pair> paired;
	private GameObjectChoice[] gameObjArr; 

	public GameObjectRules(GameObjectChoice[] gameObjArr)
	{
		   this.gameObjArr = gameObjArr;
		   getNumberedPairedGameObjects();
	}
	
	
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
	
	
	
	public List<Pair> getNumberedPairedGameObjects()
	{
		paired = new ArrayList<Pair>();
		
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
