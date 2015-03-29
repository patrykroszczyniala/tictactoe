package training.consoleapp.core;

import java.io.InputStream;
import java.util.Scanner;

import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.command.application.StartApplicationCommand;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;

/**
 * Entry point for console version of tic-tac-toe game.
 * 
 * @author USER-HP
 */
public class ConsoleApplication {

	private InputStream in;
	private CommandFactory commandFactory;
	private MessageOutput messageOutput;
	private MessageInput messageInput;

	public ConsoleApplication(final MessageOutput messageOutput, final MessageInput messageInput, final InputStream in,
			CommandFactory commandFactory) {
		this.in = in;
		this.commandFactory = commandFactory;
	}

	public void start() {
		new StartApplicationCommand(messageOutput, messageInput).run();
		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()) {
			String command = scanner.next().trim();
			commandFactory.create(command).run();
		}
		scanner.close();
	}

}
