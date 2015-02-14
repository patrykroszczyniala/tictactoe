package training.application.console.model;

import training.core.model.Board;

public class ConsoleBoard extends Board {
	
	public ConsoleBoard() {
		super();
	}

	public ConsoleBoard(Symbol[][] boardDefinition) {
		super(boardDefinition);
	}

	@Override
	public String toString() {
		String boardAsString = "";
		for (int i = 0; i < getBoardDefinition().length; i++) {
			boardAsString += "|";
			for (int j = 0; j < getBoardDefinition().length; j++) {
				Symbol symbol = getBoardDefinition()[j][i];
				String symbolString = null;
				if (Symbol.X==symbol) {
					symbolString = "x";
				}
				else if (Symbol.O==symbol) {
					symbolString = "o";
				}
				else if (Symbol.EMPTY==symbol) {
					symbolString = "_";
				}
				boardAsString += " " + symbolString + " |";
			}
			boolean hasNextRow = i + 1 < getBoardDefinition().length;
			if (hasNextRow) {
				boardAsString += "\r\n";
			}
		}
		return boardAsString;
	}
	
}
