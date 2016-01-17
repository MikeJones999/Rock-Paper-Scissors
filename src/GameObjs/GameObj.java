package GameObjs;

public abstract class GameObj {

	protected GameObj() {
		//super();
	}

	
	
	public abstract int beats(Rock rock);

	public abstract int beats(Paper paper);

	public abstract int beats(Scissors paper);
	
	public int beats(GameObj obj){	
		
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		return rules.caluclateWin(this, obj);
		
	};
	
	public abstract String toString();
	
	public static GameObj newGameObj(String gameObjName)
	{		
		//Need to address the inconsistent capitalisation of each game object
		StringBuilder str = new StringBuilder();
		str.append("GameObjs.");
		str.append(gameObjName);
		String pack = str.toString();
		
		try {				
				Class<?> gameObj = Class.forName(pack);
			
				if(GameObj.class.isAssignableFrom(gameObj))
				{
					Object newGameObj = gameObj.newInstance();
					return (GameObj) newGameObj;
				}
			
			}		
			catch(Exception e)
			{
				System.out.println("That is not a designated Game Object, please choose again...");
				return new NullObj();
				//throw new Exception("Unknown Game Object : " + e );
			}
		
		System.out.println("That is not a designated Game Object, please choose again...");
		return new NullObj();
		//throw new Exception("Unknown Game Object");
	}

}