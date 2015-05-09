/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.core.gameservice;

import training.core.GameRuntimeException;
import training.core.model.Game;
import training.core.model.Player;

/**
 * The Interface GameService.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public interface GameService {

    /**
     * Mark.
     *
     * @param index the index
     * @throws GameRuntimeException the game runtime exception
     */
    void mark(int index) throws GameRuntimeException;

    /**
     * Gets the winner.
     *
     * @return the winner
     */
    Player getWinner();

    /**
     * Checks if is completed.
     *
     * @return true, if is completed
     */
    boolean isCompleted();

    /**
     * Gets the game.
     *
     * @return the game
     */
    Game getGame();

    /**
     * Start.
     *
     * @param game the game
     */
    void start(Game game);

    /**
     * Checks if is started.
     *
     * @return true, if is started
     */
    boolean isStarted();

}
