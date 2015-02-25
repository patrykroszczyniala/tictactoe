package training.consoleapp.core.command;

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
