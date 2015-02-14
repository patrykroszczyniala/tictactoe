package training.core.model;

import training.core.GameRuntimeException;

public class Game {

	public enum Player {
		O, X;
	}

	private Board board;
	private Player activePlayer;

	public Game() {
	}

	public void start() {
		start(new Board());
	}
	
	public boolean hasStarted() {
		return board!=null;
	}

	public void start(Board board) {
		this.board = board;
		this.activePlayer = Player.O;
	}

	public void move(int x, int y) throws GameRuntimeException {
		board.setPosition(x, y, getActivePlayer().toString().toLowerCase());
		if (getWinner() != null) {
			return;
		}
		setActivePlayer(activePlayer == Player.O ? Player.X : Player.O);
	}

	public Board getBoard() {
		return board;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public boolean isCompleted() {
		return board.completed();
	}

	public Player getWinner() {
		if (board.completed()) {
			return activePlayer;
		}
		return null;
	}

}
