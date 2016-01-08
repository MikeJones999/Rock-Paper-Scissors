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



	@Override
	public void setName(String name) {
		this.name = name; 
	}



	@Override
	public String getName() {
		StringBuilder sb = new StringBuilder();
		sb.append("(Computer) ");
		sb.append(this.name);
		
		return sb.toString();
	}
	
	
	
}
