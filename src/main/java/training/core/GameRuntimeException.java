/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.core;

/**
 * The Class GameRuntimeException.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class GameRuntimeException extends RuntimeException {

    /**
     * The Enum Warning.
     *
     * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
     * @version $Id$
     */
    public enum Warning {

        /**
         * The direction not a numer.
         */
        DIRECTION_NOT_A_NUMER("Wrong directions. Use numbers, eg. 1,2"),

        /**
         * The board size exceeded.
         */
        BOARD_SIZE_EXCEEDED("Uppssss. Board is not that big o_O"),

        /**
         * The position already used.
         */
        POSITION_ALREADY_USED("This position is already used!");

        /**
         * The message.
         */
        private String message;

        /**
         * Instantiates a new warning.
         *
         * @param message the message
         */
        private Warning(String message) {
            this.message = message;
        }

        /**
         * Gets the message.
         *
         * @return the message
         */
        public String getMessage() {
            return message;
        }

    }

    /**
     * default SVUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new game runtime exception.
     *
     * @param message the message
     */
    public GameRuntimeException(Warning message) {
        super(message.getMessage());
    }

}
