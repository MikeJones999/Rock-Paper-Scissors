package GameObjs;

/**
 * GameObj class is the parent class of any GameObj that is used within this game.
 * Any Game Object created must inherit this class and its toString Method.
 * Reflection used in cooperation of factory method to obtain GameObj specified via String Name.
 * @author mike
 *
 */

public abstract class GameObj {

	protected GameObj() {
		//super();
	}

//	public abstract int beats(Rock rock);
//
//	public abstract int beats(Paper paper);
//
//	public abstract int beats(Scissors paper);
	
	/**
	 * The leading GameObj calls this method and passes another GameObj.
	 * This method will then compare the two objects and identify a winner/draw
	 * @param GameObj
	 * @return int - specifies to the calling class if the leading class..
	 * won 1, lost -1, or drew 0 
	 *
	 */
	public int beats(GameObj obj){	
		
		GameObjectChoice[] gameObjArr = GameObjectChoice.getAllGameObjects();
		GameObjectRules rules = new GameObjectRules(gameObjArr);
		return rules.caluclateWin(this, obj);
		
	};
	
	/**
	 * The name given to this GameObj must match that of the GameObj placed within GameObjectChoice
	 */
	public abstract String toString();
	
	
	/**
	 * Factory method using Reflection to obtain a new GameObj.
	 * Reflection was used so that any new GameObj in the future could be used.
	 * Due to the way Reflection is used GameObjs(package name) was added to each gameObject in order to correctly ascertain the right class
	 * @param String gameObjName (desired  object to obtain)
	 * @return GameObj of type specified in parameter - Or Null Object - No Exceptions thrown
	 */
	public static GameObj newGameObj(String gameObjName)
	{		
		String capWord = capitaliseGameObjName(gameObjName);	
		StringBuilder str = new StringBuilder();
		str.append("GameObjs.");
		str.append(capWord);
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


	/**
	 * Capitalises the first letter of every gameObject's name passed to it.
	 * This allows for an accurate check to be conducted using reflection.
	 * @param gameObjName
	 * @return String with first letter Capitalised - rest lower case
	 */
	private static String capitaliseGameObjName(String gameObjName) {		
		StringBuilder sb = new StringBuilder(); 
		String temp = gameObjName.toLowerCase();
		sb.append(temp.substring(0, 1).toUpperCase());
		sb.append(temp.substring(1));
		return sb.toString();
	}

}