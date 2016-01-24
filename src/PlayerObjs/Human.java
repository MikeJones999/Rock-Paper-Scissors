package PlayerObjs;

import GameObjs.GameObj;
 
/**
  * Human Class is a child of Player class - must extend this PLayer class.
  * 
  * @author mike
  *
  */

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
