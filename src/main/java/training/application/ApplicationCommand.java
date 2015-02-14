package training.application;

import java.io.IOException;

import training.application.console.io.MessageInput;
import training.application.console.io.MessageOutput;
import training.core.model.Game;

public interface ApplicationCommand {

	void run(Game game, MessageOutput messageOutput, MessageInput messageInput) throws IOException;

}