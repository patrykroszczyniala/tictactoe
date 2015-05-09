/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class CommandParser.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class CommandParser {

    /**
     * The commands.
     */
    private Set<Command> commands = new HashSet<Command>();

    /**
     * The matcher.
     */
    private Matcher matcher;

    /**
     * Instantiates a new command parser.
     */
    public CommandParser() {
        commands.addAll(Arrays.asList(GameCommand.values()));
        commands.addAll(Arrays.asList(ApplicationCommand.values()));
    }

    /**
     * Parses the.
     *
     * @param command the command
     * @return the command
     */
    public Command parse(String command) {
        for (Command c : commands) {
            if (matches(c.getPattern(), command)) {
                return c;
            }
        }
        return ApplicationCommand.UNKNOWN_COMMAND;
    }

    /**
     * Group.
     *
     * @param group the group
     * @return the string
     */
    public String group(int group) {
        return matcher.group(group);
    }

    /**
     * Matches.
     *
     * @param pattern the pattern
     * @param command the command
     * @return true, if successful
     */
    private boolean matches(String pattern, String command) {
        Pattern p = Pattern.compile(pattern);
        matcher = p.matcher(command);
        return matcher.matches();
    }

}
