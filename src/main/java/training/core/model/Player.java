/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.core.model;

/**
 * The Enum Player.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public enum Player {

    /**
     * The o.
     */
    O(Symbol.O),

    /**
     * The x.
     */
    X(Symbol.X);

    /**
     * The current symbol.
     */
    private Symbol current;

    /**
     * Instantiates a new player.
     *
     * @param symbol The symbol
     */
    private Player(final Symbol symbol) {
        this.current = symbol;
    }

    /**
     * Gets the symbol.
     *
     * @return The symbol
     */
    public Symbol getSymbol() {
        return this.current;
    }

}
