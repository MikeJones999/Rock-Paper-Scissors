package computerIntelligence;

import java.util.Random;

import GameObjs.GameObjectChoice;

public abstract class Intelligence {

	
//	public enum GameObjectChoice {
//		
//		Rock, Paper, Scissors;
//		
//		
//		
		public static GameObjectChoice getRandomGameObjectChoice()
		{
			GameObjectChoice[] gameObjectArray = GameObjectChoice.values();
			Random ran = new Random();
			return gameObjectArray[ran.nextInt(gameObjectArray.length)];
		}
//	
//	};
	
		
	public abstract String makeChoice();



	
	
	
	
}