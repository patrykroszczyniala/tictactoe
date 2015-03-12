package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.GameRuntimeException;
import training.core.GameService;

import com.google.common.base.Preconditions;

public class UsersMoveCommand implements ConsoleCommand {

	private GameService gameService;
	private MessageInput messageInput;
	private MessageOutput messageOutput;
	private Integer x;
	private Integer y;

	public UsersMoveCommand(GameService gameService, MessageInput messageInput, MessageOutput messageOutput) {
		this.gameService = gameService;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		Preconditions.checkNotNull(x);
		Preconditions.checkNotNull(y);
		try {
			gameService.mark(x, y);
			if (gameService.isCompleted()) {
				if (gameService.getWinner()!=null) {
					messageOutput.show("msg_game_completed_winner", gameService.getWinner().toString());
				} else {
					messageOutput.show("msg_game_completed_full");
				}
			}
			else {
				messageOutput.show("msg_next_player_move", gameService.getGame().getActivePlayer()
						.toString(),  gameService.getGame().getBoard().toString());
				messageInput.show("msg_enter_directions");
			}
		} catch (GameRuntimeException e) {
			messageOutput.println(e.getMessage());
			messageInput.print(messageInput.getLastMessage());
		}
	}

	public UsersMoveCommand setDirections(Integer x, Integer y) {
		this.x = x;
		this.y = y;

		return this;
	}

}
