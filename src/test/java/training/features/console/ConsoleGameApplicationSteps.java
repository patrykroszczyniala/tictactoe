package training.features.console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.Assert;

import training.application.console.ConsoleGameApplication;
import training.application.console.model.ConsoleBoard;
import training.core.model.Board;
import training.features.core.AppTestSteps;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Unit test for simple App.
 */
public class ConsoleGameApplicationSteps {

	private ConsoleGameApplication consoleApplication;
	private OutputStream outputStream;
	private InputStream inputStream;

	@Before
	public void before() {
		outputStream = new ByteArrayOutputStream();
		inputStream = new ByteArrayInputStream(new byte[10000]);
	}

	@Given("^console application$")
	public void console_game() throws Throwable {
		consoleApplication = new ConsoleGameApplication(inputStream, outputStream);
	}

	@When("^console application has started$")
	public void application_is_started() throws Throwable {
		consoleApplication.start();
	}

	@Then("^welcome text should be shown$")
	public void welcome_text_should_be_shown(String welcomeText) throws Throwable {
		Assert.assertEquals(welcomeText, outputStream.toString());
	}

	@When("^user enter start command$")
	public void user_enter_start_command() throws Throwable {
//		inputStream = new ByteArrayInputStream("start".getBytes());
//		System.setIn(inputStream);
//		consoleApplication.start();
	}

	@Then("^game should be started$")
	public void game_should_be_started(String expectedStartText) throws Throwable {
		inputStream = new ByteArrayInputStream("start".getBytes());
		consoleApplication.setIn(inputStream);
		consoleApplication.start();
		Assert.assertNotNull(consoleApplication.getGame());
		Assert.assertTrue(outputStream.toString().endsWith(expectedStartText));
	}

	@Then("^empty board should be shown$")
	public void empty_board_should_be_shown(List<List<String>> expectedBoardDefinition) throws Throwable {
		Board expectedBoard = new ConsoleBoard(AppTestSteps.convertToArray(expectedBoardDefinition));
		Assert.assertEquals(expectedBoard, consoleApplication.getGame().getBoard());
	}

	@Given("^started game$")
	public void started_game() throws Throwable {
		consoleApplication = new ConsoleGameApplication(inputStream, outputStream);
	}

	@When("^user enter directions to \"(\\d),(\\d)\"$")
	public void user_enter_directions_to(int x, int y) throws Throwable {
		inputStream = new ByteArrayInputStream(("start\r\n"+x+","+y).getBytes());
		consoleApplication.setIn(inputStream);
		consoleApplication.start();
	}
	
	@Then("^board with a message should be shown$")
	public void user_enter_directions_to(String expectedOutput) throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith(expectedOutput));
	}
	
	@When("^active player make a movement to \\((\\d+),(\\d+)\\)$")
	public void active_player_make_a_movement_to(int x, int y) throws Throwable {
		inputStream = new ByteArrayInputStream(("start\r\n"+x+","+y).getBytes());
		consoleApplication.setIn(inputStream);
		consoleApplication.start();
	}

	@Then("^Next player should be active$")
	public void next_player_should_be_active() throws Throwable {
		Assert.assertEquals("X", consoleApplication.getGame().getActivePlayer().toString());
	}
	
	@Given("^game$")
	public void game() throws Throwable {
		consoleApplication = new ConsoleGameApplication(inputStream, outputStream);
	}

	@When("^game is completed$")
	public void game_is_completed() throws Throwable {
		inputStream = new ByteArrayInputStream(("start\r\n0,0\r\n1,0\r\n0,1\r\n1,1\r\n0,2").getBytes());
		consoleApplication.setIn(inputStream);
		consoleApplication.start();
	}
	
	@When("^console board is full$")
	public void console_board_is_full() throws Throwable {
		inputStream = new ByteArrayInputStream(("start\r\n0,0\r\n0,1\r\n0,2\r\n1,0\r\n1,1\r\n1,2\r\n2,0\r\n2,1\r\n2,1\r\n2,2").getBytes());
		consoleApplication.setIn(inputStream);
		consoleApplication.start();
	}

	@Then("^user is asked to play again$")
	public void user_is_asked_to_play_again() throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith("Do you want to play again? (y/n): "));
	}
	
	@Then("^user answers \"(.*?)\"$")
	public void user_answers(String userAnswer) throws Throwable {
		inputStream = new ByteArrayInputStream(("y").getBytes());
		consoleApplication.setIn(inputStream);
	}

	@Then("^Message is shown$")
	public void message_is_shown(String expectedMessage) throws Throwable {
		String message = String.format("expected: %s\r\ngot: %s", expectedMessage, outputStream.toString());
		Assert.assertTrue(message, outputStream.toString().endsWith(expectedMessage));
	}
	
	@When("^user enter unknown command \"(.*?)\"$")
	public void user_enter_unknown_command(String unknownCommand) throws Throwable {
		inputStream = new ByteArrayInputStream(("unknownCommand").getBytes());	
		consoleApplication.setIn(inputStream);
		consoleApplication.start();
	}
	
	@When("^user enter help command$")
	public void user_enter_help_command() throws Throwable {
		inputStream = new ByteArrayInputStream(("help").getBytes());	
		consoleApplication.setIn(inputStream);
		consoleApplication.start();
	}

}
