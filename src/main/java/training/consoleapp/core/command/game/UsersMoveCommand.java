/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command.game;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.GameRuntimeException;
import training.core.gameservice.GameService;
import com.google.common.base.Preconditions;

/**
 * The Class UsersMoveCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class UsersMoveCommand implements ConsoleCommand {

    /**
     * The game service.
     */
    private GameService gameService;

    /**
     * The console board service.
     */
    private BoardService consoleBoardService;

    /**
     * The message input.
     */
    private MessageInput messageInput;

    /**
     * The message output.
     */
    private MessageOutput messageOutput;

    /**
     * The index.
     */
    private Integer index;

    /**
     * Instantiates a new users move command.
     *
     * @param gameService the game service
     * @param consoleBoardService the console board service
     * @param messageInput the message input
     * @param messageOutput the message output
     */
    public UsersMoveCommand(GameService gameService,
            BoardService consoleBoardService, MessageInput messageInput,
            MessageOutput messageOutput) {
        this.gameService = gameService;
        this.consoleBoardService = consoleBoardService;
        this.messageInput = messageInput;
        this.messageOutput = messageOutput;
    }

    public void run() {
        Preconditions.checkNotNull(index);
        try {
            gameService.mark(index);
            if (gameService.isCompleted()) {
                if (gameService.getWinner() != null) {
                    messageOutput.show("msg_game_completed_winner", gameService
                            .getWinner().toString());
                } else {
                    messageOutput.show("msg_game_completed_full");
                }
            } else {
                messageOutput.show("msg_next_player_move", gameService
                        .getGame().getActivePlayer().toString(),
                        consoleBoardService.asString(gameService.getGame()
                                .getBoard()));
                messageInput.show("msg_enter_directions");
            }
        } catch (GameRuntimeException e) {
            messageOutput.println(e.getMessage());
            messageInput.print(messageInput.getLastMessage());
        }
    }

    /**
     * Sets the index.
     *
     * @param index the index
     * @return the users move command
     */
    public UsersMoveCommand setIndex(Integer index) {
        this.index = index;
        return this;
    }

}
