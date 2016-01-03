package PlayerObjs;


public class PlayerFactory {

	
	public Player getPlayer(String playerType) throws Exception
	{
		if(playerType == null)
		{
			throw new Exception("Player Type not specified");
		}
		
		if(playerType.equalsIgnoreCase("HUMAN"))
		{
			return new Human();
		}
		
		else if(playerType.equalsIgnoreCase("COMPUTER"))
		{
			//return default novice Computer - random guessing
			
			return new Computer();
		}
		
		throw new Exception("Player Type not specified");
	}
	
	
	
}
