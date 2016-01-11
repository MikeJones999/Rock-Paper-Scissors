package consoleUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

public class SettingsMenu {

	private GameSettings gameSettings;
	private boolean menuStatusComplete = false;
	private boolean playersCreated = false;
	private boolean playerNamesCompleted = false;
	
	public SettingsMenu(GameSettings gameSettings) {
		
		this.gameSettings = gameSettings;	
		setDefaultGameRounds();
	}
	
	public void setDefaultGameRounds()
	{
		gameSettings.setGameRounds(3);
	}

	public boolean getComplete() {

		return menuStatusComplete ;
	}
	
	private void setMenuStatusToComplete()
	{
		menuStatusComplete = true;
	}

	public void menuController() throws IOException 
	{	
		int response = 0;
		do
		{
		 response = openingOptions();
		 if(response == 0 || response > 2){
			 System.out.println("That is not an option, please try again");
			 };
		}while(response == 0 ||response > 2);
			
		switch(response)
		{
		case(1):  newGameSelected(); break;
		case(2):  break;
		}
		
		setMenuStatusToComplete();		
	}
		
	
	private int openingOptions() throws IOException
	{
		System.out.println("Mike Jones Rock-Paper-Scissors Game");
		System.out.println("-----------------------------------");
		System.out.println("Please choose a numeric option from the following options...");	
		System.out.println("1) New Game");
		System.out.println("2) Exit");	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int response = parseErrorCatch(str);
		return response;
	}
		

	public void newGameSelected() throws IOException {
		
		System.out.println("Setting Up Game...");
		
		int response = 3;
		do
		{
		 response = obtainNumberOfHumanPlayers();
			 if(response > 2)
			 {
				 System.out.println("That quantity of players is not an option, please try again");
			 };
		}while(response > 2);
		
		switch(response)
		{
			case(0): createPlayers("Computer","Computer"); break;
			case(1): createPlayers("Human", "Computer"); break;
			case(2): createPlayers("Human", "Human"); break;
		}
		
		playersCreated = true;
	}
	

	private int obtainNumberOfHumanPlayers() throws IOException
	{
		System.out.println("How many Human players are there? ");	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int response = parseErrorCatch(str);
		return response;
	}
	
	public void createPlayers(String player1, String player2) {
		PlayerFactory playFact = new PlayerFactory();
		
		Player p1 = playFact.getPlayer(player1);
		Player p2 = playFact.getPlayer(player2);
		gameSettings.setPlayerOne(p1);
		gameSettings.setPlayerTwo(p2);
	}


	public void addPlayerNames(String p1Name, String p2Name) {
		
		gameSettings.getPlayerOne().setName(p1Name);
		gameSettings.getPlayerTwo().setName(p2Name);
		
	}
	
	public int parseErrorCatch(String str)
	{
		int response = 0;
		try
		{
			response = Integer.parseInt(str);
		}
		catch (NumberFormatException e)
		{
			System.out.println("That is not an option, please try again");
		}
		return response;
	}
}
