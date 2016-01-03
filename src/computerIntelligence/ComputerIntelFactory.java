package computerIntelligence;


public class ComputerIntelFactory {

	
	public Intelligence getIntel(String intelLevel) throws Exception
	{
		if(intelLevel == null)
		{
			throw new Exception("Intel Type not specified");
		}
		
		if(intelLevel.equalsIgnoreCase("Novice"))
		{
			return new NoviceAI();
		}
		else if (intelLevel.equalsIgnoreCase("Intermediate"))
		{
			return new IntermediateAI();
		}

		//should just return novice as default
		return new NoviceAI();
		//throw new Exception("Intel Type not specified");
	}
	
}
