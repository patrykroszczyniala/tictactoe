package training.features.console;

import javax.inject.Inject;

import training.consoleapp.core.command.CommandFactory.Command;
import training.core.model.Game;
import training.features.core.ScenarioState;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Tests for command-line commands that user can use during application lifecycle.
 */
@ScenarioScoped
public class ApplicationLifecycleSteps {
	
	private ScenarioState state;
	
	@Inject
	public ApplicationLifecycleSteps(ScenarioState state) {
		this.state = state;
	}
	
	@Before
	public void before() {
		state.setGame(new Game());
	}
	
	@Given("^user started the application$")
	public void user_started_the_application() throws Throwable {
		state.getCommandFactory().create(Command.START_APPLICATION).run();
	}

	@Then("^application should be closed$")
	public void user_should_not_be_able_to_enter_any_command() throws Throwable {
		// TODO ExpectedSystemExit rule probabily does not work with cucumber-jvm
	}
	
}