package PlayerObjs;

import GameObjs.GameObj;


public class Human implements Player {

	public GameObj chooseGameObj(String gameObj) throws Exception{	
				
			return GameObj.newGameObj(gameObj);
			
	}
}
