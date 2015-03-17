package training.consoleapp;

import training.consoleapp.core.ConsoleApplication;
import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.ConsoleBoardService;
import training.core.GameService;
import training.core.model.ConsoleBoardState;

public class Main {

	public static void main(String[] args) {
		ConsoleBoardState consoleBoardState = new ConsoleBoardState();
		ConsoleBoardService consoleBoardStateService = new ConsoleBoardService(consoleBoardState);
		GameService gameService = new GameService();
		MessageInput messageInput = new MessageInput(System.out);
		MessageOutput messageOutput = new MessageOutput(System.out);
		CommandFactory commandFactory = new CommandFactory(gameService, consoleBoardStateService, messageInput, messageOutput);
		ConsoleApplication ca = new ConsoleApplication(System.in, commandFactory);
		ca.start();
	}

}
