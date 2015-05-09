/**
 * Copyright (c) 2015, Patryk Roszczyniała
 */
package training.consoleapp.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The Class MessageOutput.
 *
 * @author Patryk Roszczyniala (p.roszczyniala@gmail.com)
 * @version $Id$
 */
public class MessageOutput {

    /**
     * The sb.
     */
    protected StringBuilder sb = new StringBuilder();

    /**
     * The out.
     */
    private OutputStream out;

    /**
     * Instantiates a new message output.
     *
     * @param out the out
     */
    public MessageOutput(final OutputStream out) {
        this.out = out;
    }

    /**
     * Show.
     *
     * @param messageKey the message key
     */
    public void show(String messageKey) {
        String msg = ResourceBundle.getBundle("messages", Locale.ENGLISH)
                .getString(messageKey);
        write(msg);
    }

    /**
     * Show.
     *
     * @param messageKey the message key
     * @param args the args
     */
    public void show(String messageKey, String... args) {
        String msgFormat = ResourceBundle.getBundle("messages", Locale.ENGLISH)
                .getString(messageKey);
        MessageFormat mf = new MessageFormat(msgFormat);
        mf.applyPattern(msgFormat);
        String msg = mf.format(args);
        write(msg);
    }

    /**
     * Show.
     */
    public void show() {
        write(sb.toString());
    }

    /**
     * Println.
     *
     * @param msg the msg
     */
    public void println(String msg) {
        sb.setLength(0);
        sb.append(msg).append("\r\n");
        show();
    }

    /**
     * Prints the.
     *
     * @param msg the msg
     */
    public void print(String msg) {
        sb.setLength(0);
        sb.append(msg);
        show();
    }

    /**
     * Write.
     *
     * @param msg the msg
     */
    protected void write(String msg) {
        try {
            out.write(msg.getBytes());
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

}
