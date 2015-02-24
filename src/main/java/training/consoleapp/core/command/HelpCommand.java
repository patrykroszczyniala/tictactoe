package training.consoleapp.core.command;

import java.io.IOException;

import training.consoleapp.core.io.MessageOutput;

public class HelpCommand implements ConsoleCommand {

	private MessageOutput messageOutput;
	
	public HelpCommand(MessageOutput messageOutput) {
		this.messageOutput = messageOutput;
	}

	public void run() throws IOException {
		messageOutput.show("msg_help");
	}

}
