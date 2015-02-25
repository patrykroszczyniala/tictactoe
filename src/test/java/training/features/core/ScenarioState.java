package training.features.core;

import training.consoleapp.core.command.CommandFactory;
import training.core.model.Game;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class ScenarioState {

	private CommandFactory commandFactory;
	private Game game;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

}
