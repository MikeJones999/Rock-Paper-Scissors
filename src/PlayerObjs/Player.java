package PlayerObjs;

import computerIntelligence.Intelligence;
import GameObjs.GameObj;

public abstract class Player {
	
	protected String name;
	
	public Intelligence intelLevel;
	
	public void setIntelLevel(Intelligence intelLevel)
	{
		this.intelLevel = intelLevel;
	}
	
	public abstract GameObj chooseGameObj(String gameObj);

	public abstract void setName(String name);

	public abstract String getName();	
}
