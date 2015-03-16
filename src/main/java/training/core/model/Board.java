package training.core.model;

import java.util.LinkedList;
import java.util.List;

import training.core.GameRuntimeException;
import training.core.GameRuntimeException.Warning;

/**
 * Class that represents game board.
 */
public class Board {

	/** Stores the actual board state. */
	private List<Symbol> boardState;
	/** Board size (3x3 by default). */
	private final Integer boardSize = 3;

	public Board() {
		this.boardState = new LinkedList<Symbol>();
		for (int i = 0; i < boardSize*boardSize; i++) {
			boardState.add(Symbol.EMPTY);
		}
	}

	public Board(List<Symbol> boardDefinition) {
		this.boardState = boardDefinition;
	}

	public List<Symbol> getBoardDefinition() {
		return boardState;
	}

	public Integer getBoardSize() {
		return boardSize;
	}

	public void mark(int index, Symbol symbol) throws GameRuntimeException {
		try {
			boolean isCellUsed = !boardState.get(index).equals(Symbol.EMPTY);
			if (isCellUsed) {
				throw new GameRuntimeException(Warning.POSITION_ALREADY_USED);
			}
			boardState.set(index, symbol);
		} catch (IndexOutOfBoundsException e) {
			throw new GameRuntimeException(Warning.BOARD_SIZE_EXCEEDED);
		}
	}

	public boolean isFull() {
		return !boardState.contains(Symbol.EMPTY);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boardSize == null) ? 0 : boardSize.hashCode());
		result = prime * result + ((boardState == null) ? 0 : boardState.hashCode());
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
		if (boardSize == null) {
			if (other.boardSize != null)
				return false;
		} else if (!boardSize.equals(other.boardSize))
			return false;
		if (boardState == null) {
			if (other.boardState != null)
				return false;
		} else if (!boardState.equals(other.boardState))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [boardState=" + boardState + ", boardSize=" + boardSize + "]";
	}

}
