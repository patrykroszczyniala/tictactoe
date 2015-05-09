package training.features.console;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;

import training.consoleapp.core.command.ApplicationCommand;
import training.consoleapp.core.command.CommandFactory;
import training.consoleapp.core.io.MessageInput;
import training.consoleapp.core.io.MessageOutput;
import training.core.BoardService;
import training.core.gameservice.LocalGameService;
import training.core.model.Board;
import training.core.model.BoardState;
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
		state.setGameService(new LocalGameService());
		state.setConsoleBoardStateService(new BoardService(new BoardState()));
	}

	@Given("^command line interface$")
	public void command_line_interface() throws Throwable {
		CommandFactory commandFactory = new CommandFactory(state.getGameService(), state.getConsoleBoardStateService(), messageInput, messageOutput);
		state.setCommandFactory(commandFactory);
	}
	
	@Given("^user started the application$")
	public void user_started_the_application() throws Throwable {
		state.getCommandFactory().create(ApplicationCommand.START_APPLICATION).run();
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
		Assert.assertTrue("Expected:\r\n"+expectedText+"\r\n\r\nreturned:\r\n"+outputStream.toString(), outputStream.toString().endsWith(expectedText));
	}
	
	@Then("^user is asked \"(.*)\"$")
	public void user_is_asked(String expectedQuestion) throws Throwable {
		Assert.assertTrue(outputStream.toString().endsWith(expectedQuestion));
	}

	@Then("^board should be shown$")
	public void board_should_be_shown(List<String> expectedBoardDefinition) throws Throwable {
		Board expectedBoard = new Board(BoardStateSteps.convertToArray(expectedBoardDefinition));
		Assert.assertEquals(expectedBoard, state.getGameService().getGame().getBoard());
	}

	@Then("^game is completed$")
	public void game_is_completed() throws Throwable {
		Assert.assertTrue(state.getGameService().isCompleted());
	}

	@Then("^user answers \"(.*?)\"$")
	public void user_answers(String userAnswer) throws Throwable {
		state.getCommandFactory().create(userAnswer).run();
	}

}
