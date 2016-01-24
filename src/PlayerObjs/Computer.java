package PlayerObjs;


import GameObjs.GameObj;
import computerIntelligence.Intelligence;
import computerIntelligence.NoviceAI;


/**
 * Computer class - child class of Player.
 * This class extends Player and inherits the chooseGameObj method
 * Computer class can have the ability in the future to change its intelligence level.
 * As standard Computer intelligence is novice.
 */

public class Computer extends Player {

	
	
	public GameObj chooseGameObj(String gameObj) {
		
		String obj = intelChooseGameObj();
		return GameObj.newGameObj(obj);
	}
	
	

	public String intelChooseGameObj()
	{		
		if(intelLevel == null)
		{
			intelLevel = new NoviceAI();
		}
		return intelLevel.makeChoice();
	}



	@Override
	public void setName(String name) {
		this.name = name; 
	}



	@Override
	public String getName() {
		StringBuilder sb = new StringBuilder();
		sb.append("(Computer) ");
		sb.append(this.name);
		
		return sb.toString();
	}
	
	
	public void setIntelligenceLevel(Intelligence intelLevel)
	{
		this.intelLevel = intelLevel;
	}
}
