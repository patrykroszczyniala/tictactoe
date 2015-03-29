package training.features.core;

import training.consoleapp.core.command.CommandFactory;
import training.core.BoardService;
import training.core.gameservice.GameService;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class ScenarioState {

	private CommandFactory commandFactory;
	private GameService gameService;
	private BoardService consoleBoardStateService;

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

	public BoardService getConsoleBoardStateService() {
		return consoleBoardStateService;
	}

	public void setConsoleBoardStateService(BoardService consoleBoardStateService) {
		this.consoleBoardStateService = consoleBoardStateService;
	}

}
