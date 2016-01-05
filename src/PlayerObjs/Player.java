package PlayerObjs;

import computerIntelligence.Intelligence;
import GameObjs.GameObj;

public abstract class Player {
	
	
	public Intelligence intelLevel;
	
	public void setIntelLevel(Intelligence intelLevel)
	{
		this.intelLevel = intelLevel;
	}
	
	public abstract GameObj chooseGameObj(String gameObj) throws Exception;

	public abstract String intelChooseGameObj() throws Exception;

	
}
