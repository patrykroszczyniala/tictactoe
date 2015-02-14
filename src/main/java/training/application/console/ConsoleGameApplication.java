package training.application.console;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import training.application.GameApplication;
import training.application.console.command.ApplicationCommandFactory;
import training.application.console.io.MessageInput;
import training.application.console.io.MessageOutput;
import training.core.model.Game;

public class ConsoleGameApplication implements GameApplication {

	private OutputStream out;
	private InputStream in;
	private Game game;

	public ConsoleGameApplication(final InputStream in, final OutputStream out) {
		this.out = out;
		this.in = in;
		game = new Game();
	}

	public void start() throws IOException {
		MessageOutput messageOutput = new MessageOutput(out);
		MessageInput messageInput = new MessageInput(out);
		messageOutput.show("msg_welcome");
		messageInput.show("msg_start_game");
		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()) {
			String command = scanner.next().trim();
			if (command.isEmpty()) {
				continue;
			}
			ApplicationCommandFactory.run(command, game, messageOutput, messageInput);
		}
		scanner.close();
	}

	public Game getGame() {
		return game;
	}

	// TODO only for tests
	public void setIn(InputStream in) {
		this.in = in;
	}

}
