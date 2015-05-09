/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command.game;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.GameService;

/**
 * The Class HintCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class HintCommand implements ConsoleCommand {

    /**
     * The game service.
     */
    private GameService gameService;

    /**
     * The console board service.
     */
    private BoardService consoleBoardService;

    /**
     * The message output.
     */
    private MessageOutput messageOutput;

    /**
     * The message input.
     */
    private MessageInput messageInput;

    /**
     * Instantiates a new hint command.
     *
     * @param gameService the game service
     * @param consoleBoardStateService the console board state service
     * @param messageInput the message input
     * @param messageOutput the message output
     */
    public HintCommand(GameService gameService,
            BoardService consoleBoardStateService,
            MessageInput messageInput, MessageOutput messageOutput) {
        this.gameService = gameService;
        this.consoleBoardService = consoleBoardStateService;
        this.messageInput = messageInput;
        this.messageOutput = messageOutput;
    }

    public void run() {
        consoleBoardService.hint();
        if (gameService.isStarted()) {
            messageOutput.show("msg_next_player_move", gameService.getGame()
                    .getActivePlayer().toString(),
                    consoleBoardService.asString(gameService.getGame()
                            .getBoard()));
        } else if (consoleBoardService.getState().isHintEnabled()) {
            messageOutput.show("msg_hint_enabled");
        } else {
            messageOutput.show("msg_hint_disabled");
        }
        messageInput.print(messageInput.getLastMessage());
    }

}
