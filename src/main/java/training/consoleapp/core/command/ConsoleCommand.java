package training.consoleapp.core.command;

import java.io.IOException;

/**
 * Interface for console command-line commands.
 * 
 * @author proszczyniala
 */
public interface ConsoleCommand {

	/**
	 * Executes command-line command.
	 * @throws IOException
	 */
	void run();
	
}
