package training.features.console.multiplayer;

import javax.inject.Inject;

import training.consoleapp.core.command.ApplicationCommand;
import training.features.core.ScenarioState;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Tests for command-line commands that user can use during application lifecycle.
 */
@ScenarioScoped
public class MultiplayerSteps {

	private ScenarioState state;
	
	@Inject
	public MultiplayerSteps(ScenarioState state) {
		this.state = state;
	}
	
	@Before
	public void before() {
	}

	@Given("^multiplayer game is running$")
	public void multiplayer_game_is_running() throws Throwable {
		state.getCommandFactory().create(ApplicationCommand.START_MULTIPLAYER_GAME).run();
	}

}
