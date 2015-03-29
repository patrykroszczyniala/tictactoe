package training.consoleapp.core.command.application;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;

public class StartApplicationCommand implements ConsoleCommand {

	private MessageOutput messageOutput;
	private MessageInput messageInput;
	
	public StartApplicationCommand(MessageOutput messageOutput, MessageInput messageInput) {
		this.messageOutput = messageOutput;
		this.messageInput = messageInput;
	}

	public void run() {
		messageOutput.show("msg_welcome");
		messageInput.show("msg_start_game");
	}

}
