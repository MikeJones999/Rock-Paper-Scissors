package consoleUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

public class SettingsMenu {

	private GameSettings gameSettings;
	private boolean menuStatusComplete = false;
	
	public SettingsMenu(GameSettings gameSettings){
		
		this.gameSettings = gameSettings;	
		
		try {
				menuController();
			} 
		catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
	
	public void setGameRounds(int n)
	{
		gameSettings.setGameRounds(n);
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

		obtainNumberOfGameRounds();
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
		

	public void newGameSelected() throws IOException 
	{		
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
		
		createPlayerNamesMenu();
	
		
	}
	

	private int obtainNumberOfHumanPlayers() throws IOException
	{
		System.out.println("How many Human players are there? ");	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int response = parseErrorCatch(str);
		return response;
	}
	
	
	
	
	private void createPlayers(String player1, String player2) {
		PlayerFactory playFact = new PlayerFactory();
		
		Player p1 = playFact.getPlayer(player1);
		Player p2 = playFact.getPlayer(player2);
		gameSettings.setPlayerOne(p1);
		gameSettings.setPlayerTwo(p2);
	}


	private void addPlayerNames(String p1Name, String p2Name) {
		
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

	private void createPlayerNamesMenu() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter a name for Player One...");			
		String player1 = br.readLine();
		System.out.println("Please Enter a name for Player Two...");			
		String player2 = br.readLine();
		addPlayerNames(player1,player2);		
	}
	
	private void obtainNumberOfGameRounds() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean complete = false;
		
		do
		{
		System.out.println("Please Enter the number of rounds to play from 3 upwards. Default set to 3...");			
		String str = br.readLine();
		int response = parseErrorCatch(str);
		complete = verifyRounds(response);
		}while(!complete);	
	}

	//must be an odd number
	private boolean verifyRounds(int response) {
		
		if(response == 0 || response == 1) {
			System.out.println("That number is not applicable for this game, please chose another number");
			return false;
		}
		else
		{
			if(response % 2 == 0)
			{
				System.out.println("That number is not an odd number, please chose another number");
				return false;
			}
		}
		setGameRounds(response);
		return true;
	}
}
