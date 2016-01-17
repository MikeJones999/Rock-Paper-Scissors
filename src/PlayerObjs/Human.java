package PlayerObjs;

import GameObjs.GameObj;


public class Human extends Player {

	public GameObj chooseGameObj(String gameObj){	
				
			return GameObj.newGameObj(gameObj);
			
	}


	@Override
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String getName() {
		return name;
	}
	
	
	
	
}
