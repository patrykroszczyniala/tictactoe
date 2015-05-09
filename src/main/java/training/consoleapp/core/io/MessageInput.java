/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.io;

import java.io.OutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The Class MessageInput.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class MessageInput extends MessageOutput {

    /**
     * The last message.
     */
    private String lastMessage = "";

    /**
     * Instantiates a new message input.
     *
     * @param out the out
     */
    public MessageInput(OutputStream out) {
        super(out);
    }

    @Override
    public void show(String messageKey) {
        super.show(messageKey);
        lastMessage = ResourceBundle.getBundle("messages", Locale.ENGLISH)
                .getString(messageKey);
    }

    @Override
    public void show(String messageKey, String... args) {
        super.show(messageKey, args);
        lastMessage = ResourceBundle.getBundle("messages", Locale.ENGLISH)
                .getString(messageKey);
    }

    /**
     * Gets the last message.
     *
     * @return the last message
     */
    public String getLastMessage() {
        return lastMessage;
    }

}
