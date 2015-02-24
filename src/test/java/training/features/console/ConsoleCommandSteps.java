package training.features.console;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;

import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.command.CommandFactory.Command;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.consoleapp.core.model.ConsoleBoard;
import training.core.model.Board;
import training.core.model.Game;
import training.features.core.BoardStateSteps;
import training.features.core.ScenarioState;
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

	private CommandFactory commandFactory;
	private OutputStream outputStream;
	private MessageInput messageInput;
	private MessageOutput messageOutput;
	private ScenarioState state;
	
	@Inject
	public ConsoleCommandSteps(ScenarioState state) {
		this.state = state;
	}
	
	@Before
	public void before() {
		outputStream = new ByteArrayOutputStream();
		messageInput = new MessageInput(outputStream);
		messageOutput = new MessageOutput(outputStream);
		state.setGame(new Game());
	}

	@Given("^command line interface$")
	public void console_game() throws Throwable {
		commandFactory = new CommandFactory(state.getGame(), messageInput, messageOutput);
	}
	
	@Given("^user started the application$")
	public void user_started_the_application() throws Throwable {
		commandFactory.create(Command.START_APPLICATION).run();
	}

	@When("^user entered command (.*)$")
	public void user_enter_command(String command) throws Throwable {
		commandFactory.create(command).run();
	}
	
	@Then("^text should be shown$")
	public void text_should_be_shown(String expectedText) throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith(expectedText));
	}
	
	@Then("^user is asked \"(.*)\"$")
	public void user_is_asked(String expectedQuestion) throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith(expectedQuestion));
	}

	@Then("^board should be shown$")
	public void board_should_be_shown(List<List<String>> expectedBoardDefinition) throws Throwable {
		Board expectedBoard = new ConsoleBoard(BoardStateSteps.convertToArray(expectedBoardDefinition));
		Assert.assertEquals(expectedBoard, state.getGame().getBoard());
	}

	@Given("^game started$")
	public void started_game() throws Throwable {
		commandFactory.create("start").run();
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

	@Then("^user answers \"(.*?)\"$")
	public void user_answers(String userAnswer) throws Throwable {
		commandFactory.create(userAnswer).run();
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
