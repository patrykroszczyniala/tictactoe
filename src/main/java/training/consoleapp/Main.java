package training.consoleapp;

import training.consoleapp.core.ConsoleApplication;
import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.GameService;
import training.core.gameservice.LocalGameService;
import training.core.model.BoardState;

public class Main {

	public static void main(String[] args) {
		BoardState consoleBoardState = new BoardState();
		BoardService consoleBoardStateService = new BoardService(consoleBoardState);
		GameService gameService = new LocalGameService();
		MessageInput messageInput = new MessageInput(System.out);
		MessageOutput messageOutput = new MessageOutput(System.out);
		CommandFactory commandFactory = new CommandFactory(gameService, consoleBoardStateService, messageInput, messageOutput);
		ConsoleApplication ca = new ConsoleApplication(messageOutput, messageInput, System.in, commandFactory);
		ca.start();
	}

}
