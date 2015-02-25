package training.consoleapp.core.command;

import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.GameRuntimeException;
import training.core.model.Game;

import com.google.common.base.Preconditions;

public class UsersMoveCommand implements ConsoleCommand {

	private Game game;
	private MessageInput messageInput;
	private MessageOutput messageOutput;
	private Integer x;
	private Integer y;

	public UsersMoveCommand(Game game, MessageInput messageInput, MessageOutput messageOutput) {
		this.game = game;
		this.messageInput = messageInput;
		this.messageOutput = messageOutput;
	}

	public void run() {
		Preconditions.checkNotNull(x);
		Preconditions.checkNotNull(y);
		try {
			game.move(x, y);
			if (game.isWinner()) {
				messageOutput.show("msg_game_completed_winner", game.getWinner().toString());
			} else if (game.isFull()) {
				messageOutput.show("msg_game_completed_full");
			} else {
				messageOutput.show("msg_next_player_move", game.getBoard().toString(), game.getActivePlayer()
						.toString());
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
