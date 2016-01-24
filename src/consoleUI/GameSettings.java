package consoleUI;


import PlayerObjs.Player;

/**
 * GameSetting class. This class holds the game settings as specified during the setup stages.
 * Information is populated as a result of the settingsMenu.class being run from the SetUpState.
 * This class holds the rounds per individual game, Player one and two - of type Player.
 */


public class GameSettings 
{	
	//rounds per individual game.
	private int gameRounds;
	private Player[] playerArray = new Player[2];
	
	public void setGameRounds(int rounds) {		
		this.gameRounds = rounds;
	}

	public int getGameRounds() {
		return gameRounds;
	}

	public void setPlayerOne(Player p1) {
		
		playerArray [0] = p1;		
	}

	public Player getPlayerOne() {
		return playerArray[0];
	}

	public void setPlayerTwo(Player p2) {
		
		playerArray [1] = p2;	
	}

	public Player getPlayerTwo() {
		return playerArray[1];
	}

	
	

}
