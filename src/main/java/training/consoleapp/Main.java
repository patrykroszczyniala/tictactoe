package training.consoleapp;

import training.consoleapp.core.ConsoleApplication;
import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.GameService;

public class Main {

	public static void main(String[] args) {
		GameService gameService = new GameService();
		MessageInput messageInput = new MessageInput(System.out);
		MessageOutput messageOutput = new MessageOutput(System.out);
		CommandFactory commandFactory = new CommandFactory(gameService, messageInput, messageOutput);
		ConsoleApplication ca = new ConsoleApplication(System.in, commandFactory);
		ca.start();
	}

}
