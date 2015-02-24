package training.consoleapp.core.model;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import training.core.model.Board;

public class ConsoleBoard extends Board {

	public ConsoleBoard() {
		super();
	}

	public ConsoleBoard(List<List<Symbol>> boardDefinition) {
		super(boardDefinition);
	}

	@Override
	public String toString() {
		List<String> rows = Lists.newArrayList();
		for (List<Symbol> row : getBoardDefinition()) {
			Iterable<String> rowString = Iterables.transform(row, new Function<Symbol, String>() {
				public String apply(Symbol symbol) {
					if (Symbol.X.equals(symbol)) {
						return "x";
					}
					else if (Symbol.O.equals(symbol)) {
						return "o";
					}
					else {
						return "_";
					}
				}
			});
			rows.add("| "+Joiner.on(" | ").join(rowString)+" |");
		}
		return Joiner.on("\r\n").join(rows);
	}
	
}
