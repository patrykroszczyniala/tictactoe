package training.consoleapp.core.command;

import java.util.HashMap;
import java.util.Map;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.model.Game;

/**
 * Creates command-line commands.
 * 
 * @author proszczyniala
 */
public final class CommandFactory {

	public enum Command {
		USERS_MOVE, START_GAME, HELP, UNKNOWN_COMMAND, START_APPLICATION, EXIT_APPLICATION;
	}

	private Map<Command, ConsoleCommand> commands = new HashMap<CommandFactory.Command, ConsoleCommand>();

	public CommandFactory(final Game game, final MessageInput messageInput, final MessageOutput messageOutput) {
		commands.put(Command.START_GAME, new StartGameCommand(game, messageInput, messageOutput));
		commands.put(Command.HELP, new HelpCommand(messageOutput));
		commands.put(Command.USERS_MOVE, new UsersMoveCommand(game, messageInput, messageOutput));
		commands.put(Command.UNKNOWN_COMMAND, new UnknownCommand(messageOutput, messageInput));
		commands.put(Command.START_APPLICATION, new StartApplicationCommand(messageOutput, messageInput));
		commands.put(Command.EXIT_APPLICATION, new ExitApplicationCommand(messageOutput));
	}

	public ConsoleCommand create(Command command) {
		return commands.get(command);
	}

	public ConsoleCommand create(String command) {
		CommandParser parser = new CommandParser();
		Command cmd = parser.parse(command);
		if (cmd.equals(Command.USERS_MOVE)) {
			UsersMoveCommand userDirectionsCommand = (UsersMoveCommand) create(cmd);
			Integer x = Integer.parseInt(parser.group(1));
			Integer y = Integer.parseInt(parser.group(2));
			return userDirectionsCommand.setDirections(x, y);
		}
		return create(cmd);
	}

}
