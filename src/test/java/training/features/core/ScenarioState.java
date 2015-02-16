package training.features.core;

import training.core.model.Game;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class ScenarioState {

	private Game game;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
