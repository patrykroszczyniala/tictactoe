/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command.application;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;

/**
 * The Class UnknownCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class UnknownCommand implements ConsoleCommand {

    /**
     * The message input.
     */
    private MessageInput messageInput;

    /**
     * The message output.
     */
    private MessageOutput messageOutput;

    /**
     * Instantiates a new unknown command.
     *
     * @param messageOutput the message output
     * @param messageInput the message input
     */
    public UnknownCommand(MessageOutput messageOutput, MessageInput messageInput) {
        this.messageInput = messageInput;
        this.messageOutput = messageOutput;
    }

    public void run() {
        messageOutput.show("wrn_unknown_command");
        messageInput.print(messageInput.getLastMessage());
    }

}
