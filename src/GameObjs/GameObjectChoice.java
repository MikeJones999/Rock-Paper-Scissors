package GameObjs;



import java.util.Random;

/**
 * GameObjectChoice class holds enums representing all the game objects available.
 * If a new GameObj is created then it must be added below and in a specific order...
 * see -stackoverflow.com/questions/9553058/scalable-solution-for-rock-paper-scissor
 * 
 */


public enum GameObjectChoice {
	
	Rock, Paper, Scissors; //lizzard, Spock;

	/**
	 * Returns a random selection of one of the GameObjects placed within this class as an Enum
	 * This will handle any added objects - however if you add an Enum here then a GameObj must be created
	 * representing to coincide with this enum. 
	 * @return String name of selected GameObj
	 */
	public static String getRandomGameObjectChoice()
	{
		GameObjectChoice[] gameObjectArray = GameObjectChoice.values();
		Random ran = new Random();
		return gameObjectArray[ran.nextInt(gameObjectArray.length)].toString();
	}
	
	/**
	 * Returns all available GameObjects specified within the Enum GameObjectChoice class.
	 * @return array of GameObjectChoice
	 */
	public static GameObjectChoice[] getAllGameObjects()
	{
		return GameObjectChoice.values();	
	}
	
}
