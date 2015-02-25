package training.features.console;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import training.consoleapp.core.command.CommandFactory;
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
 * Tests for command-line commands that user can use during application lifecycle.
 */
@ScenarioScoped
public class CommandLineInterfaceCommandsSteps {

	// TODO does not work with cucumber-jvm?
	@Rule
	public final ExpectedSystemExit expectedExit = ExpectedSystemExit.none();
	
	private OutputStream outputStream;
	private MessageInput messageInput;
	private MessageOutput messageOutput;
	private ScenarioState state;
	
	@Inject
	public CommandLineInterfaceCommandsSteps(ScenarioState state) {
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
	public void command_line_interface() throws Throwable {
		CommandFactory commandFactory = new CommandFactory(state.getGame(), messageInput, messageOutput);
		state.setCommandFactory(commandFactory);
	}
	
	@When("^user entered command (.*)$")
	public void user_entered_command(String command) throws Throwable {
		state.getCommandFactory().create(command).run();
	}
	
	@When("^users entered commands$")
	public void users_entered_commands(List<String> commands) throws Throwable {
		for (String command : commands) {
			state.getCommandFactory().create(command).run();
		}
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

	@Then("^game is completed$")
	public void game_is_completed() throws Throwable {
		Assert.assertTrue(state.getGame().isCompleted());
	}

	@Then("^user answers \"(.*?)\"$")
	public void user_answers(String userAnswer) throws Throwable {
		state.getCommandFactory().create(userAnswer).run();
	}

}
