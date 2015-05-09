/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.command.application;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageOutput;

/**
 * The Class ExitApplicationCommand.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class ExitApplicationCommand implements ConsoleCommand {

    /**
     * The message output.
     */
    private MessageOutput messageOutput;

    /**
     * Instantiates a new exit application command.
     *
     * @param messageOutput the message output
     */
    public ExitApplicationCommand(MessageOutput messageOutput) {
        this.messageOutput = messageOutput;
    }

    public void run() {
        messageOutput.show("msg_exit_application");
        System.exit(0);
    }

}
