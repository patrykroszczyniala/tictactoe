package training.consoleapp.core.command;

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
