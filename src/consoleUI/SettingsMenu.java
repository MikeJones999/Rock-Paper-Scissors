package consoleUI;


import java.util.Scanner;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

public class SettingsMenu {

	private GameSettings gameSettings;
	private boolean menuStatusComplete = false;
	
	public SettingsMenu(GameSettings gameSettings){
		
		this.gameSettings = gameSettings;	
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

	public void menuController()  
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
		
	
	

	private int openingOptions()
	{
		System.out.println("Mike Jones Rock-Paper-Scissors Game");
		System.out.println("-----------------------------------");
		System.out.println("Please choose a numeric option from the following options...");	
		System.out.println("1) New Game");
		System.out.println("2) Exit");	

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int response = parseErrorCatch(str);
		return response;
	}
		

	public void newGameSelected()
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
	

	private int obtainNumberOfHumanPlayers()
	{
		System.out.println("How many Human players are there? (Max 2)");	
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
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

	private void createPlayerNamesMenu() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter a name for Player One...");			
		String player1 = scan.nextLine();
		System.out.println("Please Enter a name for Player Two...");			
		String player2 = scan.nextLine();
		addPlayerNames(player1,player2);		
	}
	
	private void obtainNumberOfGameRounds() {
		
		Scanner scan = new Scanner(System.in);
		boolean complete = false;
		
		do
		{
		System.out.println("Please Enter the number of rounds to play from 3 upwards...");			
		String str = scan.nextLine();
		int response = parseErrorCatch(str);
		complete = verifyRounds(response);
		}while(!complete);	
	}

	//must be an odd number
	private boolean verifyRounds(int response) {
		
		if(response == 0 || response == 1) {
			System.out.println("That number is not applicable for this game.");
			return false;
		}
		else
		{
			if(response % 2 == 0)
			{
				System.out.println("That number is not an odd number.");
				return false;
			}
		}
		setGameRounds(response);
		return true;
	}
}
