package training.consoleapp.core.command;

public enum ApplicationCommand implements Command {
	START_APPLICATION, EXIT_APPLICATION("exit"), START_GAME("y|start"), START_MULTIPLAYER_GAME("start multiplayer"), UNKNOWN_COMMAND;

	private String pattern;

	private ApplicationCommand() {
		this.pattern = "";
	}

	private ApplicationCommand(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

}