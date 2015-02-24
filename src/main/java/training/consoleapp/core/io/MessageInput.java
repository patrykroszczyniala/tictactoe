package training.consoleapp.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageInput extends MessageOutput {

	private String lastMessage = "";
	
	public MessageInput(OutputStream out) {
		super(out);
	}

	@Override
	public void show(String messageKey) throws IOException {
		super.show(messageKey);
		lastMessage = ResourceBundle.getBundle("messages", Locale.ENGLISH).getString(messageKey);
	}

	@Override
	public void show(String messageKey, String... args) throws IOException {
		super.show(messageKey, args);
		lastMessage = ResourceBundle.getBundle("messages", Locale.ENGLISH).getString(messageKey);
	}

	public String getLastMessage() {
		return lastMessage;
	}	
	
}