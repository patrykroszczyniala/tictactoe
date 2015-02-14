package training.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import training.core.GameRuntimeException;
import training.core.GameRuntimeException.Warning;

public class Board {

	public enum Symbol {
		X, O, EMPTY;
	}

	private Symbol[][] boardDefinition;

	public Board() {
		this.boardDefinition = new Symbol[][] { { Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY },
				{ Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY }, { Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY } };
	}

	public Board(Symbol[][] boardDefinition) {
		this.boardDefinition = boardDefinition;
	}

	public Symbol[][] getBoardDefinition() {
		return boardDefinition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(boardDefinition);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(boardDefinition, other.boardDefinition))
			return false;
		return true;
	}

	public void setPosition(int x, int y, Symbol symbol) throws GameRuntimeException {
		try {
			boolean isCellUsed = !boardDefinition[x][y].equals(Symbol.EMPTY);
			if (isCellUsed) {
				throw new GameRuntimeException(Warning.POSITION_ALREADY_USED);
			}
			boardDefinition[x][y] = symbol;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new GameRuntimeException(Warning.BOARD_SIZE_EXCEEDED);
		}
	}

	public boolean isFull() {
		for (Symbol[] row : boardDefinition) {
			for (Symbol symbol : row) {
				if (Symbol.EMPTY == symbol) {
					return false;
				}
			}
		}
		return true;
	}

	// TODO
	public boolean isWinner() {
		List<Boolean> wins = new ArrayList<Boolean>();
		wins.add(Arrays.equals(boardDefinition[0], new Symbol[]{Symbol.O, Symbol.O, Symbol.O}));
		wins.add(Arrays.equals(boardDefinition[1], new Symbol[]{Symbol.O, Symbol.O, Symbol.O}));
		wins.add(Arrays.equals(boardDefinition[2], new Symbol[]{Symbol.O, Symbol.O, Symbol.O}));
		wins.add(Arrays.equals(boardDefinition[0], new Symbol[]{Symbol.X, Symbol.X, Symbol.X}));
		wins.add(Arrays.equals(boardDefinition[1], new Symbol[]{Symbol.X, Symbol.X, Symbol.X}));
		wins.add(Arrays.equals(boardDefinition[2], new Symbol[]{Symbol.X, Symbol.X, Symbol.X}));
		
		return wins.contains(Boolean.TRUE);
	}

}
