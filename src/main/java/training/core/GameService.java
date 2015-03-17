package training.core;

import training.core.model.Game;
import training.core.model.Player;

public class GameService {

	private Game game;

	public void mark(int index) throws GameRuntimeException {
		game.getBoard().mark(index, game.getActivePlayer().getSymbol());
		game.getScoreCalculator().calculate(game.getActivePlayer(), index);
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
	
	public boolean isStarted() {
		return game!=null;
	}
	
}
