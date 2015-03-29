package training.consoleapp.core.command;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates command-line commands by parsing user inputs.
 * 
 * @author proszczyniala
 */
public class CommandParser {

	private Set<Command> commands = new HashSet<Command>();
	private Matcher matcher;

	public CommandParser() {
		commands.addAll(Arrays.asList(GameCommand.values()));
		commands.addAll(Arrays.asList(ApplicationCommand.values()));
	}

	public Command parse(String command) {
		for (Command c : commands) {
			if (matches(c.getPattern(), command)) {
				return c;
			}
		}
		return ApplicationCommand.UNKNOWN_COMMAND;
	}

	public String group(int group) {
		return matcher.group(group);
	}

	private boolean matches(String pattern, String command) {
		Pattern p = Pattern.compile(pattern);
		matcher = p.matcher(command);
		return matcher.matches();
	}

}