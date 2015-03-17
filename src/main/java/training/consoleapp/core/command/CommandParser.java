package training.consoleapp.core.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
		patterns.put(Command.USERS_MOVE, "(\\d)");
		patterns.put(Command.START_GAME, "y|start");
		patterns.put(Command.HELP, "help");
		patterns.put(Command.EXIT_APPLICATION, "exit");
		patterns.put(Command.HINT, "hint");
	}

	public Command parse(String command) {
		for (Entry<Command, String> patternDefinition : patterns.entrySet()) {
			if (matches(patternDefinition.getValue(), command)) {
				return patternDefinition.getKey();
			}
		}
		return Command.UNKNOWN_COMMAND;
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