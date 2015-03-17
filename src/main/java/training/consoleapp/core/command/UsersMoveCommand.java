package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.ConsoleBoardService;
import training.core.GameRuntimeException;
import training.core.GameService;

import com.google.common.base.Preconditions;

public class UsersMoveCommand implements ConsoleCommand {

	private GameService gameService;
	private ConsoleBoardService consoleBoardService;
	private MessageInput messageInput;
	private MessageOutput messageOutput;
	private Integer index;

	public UsersMoveCommand(GameService gameService, ConsoleBoardService consoleBoardService, MessageInput messageInput, MessageOutput messageOutput) {
		this.gameService = gameService;
		this.consoleBoardService = consoleBoardService;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		Preconditions.checkNotNull(index);
		try {
			gameService.mark(index);
			if (gameService.isCompleted()) {
				if (gameService.getWinner() != null) {
					messageOutput.show("msg_game_completed_winner", gameService.getWinner().toString());
				} else {
					messageOutput.show("msg_game_completed_full");
				}
			} else {
				messageOutput.show("msg_next_player_move", gameService.getGame().getActivePlayer().toString(),
						consoleBoardService.asString(gameService.getGame().getBoard()));
				messageInput.show("msg_enter_directions");
			}
		} catch (GameRuntimeException e) {
			messageOutput.println(e.getMessage());
			messageInput.print(messageInput.getLastMessage());
		}
	}

	public UsersMoveCommand setIndex(Integer index) {
		this.index = index;
		return this;
	}

}
