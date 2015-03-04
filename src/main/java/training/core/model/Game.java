package training.core.model;

import training.core.GameRuntimeException;
import training.core.ScoreTable;
import training.core.model.Board.Symbol;

public class Game {

	public enum Player {
		O(Symbol.O), X(Symbol.X);

		private Symbol symbol;

		private Player(Symbol symbol) {
			this.symbol = symbol;
		}

		public Symbol getSymbol() {
			return symbol;
		}

	}

	private Board board;
	private ScoreTable scoreTable;
	private Player activePlayer;
	
	public boolean hasStarted() {
		return board != null;
	}

	public void start(Board board) {
		this.board = board;
		this.activePlayer = Player.O;
		this.scoreTable = new ScoreTable(Player.O, Player.X);
	}

	public void mark(int x, int y) throws GameRuntimeException {
		board.setPosition(x, y, getActivePlayer().getSymbol());
		scoreTable.calculate(activePlayer, x, y);
		if (scoreTable.isWinner(activePlayer)) {
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
		return isFull() || isWinner();
	}

	public boolean isWinner() {
		return scoreTable.isWinner(activePlayer);
	}

	public boolean isFull() {
		return board.isFull();
	}

	public Player getWinner() {
		if (scoreTable.isWinner(activePlayer)) {
			return activePlayer;
		}
		return null;
	}

}
