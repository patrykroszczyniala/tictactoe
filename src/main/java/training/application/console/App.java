package training.application.console;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		ConsoleGameApplication ca = new ConsoleGameApplication(System.in, System.out);
		ca.start();
	}

}
