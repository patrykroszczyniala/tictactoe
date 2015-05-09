/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command.game;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageOutput;

/**
 * The Class HelpCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class HelpCommand implements ConsoleCommand {

    /**
     * The message output.
     */
    private MessageOutput messageOutput;

    /**
     * Instantiates a new help command.
     *
     * @param messageOutput the message output
     */
    public HelpCommand(MessageOutput messageOutput) {
        this.messageOutput = messageOutput;
    }

    public void run() {
        messageOutput.show("msg_help");
    }

}
