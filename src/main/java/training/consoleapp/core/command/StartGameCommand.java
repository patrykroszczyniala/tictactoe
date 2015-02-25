package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.consoleapp.core.model.ConsoleBoard;
import training.core.model.Game;

public class StartGameCommand implements ConsoleCommand {

	private Game game;
	private MessageInput messageInput;
	private MessageOutput messageOutput;

	public StartGameCommand(Game game, MessageInput messageInput, MessageOutput messageOutput) {
		this.game = game;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		game.start(new ConsoleBoard());
		messageOutput.show("msg_game_started", game.getActivePlayer().toString(), game.getBoard().toString(), game.getActivePlayer().toString());
		messageInput.show("msg_enter_directions");
	}

}
