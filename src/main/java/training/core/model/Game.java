/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.core.model;

import training.core.ScoreCalculator;

/**
 * The Class Game.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class Game {

    /**
     * The board.
     */
    private final Board board;

    /**
     * The active player.
     */
    private Player activePlayer;

    /**
     * The score calculator.
     */
    private final ScoreCalculator scoreCalculator;

    /**
     * Instantiates a new game.
     *
     * @param board The active board
     */
    public Game(final Board board) {
        this.board = board;
        this.activePlayer = Player.O;
        this.scoreCalculator = new ScoreCalculator(Player.O, Player.X);
    }

    /**
     * Gets the active player.
     *
     * @return The active player
     */
    public Player getActivePlayer() {
        return activePlayer;
    }

    /**
     * Sets the active player.
     *
     * @param activePlayer The new active player
     */
    public void setActivePlayer(final Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    /**
     * Gets the score calculator.
     *
     * @return The score calculator
     */
    public ScoreCalculator getScoreCalculator() {
        return scoreCalculator;
    }

    /**
     * Gets the board.
     *
     * @return The board
     */
    public Board getBoard() {
        return board;
    }

}
