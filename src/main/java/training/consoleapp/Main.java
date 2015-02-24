package training.consoleapp;

import java.io.IOException;

import training.consoleapp.core.ConsoleApplication;
import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.model.Game;

public class Main {

	public static void main(String[] args) throws IOException {
		Game game = new Game();
		MessageInput messageInput = new MessageInput(System.out);
		MessageOutput messageOutput = new MessageOutput(System.out);
		CommandFactory commandFactory = new CommandFactory(game, messageInput, messageOutput);
		ConsoleApplication ca = new ConsoleApplication(System.in, commandFactory);
		ca.start();
	}

}
