package PlayerObjs;


import GameObjs.GameObj;

public class Computer extends Player {

	
	public GameObj chooseGameObj(String gameObj) throws Exception {
		
		return GameObj.newGameObj(gameObj);
	}
	


	@Override
	public String intelChooseGameObj() throws Exception
	{		
		return intelLevel.makeChoice();
	}
	
	
	
}
