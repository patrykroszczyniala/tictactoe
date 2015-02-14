package training.application.console.command;

import java.io.IOException;

import training.application.ApplicationCommand;
import training.application.console.io.MessageInput;
import training.application.console.io.MessageOutput;
import training.core.model.Game;

public class StartGameCommand implements ApplicationCommand {

	public void run(final Game game, final MessageOutput messageOutput, final MessageInput messageInput) throws IOException {
		game.start();
		messageOutput.show("msg_game_started", game.getActivePlayer().toString(), game.getBoard().toString(), game.getActivePlayer().toString());
		messageInput.show("msg_enter_directions");
	}

}
