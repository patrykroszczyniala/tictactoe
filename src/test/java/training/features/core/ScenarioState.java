package training.features.core;

import training.consoleapp.core.command.CommandFactory;
import training.core.ConsoleBoardService;
import training.core.GameService;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class ScenarioState {

	private CommandFactory commandFactory;
	private GameService gameService;
	private ConsoleBoardService consoleBoardStateService;

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

	public ConsoleBoardService getConsoleBoardStateService() {
		return consoleBoardStateService;
	}

	public void setConsoleBoardStateService(ConsoleBoardService consoleBoardStateService) {
		this.consoleBoardStateService = consoleBoardStateService;
	}

}
