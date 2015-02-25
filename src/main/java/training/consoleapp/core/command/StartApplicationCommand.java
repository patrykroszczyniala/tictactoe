package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;

public class StartApplicationCommand implements ConsoleCommand {

	private MessageOutput messageOutput;
	private MessageInput messageInput;

	public StartApplicationCommand(MessageOutput messageOutput, MessageInput messageInput) {
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}
	
	public void run() {
		messageOutput.show("msg_welcome");
		messageInput.show("msg_start_game");
	}

}