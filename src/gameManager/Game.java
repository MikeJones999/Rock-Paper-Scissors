package gameManager;

import PlayerObjs.Player;

public class Game {

	private Player winner;
	private Player looser;
	private boolean draw = false;
	private int winnerWins;
	private int looserWins;
	
	
	public void setLooserWins(int looserWins) {
		this.looserWins = looserWins;
	}

	private int numberOfRounds;
	
	public boolean isDraw() {
		return draw;
	}

	public void setDraw(boolean draw) {
		this.draw = draw;
	}
	
	
	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player player) {

		this.winner = player;
	}

	public void setLooser(Player looser) {

		this.looser = looser;
	}

	public Player getLooser() {
		
		return looser;
	}

	public void setWinnerWin(int winCount) {
		this.winnerWins = winCount;
	}

	public int getWinnerWins() {
		return winnerWins;
	}

	public void setRounds(int rounds) {
		
		this.numberOfRounds = rounds;
	}

	public int getRounds() {
		
		return numberOfRounds;
	}


	public int getLooserWins() {
		
		return looserWins;
	}
	
	public int getWinnerLoses()
	{
		return getLooserWins();
	}
	
	public int getNumberOfDraws()
	{
		return numberOfRounds - looserWins - winnerWins;
	}

	
	
	
}
