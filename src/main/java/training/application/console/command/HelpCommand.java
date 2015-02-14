package training.application.console.command;

import java.io.IOException;

import training.application.ApplicationCommand;
import training.application.console.io.MessageInput;
import training.application.console.io.MessageOutput;
import training.core.model.Game;

public class HelpCommand implements ApplicationCommand {

	public void run(Game game, MessageOutput messageOutput, MessageInput messageInput) throws IOException {
		messageOutput.show("msg_help");
	}

}
