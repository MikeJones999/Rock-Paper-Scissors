package PlayerObjs;

import GameObjs.GameObj;


public class Human extends Player {

	public GameObj chooseGameObj(String gameObj) throws Exception{	
				
			return GameObj.newGameObj(gameObj);
			
	}

	@Override
	public String intelChooseGameObj() throws Exception {
		
		throw new Exception("Human Player does not have AI");
		
		//change to request move?
	}
	
	
	
}
