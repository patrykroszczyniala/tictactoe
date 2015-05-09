/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command;

/**
 * The Enum ApplicationCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public enum ApplicationCommand implements Command {

    /**
     * The start application.
     */
    START_APPLICATION,
    /**
     * The exit application.
     */
    EXIT_APPLICATION("exit"),
    /**
     * The start game.
     */
    START_GAME("y|start"),
    /**
     * The start multiplayer game.
     */
    START_MULTIPLAYER_GAME("start multiplayer"),
    /**
     * The unknown command.
     */
    UNKNOWN_COMMAND;

    /**
     * The pattern.
     */
    private String pattern;

    /**
     * Instantiates a new application command.
     */
    private ApplicationCommand() {
        this.pattern = "";
    }

    /**
     * Instantiates a new application command.
     *
     * @param pattern the pattern
     */
    private ApplicationCommand(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

}
