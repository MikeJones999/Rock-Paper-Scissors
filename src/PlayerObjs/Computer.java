package PlayerObjs;


import GameObjs.GameObj;

public class Computer implements Player {

	
	public GameObj chooseGameObj(String gameObj) throws Exception {
		
		return GameObj.newGameObj(gameObj);
	}


	
}
