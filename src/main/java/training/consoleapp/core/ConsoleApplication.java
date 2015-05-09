/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core;

import java.io.InputStream;
import java.util.Scanner;
import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.command.application.StartApplicationCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;

/**
 * The Class ConsoleApplication.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class ConsoleApplication {

    /**
     * The in.
     */
    private InputStream in;

    /**
     * The command factory.
     */
    private CommandFactory commandFactory;

    /**
     * The message output.
     */
    private final MessageOutput messageOutput;

    /**
     * The message input.
     */
    private final MessageInput messageInput;

    /**
     * Instantiates a new console application.
     *
     * @param messageOutput the message output
     * @param messageInput the message input
     * @param in the in
     * @param commandFactory the command factory
     */
    public ConsoleApplication(
            final MessageOutput messageOutput,
            final MessageInput messageInput,
            final InputStream in,
            CommandFactory commandFactory) {
        this.in = in;
        this.commandFactory = commandFactory;
        this.messageInput = messageInput;
        this.messageOutput = messageOutput;
    }

    /**
     * Start.
     */
    public void start() {
        new StartApplicationCommand(messageOutput, messageInput).run();
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            String command = scanner.next().trim();
            commandFactory.create(command).run();
        }
        scanner.close();
    }

}
