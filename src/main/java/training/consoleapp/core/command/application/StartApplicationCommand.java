/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command.application;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;

/**
 * The Class StartApplicationCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class StartApplicationCommand implements ConsoleCommand {

    /**
     * The message output.
     */
    private final MessageOutput messageOutput;

    /**
     * The message input.
     */
    private final MessageInput messageInput;

    /**
     * Instantiates a new start application command.
     *
     * @param messageOutput the message output
     * @param messageInput the message input
     */
    public StartApplicationCommand(MessageOutput messageOutput,
            MessageInput messageInput) {
        this.messageOutput = messageOutput;
        this.messageInput = messageInput;
    }

    public void run() {
        this.messageOutput.show("msg_welcome");
        this.messageInput.show("msg_start_game");
    }

}
