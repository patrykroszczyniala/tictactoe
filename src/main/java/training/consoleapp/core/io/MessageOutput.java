package training.consoleapp.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageOutput {

	protected StringBuilder sb = new StringBuilder();
	private OutputStream out;
	
	public MessageOutput(final OutputStream out) {
		this.out = out;
	}

	public void show(String messageKey) {
		String msg = ResourceBundle.getBundle("messages", Locale.ENGLISH).getString(messageKey);
		write(msg);
	}

	public void show(String messageKey, String... args) {
		String msgFormat = ResourceBundle.getBundle("messages", Locale.ENGLISH).getString(messageKey);
		MessageFormat mf = new MessageFormat(msgFormat);
		mf.applyPattern(msgFormat);
		String msg = mf.format(args);
		write(msg);
	}

	public void show() {
		write(sb.toString());
	}

	public void println(String msg) {
		sb.setLength(0);
		sb.append(msg).append("\r\n");
		show();
	}
	
	public void print(String msg) {
		sb.setLength(0);
		sb.append(msg);
		show();
	}
	
	protected void write(String msg) {
		try {
			out.write(msg.getBytes());
		} catch (IOException e) {
			throw new IllegalStateException(e.getMessage());
		}
	}

}