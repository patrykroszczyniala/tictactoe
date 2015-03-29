package training.consoleapp.core.command.application;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageOutput;

public class ExitApplicationCommand implements ConsoleCommand {

	private MessageOutput messageOutput;
	
	public ExitApplicationCommand(MessageOutput messageOutput) {
		this.messageOutput = messageOutput;
	}

	public void run() {
		messageOutput.show("msg_exit_application");
		System.exit(0);
	}

}
