package training.core;

import training.core.model.Game;
import training.core.model.Player;

public class GameService {

	private Game game;

	public void mark(int x, int y) throws GameRuntimeException {
		game.getBoard().setPosition(x, y, game.getActivePlayer().getSymbol());
		game.getScoreCalculator().calculate(game.getActivePlayer(), x, y);
		if (game.getScoreCalculator().isWinner(game.getActivePlayer())) {
			return;
		}
		game.setActivePlayer(game.getActivePlayer() == Player.O ? Player.X : Player.O);
	}

	public Player getWinner() {
		if (game.getScoreCalculator().isWinner(game.getActivePlayer())) {
			return game.getActivePlayer();
		}
		return null;
	}
	
	public boolean isCompleted() {
		return game.getBoard().isFull() || game.getScoreCalculator().isWinner(game.getActivePlayer());
	}

	public Game getGame() {
		return game;
	}

	public void start(Game game) {
		this.game = game;
	}
	
}
