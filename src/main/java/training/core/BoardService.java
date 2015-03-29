package training.core;

import java.util.LinkedList;
import java.util.List;

import training.core.model.Board;
import training.core.model.BoardState;
import training.core.model.Symbol;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class BoardService {

	private BoardState state;

	public BoardService(BoardState state) {
		this.state = state;
	}

	public BoardState getState() {
		return state;
	}

	public void hint() {
		state.setHintEnabled(!state.isHintEnabled());
	}

	public String asString(Board board) {
		int index = 0;
		List<List<Symbol>> boardDef = Lists.partition(board.getBoardDefinition(), board.getBoardSize());
		List<String> rows = Lists.newArrayList();
		for (List<Symbol> row : boardDef) {
			List<String> rowString = new LinkedList<String>();
			for (Symbol symbol : row) {
				if (Symbol.X.equals(symbol)) {
					rowString.add("x");
				} else if (Symbol.O.equals(symbol)) {
					rowString.add("o");
				} else {
					if (state.isHintEnabled()) {
						rowString.add(String.valueOf(index));
					} else {
						rowString.add(" ");
					}
				}
				index++;
			}
			rows.add("*   " + Joiner.on(" | ").join(rowString) + "   *");
		}
		String result = "*****************\r\n";
		result += "*               *\r\n";
		result += Joiner.on("\r\n*  ---+---+---  *\r\n").join(rows);
		result += "\r\n*               *\r\n";
		result += "*****************\r\n";
		return result;
	}

}
