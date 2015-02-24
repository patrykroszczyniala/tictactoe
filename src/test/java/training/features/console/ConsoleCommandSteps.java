package training.features.console;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.Assert;

import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.command.CommandFactory.Command;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.consoleapp.core.model.ConsoleBoard;
import training.core.model.Board;
import training.core.model.Game;
import training.features.core.BoardStateSteps;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Unit test for simple App.
 */
@ScenarioScoped
public class ConsoleCommandSteps {

	private Game game;
	private CommandFactory commandFactory;
	private OutputStream outputStream;
	private MessageInput messageInput;
	private MessageOutput messageOutput;

	@Before
	public void before() {
		outputStream = new ByteArrayOutputStream();
		messageInput = new MessageInput(outputStream);
		messageOutput = new MessageOutput(outputStream);
		game = new Game();
	}

	@Given("^command line interface$")
	public void console_game() throws Throwable {
		commandFactory = new CommandFactory(game, messageInput, messageOutput);
	}
	
	@Given("^application started$")
	public void application_started() throws Throwable {
		commandFactory.create(Command.START_APPLICATION).run();
	}

	@When("^user entered command (.*)$")
	public void user_enter_command(String command) throws Throwable {
		commandFactory.create(command).run();
	}
	
//	@When("^console application has started$")
//	public void application_is_started() throws Throwable {
//		commandFactory.create(Command.START_APPLICATION).run();
////		new StartConsoleApplicationCommand(messageOutput, messageInput).run();
//	}

	@Then("^welcome text should be shown$")
	public void welcome_text_should_be_shown(String welcomeText) throws Throwable {
		Assert.assertEquals(welcomeText, outputStream.toString());
	}

	@Then("^game should be started$")
	public void game_should_be_started(String expectedStartText) throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith(expectedStartText));
	}

	@Then("^empty board should be shown$")
	public void empty_board_should_be_shown(List<List<String>> expectedBoardDefinition) throws Throwable {
		Board expectedBoard = new ConsoleBoard(BoardStateSteps.convertToArray(expectedBoardDefinition));
		Assert.assertEquals(expectedBoard, game.getBoard());
	}

	@Given("^game started$")
	public void started_game() throws Throwable {
		commandFactory.create("start").run();
	}

	@When("^user enter directions to \"(\\d),(\\d)\"$")
	public void user_enter_directions_to(int x, int y) throws Throwable {
		commandFactory.create(x + "," + y).run();
	}

	@Then("^board with a message should be shown$")
	public void user_enter_directions_to(String expectedOutput) throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith(expectedOutput));
	}

	@When("^active player make a movement to \\((\\d+),(\\d+)\\)$")
	public void active_player_make_a_movement_to(int x, int y) throws Throwable {
		user_enter_directions_to(x, y);
	}

	@Then("^Next player should be active$")
	public void next_player_should_be_active() throws Throwable {
		Assert.assertEquals("X", game.getActivePlayer().toString());
	}

	@Given("^game$")
	public void game() throws Throwable {
		console_game();
	}

	@When("^game is completed$")
	public void game_is_completed() throws Throwable {
		commandFactory.create("start").run();
		commandFactory.create("0,0").run();
		commandFactory.create("1,0").run();
		commandFactory.create("0,1").run();
		commandFactory.create("1,1").run();
		commandFactory.create("0,2").run();
	}

	@When("^console board is full$")
	public void console_board_is_full() throws Throwable {
		commandFactory.create("start").run();
		commandFactory.create("0,0").run();
		commandFactory.create("0,1").run();
		commandFactory.create("0,2").run();
		commandFactory.create("1,0").run();
		commandFactory.create("1,1").run();
		commandFactory.create("1,2").run();
		commandFactory.create("2,0").run();
		commandFactory.create("2,1").run();
		commandFactory.create("2,1").run();
		commandFactory.create("2,2").run();
	}

	@Then("^user is asked to play again$")
	public void user_is_asked_to_play_again() throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith("Do you want to play again? (y/n): "));
	}

	@Then("^user answers \"(.*?)\"$")
	public void user_answers(String userAnswer) throws Throwable {
		commandFactory.create(userAnswer).run();
	}

	@Then("^Message is shown$")
	public void message_is_shown(String expectedMessage) throws Throwable {
		String message = String.format("expected: %s\r\ngot: %s", expectedMessage, outputStream.toString());
		Assert.assertTrue(message, outputStream.toString().endsWith(expectedMessage));
	}

	@When("^user enter unknown command \"(.*?)\"$")
	public void user_enter_unknown_command(String unknownCommand) throws Throwable {
		commandFactory.create(unknownCommand).run();
	}

	@When("^user enter help command$")
	public void user_enter_help_command() throws Throwable {
		commandFactory.create("help").run();
	}

}
