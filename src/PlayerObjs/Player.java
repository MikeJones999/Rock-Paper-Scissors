package PlayerObjs;

import computerIntelligence.Intelligence;
import GameObjs.GameObj;

/**
 * class extended by Human and Computer
 * Used within PlayerFactory to obtain a sub classof player
 * @author mike
 *
 */


public abstract class Player {
	
	protected String name;
	
	public Intelligence intelLevel;
	
	
	/**
	 * Strategy method to be used in future to change the level of computers intelligence. 
	 * Only Novice Intelligence utilised at this stage
	 * @param intelLevel
	 */
	public void setIntelLevel(Intelligence intelLevel)
	{
		this.intelLevel = intelLevel;
	}
	
	public abstract GameObj chooseGameObj(String gameObj);

	public abstract void setName(String name);

	public abstract String getName();	
}
