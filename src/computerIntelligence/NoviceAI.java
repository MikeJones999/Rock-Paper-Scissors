package computerIntelligence;

import GameObjs.GameObjectChoice;

public class NoviceAI implements Intelligence {

	@Override
	public String makeChoice() 
	{		
		return GameObjectChoice.getRandomGameObjectChoice().toString();
		
	}

	
}
