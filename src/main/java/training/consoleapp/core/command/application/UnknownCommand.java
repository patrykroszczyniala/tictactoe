package training.consoleapp.core.command.application;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;

public class UnknownCommand implements ConsoleCommand {

	private MessageInput messageInput;
	private MessageOutput messageOutput;

	public UnknownCommand(MessageOutput messageOutput, MessageInput messageInput) {
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		messageOutput.show("wrn_unknown_command");
		messageInput.print(messageInput.getLastMessage());
	}

}
