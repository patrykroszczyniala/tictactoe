package training.consoleapp.core.command;


public enum GameCommand implements Command {
	USERS_MOVE("(\\d)"), HELP("help"), HINT("hint");

	private String pattern;
	
	private GameCommand(final String pattern) {
		this.pattern = pattern;
	}
	
	public String getPattern() {
		return pattern;
	}
}