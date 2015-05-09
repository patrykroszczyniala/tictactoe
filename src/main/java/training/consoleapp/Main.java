/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp;

import training.consoleapp.core.ConsoleApplication;
import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.GameService;
import training.core.gameservice.LocalGameService;
import training.core.model.BoardState;

/**
 * The Class Main.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        BoardState consoleBoardState = new BoardState();
        BoardService consoleBoardStateService =
                new BoardService(consoleBoardState);
        GameService gameService = new LocalGameService();
        MessageInput messageInput = new MessageInput(System.out);
        MessageOutput messageOutput = new MessageOutput(System.out);
        CommandFactory commandFactory =
                new CommandFactory(gameService,
                        consoleBoardStateService,
                        messageInput,
                        messageOutput);
        ConsoleApplication ca =
                new ConsoleApplication(
                        messageOutput,
                        messageInput,
                        System.in,
                        commandFactory);
        ca.start();
    }

}
