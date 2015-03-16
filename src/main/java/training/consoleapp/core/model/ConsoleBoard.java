package training.consoleapp.core.model;

import java.util.List;

import training.core.model.Board;
import training.core.model.Symbol;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class ConsoleBoard extends Board {

	public ConsoleBoard() {
		super();
	}

	public ConsoleBoard(List<Symbol> boardDefinition) {
		super(boardDefinition);
	}

	@Override
	public String toString() {
		List<List<Symbol>> boardDef = Lists.partition(getBoardDefinition(), getBoardSize());
		List<String> rows = Lists.newArrayList();
		for (List<Symbol> row : boardDef) {
			Iterable<String> rowString = Iterables.transform(row, new Function<Symbol, String>() {
				public String apply(Symbol symbol) {
					if (Symbol.X.equals(symbol)) {
						return "x";
					} else if (Symbol.O.equals(symbol)) {
						return "o";
					} else {
						return " ";
					}
				}
			});
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
