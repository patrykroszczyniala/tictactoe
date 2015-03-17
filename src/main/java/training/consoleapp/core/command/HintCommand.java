package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.ConsoleBoardService;
import training.core.GameService;

public class HintCommand implements ConsoleCommand {

	private GameService gameService;
	private ConsoleBoardService consoleBoardService;
	private MessageOutput messageOutput;
	private MessageInput messageInput;

	public HintCommand(GameService gameService, ConsoleBoardService consoleBoardStateService,
			MessageInput messageInput, MessageOutput messageOutput) {
		this.gameService = gameService;
		this.consoleBoardService = consoleBoardStateService;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		consoleBoardService.hint();
		if (gameService.isStarted()) {
			messageOutput.show("msg_next_player_move", gameService.getGame().getActivePlayer().toString(),
					consoleBoardService.asString(gameService.getGame().getBoard()));
		} else if (consoleBoardService.getState().isHintEnabled()) {
			messageOutput.show("msg_hint_enabled");
		} else {
			messageOutput.show("msg_hint_disabled");
		}
		messageInput.print(messageInput.getLastMessage());
	}

}
