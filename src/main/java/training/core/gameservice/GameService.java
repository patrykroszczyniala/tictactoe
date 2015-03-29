package training.core.gameservice;

import training.core.GameRuntimeException;
import training.core.model.Game;
import training.core.model.Player;

public interface GameService {

	void mark(int index) throws GameRuntimeException;

	Player getWinner();

	boolean isCompleted();

	Game getGame();

	void start(Game game);

	boolean isStarted();

}