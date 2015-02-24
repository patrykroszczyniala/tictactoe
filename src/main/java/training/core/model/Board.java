package training.core.model;

import java.util.ArrayList;
import java.util.List;

import training.core.GameRuntimeException;
import training.core.GameRuntimeException.Warning;

import com.google.common.collect.Lists;

/**
 * Class that represents game board.
 */
public class Board {

	/** Symbol used to present board cell value. */
	public enum Symbol {
		X, O, EMPTY;
	}

	/** Stores the actual board state. */
	private List<List<Symbol>> boardState;

	/** Board size (3x3 by default). */
	private final Integer boardSize = 3;

	public Board() {
		this.boardState = new ArrayList<List<Symbol>>();
		for (int i = 0; i < boardSize; i++) {
			List<Symbol> row = new ArrayList<Symbol>();
			for (int j = 0; j < boardSize; j++) {
				row.add(Symbol.EMPTY);
			}
			boardState.add(row);
		}
	}

	public Board(List<List<Symbol>> boardDefinition) {
		this.boardState = boardDefinition;
	}

	public List<List<Symbol>> getBoardDefinition() {
		return boardState;
	}

	public void setPosition(int x, int y, Symbol symbol) throws GameRuntimeException {
		try {
			boolean isCellUsed = !boardState.get(y).get(x).equals(Symbol.EMPTY);
			if (isCellUsed) {
				throw new GameRuntimeException(Warning.POSITION_ALREADY_USED);
			}
			boardState.get(y).set(x, symbol);
		} catch (IndexOutOfBoundsException e) {
			throw new GameRuntimeException(Warning.BOARD_SIZE_EXCEEDED);
		}
	}

	public boolean isFull() {
		for (List<Symbol> row : boardState) {
			if (row.contains(Symbol.EMPTY)) {
				return false;
			}
		}
		return true;
	}

	// TODO
	public boolean isWinner() {
		List<Boolean> wins = new ArrayList<Boolean>();
		wins.add(boardState.get(0).equals(Lists.newArrayList(Symbol.O, Symbol.O, Symbol.O)));
		wins.add(boardState.get(1).equals(Lists.newArrayList(Symbol.O, Symbol.O, Symbol.O)));
		wins.add(boardState.get(2).equals(Lists.newArrayList(Symbol.O, Symbol.O, Symbol.O)));
		wins.add(boardState.get(0).equals(Lists.newArrayList(Symbol.X, Symbol.X, Symbol.X)));
		wins.add(boardState.get(1).equals(Lists.newArrayList(Symbol.X, Symbol.X, Symbol.X)));
		wins.add(boardState.get(2).equals(Lists.newArrayList(Symbol.X, Symbol.X, Symbol.X)));

		wins.add(Lists.newArrayList(boardState.get(0).get(0), boardState.get(1).get(0), boardState.get(2).get(0))
				.equals(Lists.newArrayList(Symbol.X, Symbol.X, Symbol.X)));
		wins.add(Lists.newArrayList(boardState.get(0).get(1), boardState.get(1).get(1), boardState.get(2).get(1))
				.equals(Lists.newArrayList(Symbol.X, Symbol.X, Symbol.X)));
		wins.add(Lists.newArrayList(boardState.get(0).get(2), boardState.get(1).get(2), boardState.get(2).get(2))
				.equals(Lists.newArrayList(Symbol.X, Symbol.X, Symbol.X)));
		wins.add(Lists.newArrayList(boardState.get(0).get(0), boardState.get(1).get(0), boardState.get(2).get(0))
				.equals(Lists.newArrayList(Symbol.O, Symbol.O, Symbol.O)));
		wins.add(Lists.newArrayList(boardState.get(0).get(1), boardState.get(1).get(1), boardState.get(2).get(1))
				.equals(Lists.newArrayList(Symbol.O, Symbol.O, Symbol.O)));
		wins.add(Lists.newArrayList(boardState.get(0).get(2), boardState.get(1).get(2), boardState.get(2).get(2))
				.equals(Lists.newArrayList(Symbol.O, Symbol.O, Symbol.O)));

		return wins.contains(Boolean.TRUE);
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

}
