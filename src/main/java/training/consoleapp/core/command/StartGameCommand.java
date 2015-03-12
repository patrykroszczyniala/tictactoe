package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.consoleapp.core.model.ConsoleBoard;
import training.core.GameService;
import training.core.model.Game;

public class StartGameCommand implements ConsoleCommand {

	private GameService gameService;
	private MessageInput messageInput;
	private MessageOutput messageOutput;

	public StartGameCommand(GameService gameService, MessageInput messageInput, MessageOutput messageOutput) {
		this.gameService = gameService;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		gameService.start(new Game(new ConsoleBoard()));
		messageOutput.show("msg_game_started");
		messageOutput.show("msg_next_player_move", gameService.getGame().getActivePlayer().toString(), gameService.getGame().getBoard().toString());
		messageInput.show("msg_enter_directions");
	}

}
