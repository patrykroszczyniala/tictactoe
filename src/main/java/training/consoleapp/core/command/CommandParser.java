package training.consoleapp.core.command;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import training.consoleapp.core.command.CommandFactory.Command;

/**
 * Creates command-line commands by parsing user inputs.
 * 
 * @author proszczyniala
 */
public class CommandParser {

	private Map<Command, String> patterns = new HashMap<Command, String>();
	private Matcher matcher;

	public CommandParser() {
		patterns.put(Command.USERS_MOVE, "(\\d),(\\d)");
		patterns.put(Command.START_GAME, "y|start");
		patterns.put(Command.HELP, "help");
	}

	public Command parse(String command) {
		if (matches(patterns.get(Command.HELP), command)) {
			return Command.HELP;
		} else if (matches(patterns.get(Command.START_GAME), command)) {
			return Command.START_GAME;
		} else if (matches(patterns.get(Command.USERS_MOVE), command)) {
			return Command.USERS_MOVE;
		} else {
			return Command.UNKNOWN_COMMAND;
		}
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