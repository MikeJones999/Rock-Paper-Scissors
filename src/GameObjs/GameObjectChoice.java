package GameObjs;

import java.util.Random;

public enum GameObjectChoice {
	
	Rock, Paper, Scissors;

	public static String getRandomGameObjectChoice()
	{
		GameObjectChoice[] gameObjectArray = GameObjectChoice.values();
		Random ran = new Random();
		return gameObjectArray[ran.nextInt(gameObjectArray.length)].toString();
	}
	
}
