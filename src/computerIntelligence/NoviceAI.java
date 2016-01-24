package computerIntelligence;

import GameObjs.GameObjectChoice;

/**
 * Novice AI is a basic random selection of a game object - simply calls
 * the method specified within GameObjectChoice to randomly choose one of the available 
 * GameObjs
 * @author mike
 *
 */


public class NoviceAI implements Intelligence {

	@Override
	public String makeChoice() 
	{		
		return GameObjectChoice.getRandomGameObjectChoice().toString();
		
	}

	
}
