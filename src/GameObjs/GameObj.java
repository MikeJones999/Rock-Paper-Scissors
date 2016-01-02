package GameObjs;

public abstract class GameObj {

	protected GameObj() {
		//super();
	}

	public abstract int beats(Rock rock);

	public abstract int beats(Paper paper);

	public abstract int beats(Scissors paper);
	
	public static GameObj newGameObj(String gameObjName) throws Exception 
	{
		
		System.out.println("gameObj: " + gameObjName);
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
				throw new Exception("Unknown Game Object : " + e );
			}
		
		throw new Exception("Unknown Game Object");
	}

}