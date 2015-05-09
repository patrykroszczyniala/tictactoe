/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command;

/**
 * The Enum GameCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public enum GameCommand implements Command {

    /**
     * The users move.
     */
    USERS_MOVE("(\\d)"),
    /**
     * The help.
     */
    HELP("help"),
    /**
     * The hint.
     */
    HINT("hint");

    /**
     * The pattern.
     */
    private String pattern;

    /**
     * Instantiates a new game command.
     *
     * @param pattern the pattern
     */
    private GameCommand(final String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
