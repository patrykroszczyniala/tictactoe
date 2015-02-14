package training.core;

public class GameRuntimeException extends RuntimeException {

	public enum Warning {
		DIRECTION_NOT_A_NUMER("Wrong directions. Use numbers, eg. 1,2"),
		BOARD_SIZE_EXCEEDED("Uppssss. Board is not that big o_O"), 
		POSITION_ALREADY_USED("This position is already used!");

		private String message;
		
		private Warning(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
		
	}
	
	/** default SVUID */
	private static final long serialVersionUID = 1L;

	public GameRuntimeException(Warning message) {
		super(message.getMessage());
	}
	
}
