/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import training.core.model.Player;

/**
 * Class that represents game board.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public final class ScoreCalculator {

    /**
     * The score.
     */
    private final Map<Player, Integer[]> score;

    /**
     * The board size.
     */
    private final int boardsize = 3;

    /**
     * Instantiates a new score calculator.
     *
     * @param firstplayer The player1
     * @param secondplayer The player2
     */
    public ScoreCalculator(final Player firstplayer,
            final Player secondplayer) {
        this.score = new HashMap<Player, Integer[]>();
        this.score.put(firstplayer, new Integer[] {0, 0, 0, 0, 0, 0, 0, 0});
        this.score.put(secondplayer, new Integer[] {0, 0, 0, 0, 0, 0, 0, 0});
    }

    /**
     * Calculate.
     *
     * @param player The player
     * @param index The index
     */
    public void calculate(final Player player, final int index) {
        final Integer[] scoreTable = this.score.get(player);
        final int row = Math.round(index / this.boardsize);
        final int col = index - Math.round(row * this.boardsize);
        final int diagfirst = 2 * this.boardsize;
        final int diagsecond = 2 * this.boardsize + 1;
        if (col == row) {
            scoreTable[diagfirst] += 1;
        }
        if ((col + row) == this.boardsize - 1) {
            scoreTable[diagsecond] += 1;
        }
        scoreTable[row] += 1;
        final int colIndex = col + this.boardsize;
        scoreTable[colIndex] += 1;
    }

    /**
     * Checks if is winner.
     *
     * @param player The player
     * @return Returns true, if is winner
     */
    public boolean isWinner(final Player player) {
        return Arrays.asList(this.score.get(player)).contains(this.boardsize);
    }

}
