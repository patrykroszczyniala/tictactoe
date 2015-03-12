package training.features.core;

import training.consoleapp.core.command.CommandFactory;
import training.core.GameService;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class ScenarioState {

	private CommandFactory commandFactory;
	private GameService gameService;

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

}
