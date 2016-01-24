package PlayerObjs;

/**
 * PlayerFactory - used to obtain a subclass of Player (Human/Computer)
 * In order to not throw an exception (even though this is controlled by the gameEngine) a null player object is returned
 * @author mike
 *
 */
public class PlayerFactory {

	
	public Player getPlayer(String playerType) //throws Exception 
	{
		if(playerType == null)
		{
			//throw new Exception("Player Type not specified");
			return new NullPlayerObj();
		}
		
		if(playerType.equalsIgnoreCase("HUMAN"))
		{
			return new Human();
		}
		
		else if(playerType.equalsIgnoreCase("COMPUTER"))
		{
			
			return new Computer();
		}
		else 
		{
			return new NullPlayerObj();
		}
		
		//throw new Exception("Player Type not specified");
	}
	
	
	
}
