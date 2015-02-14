package training.application.console.io;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageOutput {

	protected OutputStream out;
	protected StringBuilder sb = new StringBuilder();

	public MessageOutput(OutputStream out) {
		this.out = out;
	}

	public void show(String messageKey) throws IOException {
		String msg = ResourceBundle.getBundle("messages", Locale.ENGLISH).getString(messageKey);
		out.write(msg.getBytes());
	}

	public void show(String messageKey, String... args) throws IOException {
		String msgFormat = ResourceBundle.getBundle("messages", Locale.ENGLISH).getString(messageKey);
		MessageFormat mf = new MessageFormat(msgFormat);
		mf.applyPattern(msgFormat);
		String msg = mf.format(args);
		out.write(msg.getBytes());
	}

	public void show() throws IOException {
		out.write(sb.toString().getBytes());
	}

	public void println(String msg) throws IOException {
		sb.setLength(0);
		sb.append(msg).append("\r\n");
		show();
	}
	
	public void print(String msg) throws IOException {
		sb.setLength(0);
		sb.append(msg);
		show();
	}

}