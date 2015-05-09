/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.core.model;

import java.util.LinkedList;
import java.util.List;
import training.core.GameRuntimeException;
import training.core.GameRuntimeException.Warning;

/**
 * The Class Board.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class Board {

    /**
     * Stores the actual board state.
     */
    private List<Symbol> boardState;

    /**
     * Board size (3x3 by default).
     */
    private final Integer boardSize = 3;

    /**
     * Instantiates a new board.
     */
    public Board() {
        this.boardState = new LinkedList<Symbol>();
        for (int i = 0; i < boardSize * boardSize; i++) {
            boardState.add(Symbol.EMPTY);
        }
    }

    /**
     * Instantiates a new board.
     *
     * @param boardDefinition the board definition
     */
    public Board(List<Symbol> boardDefinition) {
        this.boardState = boardDefinition;
    }

    /**
     * Gets the board definition.
     *
     * @return the board definition
     */
    public List<Symbol> getBoardDefinition() {
        return boardState;
    }

    /**
     * Gets the board size.
     *
     * @return the board size
     */
    public Integer getBoardSize() {
        return boardSize;
    }

    /**
     * Mark.
     *
     * @param index the index
     * @param symbol the symbol
     * @throws GameRuntimeException the game runtime exception
     */
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

    /**
     * Checks if is full.
     *
     * @return true, if is full
     */
    public boolean isFull() {
        return !boardState.contains(Symbol.EMPTY);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((boardSize == null) ? 0 : boardSize.hashCode());
        result = prime * result
                + ((boardState == null) ? 0 : boardState.hashCode());
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
        return "Board [boardState=" + boardState + ", boardSize=" + boardSize
                + "]";
    }

}
