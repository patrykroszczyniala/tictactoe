/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.core;

import java.util.LinkedList;
import java.util.List;
import training.core.model.Board;
import training.core.model.BoardState;
import training.core.model.Symbol;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * The Class BoardService.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class BoardService {

    /**
     * The state.
     */
    private BoardState state;

    /**
     * Instantiates a new board service.
     *
     * @param state the state
     */
    public BoardService(BoardState state) {
        this.state = state;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public BoardState getState() {
        return state;
    }

    /**
     * Hint.
     */
    public void hint() {
        state.setHintEnabled(!state.isHintEnabled());
    }

    /**
     * As string.
     *
     * @param board the board
     * @return the string
     */
    public String asString(Board board) {
        int index = 0;
        List<List<Symbol>> boardDef = Lists.partition(
                board.getBoardDefinition(), board.getBoardSize());
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
