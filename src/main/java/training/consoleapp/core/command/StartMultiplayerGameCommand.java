package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.GameService;
import training.core.model.Board;
import training.core.model.Game;

public class StartMultiplayerGameCommand implements ConsoleCommand {

	private GameService gameService;
	private BoardService consoleBoardService;
	private MessageInput messageInput;
	private MessageOutput messageOutput;

	public StartMultiplayerGameCommand(GameService gameService, BoardService consoleBoardService,
			MessageInput messageInput, MessageOutput messageOutput) {
		this.gameService = gameService;
		this.consoleBoardService = consoleBoardService;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		if (!gameService.isStarted()) {
			gameService.start(new Game(new Board()));
			messageOutput.show("msg_multiplayer_game_started_wating");
		} else {
			messageOutput.show("msg_multiplayer_game_started_started");
			messageOutput.show("msg_next_player_move", gameService.getGame().getActivePlayer().toString(),
					consoleBoardService.asString(gameService.getGame().getBoard()));
			messageInput.show("msg_enter_directions");
		}
	}

}
