package PlayerObjs;

import GameObjs.GameObj;


/**
 * NullPlayerObj - returned when utilising factory method to obtain a Player.
 * This prevents an exception being throw. The Null player is handled and a new player type is re-requested
 * @author mike
 *
 */
public class NullPlayerObj extends Player {

	@Override
	public GameObj chooseGameObj(String gameObj){
		
		return null;
	}


	@Override
	public void setName(String name) {
		//do nothing
		
	}

	@Override
	public String getName() {
	
		return "Not a specified player object";
	}

}
