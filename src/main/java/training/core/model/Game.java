package training.core.model;

import training.core.ScoreCalculator;

public class Game {

	private final Board board;
	private Player activePlayer;
	private final ScoreCalculator scoreCalculator;

	public Game(final Board board) {
		this.board = board;
		this.activePlayer = Player.O;
		this.scoreCalculator = new ScoreCalculator(Player.O, Player.X);
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public ScoreCalculator getScoreCalculator() {
		return scoreCalculator;
	}

	public Board getBoard() {
		return board;
	}

}
