package computerIntelligence;

/**
 * Computer intelligence factory not used - 
 * however it is available should user wish to increase availability of intelligence levels.
 * Specify Novice or Intermediate to obtain a level of Intelligence
 * @author mike
 *
 */
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
