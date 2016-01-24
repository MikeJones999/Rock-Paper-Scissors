package consoleUI;


import java.util.Scanner;

import PlayerObjs.Player;
import PlayerObjs.PlayerFactory;

/**
 * SettingMenu is the userInterface to setup the game 
 * Again no MVC pattern - initController is used to call other methods.
 * 
 */

public class SettingsMenu implements Controller, IntInputHandler{

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

	//method called first to control the setup interface
	public boolean initController()  
	{	
		int response = -55;
		do
		{
		 response = openingOptions();
		 if(response == 0 || response > 2 ||response == -55){
			 System.out.println("That is not an option, please try again");
			 };
		}while(response < 1 || response > 2);
		
		
		switch(response)
		{
			case(1):  newGameSelected(); break;
			case(2):  exitGame(); return false; //exit game and console
			default:  exitGame();
		}
		obtainNumberOfGameRounds();
		setMenuStatusToComplete();	
		return menuStatusComplete;
	}	
	
	

	private void exitGame() {
		System.out.println("Thank you for playing and goodbye");
		System.exit(0);		
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
		
	/**
	 * Called when new game is selected and player types need to be specified.
	 */
	public void newGameSelected()
	{		
		System.out.println("Setting Up Game...");		
		int response = -55;
		do
		{
		 response = obtainNumberOfHumanPlayers();
			 if(response > 2 )
			 {
				 System.out.println("That quantity of players is not an option, please try again");
			 };
		}while(response < 1 || response > 2);		
		
		switch(response)
		{
		    case (1): createPlayers("Human", "Computer"); break;
			case(2): createPlayers("Computer","Computer"); break;
			default: createPlayers("Computer","Computer");
			//case(3): createPlayers("Human", "Human"); break;
		}		
		createPlayerNamesMenu();	
	}
	
	
	private int obtainNumberOfHumanPlayers()
	{
		//System.out.println("How many Human players are there? (Max 1)");
		System.out.print("Enter 1 (one) if you would like to play against the computer,");
		System.out.println(" or Enter 2 (two) if you want to view a Computer v Computer game)");	
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
	
	/**
	 * Implemented method from IntInputHandler
	 */
	public int parseErrorCatch(String str)
	{
		int response = 0;
		try
		{
			response = Integer.parseInt(str);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Invalid option, please try again");
			response = -55;
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
		
		if(response <= 1) {
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
