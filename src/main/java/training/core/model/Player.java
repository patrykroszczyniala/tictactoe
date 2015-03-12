package training.core.model;

import training.core.model.Board.Symbol;

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