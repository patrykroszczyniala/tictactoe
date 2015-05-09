/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command;

import java.util.HashMap;
import java.util.Map;
import training.consoleapp.core.command.application.ExitApplicationCommand;
import training.consoleapp.core.command.application.StartApplicationCommand;
import training.consoleapp.core.command.application.StartGameCommand;
import training.consoleapp.core.command.application.StartMultiplayerGameCommand;
import training.consoleapp.core.command.application.UnknownCommand;
import training.consoleapp.core.command.game.HelpCommand;
import training.consoleapp.core.command.game.HintCommand;
import training.consoleapp.core.command.game.UsersMoveCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.GameService;

/**
 * A factory for creating Command objects.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public final class CommandFactory {

    /**
     * The commands.
     */
    private Map<Command, ConsoleCommand> commands = new HashMap<Command, ConsoleCommand>();

    /**
     * Instantiates a new command factory.
     *
     * @param gameService the game service
     * @param consoleBoardService the console board service
     * @param messageInput the message input
     * @param messageOutput the message output
     */
    public CommandFactory(final GameService gameService,
            final BoardService consoleBoardService,
            final MessageInput messageInput, final MessageOutput messageOutput) {
        commands.put(ApplicationCommand.START_GAME, new StartGameCommand(
                gameService, consoleBoardService, messageInput, messageOutput));
        commands.put(ApplicationCommand.START_MULTIPLAYER_GAME,
                new StartMultiplayerGameCommand(gameService,
                        consoleBoardService, messageInput, messageOutput));
        commands.put(ApplicationCommand.UNKNOWN_COMMAND, new UnknownCommand(
                messageOutput, messageInput));
        commands.put(ApplicationCommand.START_APPLICATION,
                new StartApplicationCommand(messageOutput, messageInput));
        commands.put(ApplicationCommand.EXIT_APPLICATION,
                new ExitApplicationCommand(messageOutput));
        commands.put(GameCommand.HELP, new HelpCommand(messageOutput));
        commands.put(GameCommand.USERS_MOVE, new UsersMoveCommand(gameService,
                consoleBoardService, messageInput, messageOutput));
        commands.put(GameCommand.HINT, new HintCommand(gameService,
                consoleBoardService, messageInput, messageOutput));
    }

    /**
     * Creates the.
     *
     * @param command the command
     * @return the console command
     */
    public ConsoleCommand create(Command command) {
        return commands.get(command);
    }

    /**
     * Creates the.
     *
     * @param command the command
     * @return the console command
     */
    public ConsoleCommand create(String command) {
        CommandParser parser = new CommandParser();
        Command cmd = parser.parse(command);
        if (cmd.equals(GameCommand.USERS_MOVE)) {
            UsersMoveCommand userDirectionsCommand = (UsersMoveCommand) create(cmd);
            Integer index = Integer.parseInt(parser.group(0));
            return userDirectionsCommand.setIndex(index);
        }
        return create(cmd);
    }

}
