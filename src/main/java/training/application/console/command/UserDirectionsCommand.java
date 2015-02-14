package training.application.console.command;

import java.io.IOException;

import training.application.ApplicationCommand;
import training.application.console.io.MessageInput;
import training.application.console.io.MessageOutput;
import training.core.GameRuntimeException;
import training.core.model.Game;

import com.google.common.base.Preconditions;

public class UserDirectionsCommand implements ApplicationCommand {

	private Integer x;
	private Integer y;

	public void run(final Game game, final MessageOutput messageOutput, final MessageInput messageInput)
			throws IOException {
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
		}
	}

	public UserDirectionsCommand setDirections(Integer x, Integer y) {
		this.x = x;
		this.y = y;

		return this;
	}

}
