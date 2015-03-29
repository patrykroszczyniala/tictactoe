package training.consoleapp.core.command.application;

import training.consoleapp.core.command.ConsoleCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.GameService;
import training.core.model.Board;
import training.core.model.Game;

public class StartGameCommand implements ConsoleCommand {

	private GameService gameService;
	private BoardService consoleBoardService;
	private MessageInput messageInput;
	private MessageOutput messageOutput;

	public StartGameCommand(GameService gameService, BoardService consoleBoardService,
			MessageInput messageInput, MessageOutput messageOutput) {
		this.gameService = gameService;
		this.consoleBoardService = consoleBoardService;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		gameService.start(new Game(new Board()));
		messageOutput.show("msg_game_started");
		messageOutput.show("msg_next_player_move", gameService.getGame().getActivePlayer().toString(),
				consoleBoardService.asString(gameService.getGame().getBoard()));
		messageInput.show("msg_enter_directions");
	}

}
