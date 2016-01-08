package PlayerObjs;

import GameObjs.GameObj;

public class NullPlayerObj extends Player {

	@Override
	public GameObj chooseGameObj(String gameObj) throws Exception {
		
		return null;
	}

	@Override
	public String intelChooseGameObj() throws Exception {

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
