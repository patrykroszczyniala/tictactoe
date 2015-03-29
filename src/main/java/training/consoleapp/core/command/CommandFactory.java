package training.consoleapp.core.command;

import java.util.HashMap;
import java.util.Map;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.GameService;

/**
 * Creates command-line commands.
 * 
 * @author proszczyniala
 */
public final class CommandFactory {

	public enum Command {
		USERS_MOVE, START_GAME, HELP, UNKNOWN_COMMAND, START_APPLICATION, EXIT_APPLICATION, HINT, START_MULTIPLAYER_GAME;
	}

	private Map<Command, ConsoleCommand> commands = new HashMap<CommandFactory.Command, ConsoleCommand>();

	public CommandFactory(final GameService gameService, final BoardService consoleBoardService,
			final MessageInput messageInput, final MessageOutput messageOutput) {
		commands.put(Command.START_GAME, new StartGameCommand(gameService, consoleBoardService, messageInput, messageOutput));
		commands.put(Command.START_MULTIPLAYER_GAME, new StartMultiplayerGameCommand(gameService, consoleBoardService, messageInput, messageOutput));
		commands.put(Command.HELP, new HelpCommand(messageOutput));
		commands.put(Command.USERS_MOVE, new UsersMoveCommand(gameService, consoleBoardService, messageInput, messageOutput));
		commands.put(Command.UNKNOWN_COMMAND, new UnknownCommand(messageOutput, messageInput));
		commands.put(Command.START_APPLICATION, new StartApplicationCommand(messageOutput, messageInput));
		commands.put(Command.EXIT_APPLICATION, new ExitApplicationCommand(messageOutput));
		commands.put(Command.HINT, new HintCommand(gameService, consoleBoardService, messageInput, messageOutput));
	}

	public ConsoleCommand create(Command command) {
		return commands.get(command);
	}

	public ConsoleCommand create(String command) {
		CommandParser parser = new CommandParser();
		Command cmd = parser.parse(command);
		if (cmd.equals(Command.USERS_MOVE)) {
			UsersMoveCommand userDirectionsCommand = (UsersMoveCommand) create(cmd);
			Integer index = Integer.parseInt(parser.group(0));
			return userDirectionsCommand.setIndex(index);
		}
		return create(cmd);
	}

}
