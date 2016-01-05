package computerIntelligence;

import GameObjs.GameObjectChoice;

public class NoviceAI extends Intelligence {

	@Override
	public String makeChoice() 
	{		
		return GameObjectChoice.getRandomGameObjectChoice().toString();
		
	}

	
}
