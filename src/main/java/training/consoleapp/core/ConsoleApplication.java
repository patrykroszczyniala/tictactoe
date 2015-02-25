package training.consoleapp.core;

import java.io.InputStream;
import java.util.Scanner;

import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.command.CommandFactory.Command;

/**
 * Entry point for console version of tic-tac-toe game.
 * 
 * @author USER-HP
 */
public class ConsoleApplication {

	private InputStream in;
	private CommandFactory commandFactory;
	
	public ConsoleApplication(final InputStream in, CommandFactory commandFactory) {
		this.in = in;
		this.commandFactory = commandFactory;
	}

	public void start() {
		commandFactory.create(Command.START_APPLICATION).run();
		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()) {
			String command = scanner.next().trim();
			commandFactory.create(command).run();
		}
		scanner.close();
	}

}
