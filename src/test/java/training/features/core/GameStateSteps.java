package training.features.core;

import javax.inject.Inject;

import org.junit.Assert;

import training.core.model.Board;
import training.core.model.Game;
import training.core.model.Game.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Unit test for simple App.
 */
@ScenarioScoped
public class GameStateSteps {

	private ScenarioState state;

	@Inject
	public GameStateSteps(ScenarioState state) {
		super();
		this.state = state;
	}

	@Given("^new game$")
	public void new_game() throws Throwable {
		state.setGame(new Game());
	}

	@When("^game has started$")
	public void game_has_started() throws Throwable {
		state.getGame().start(new Board());
	}

	@When("^active player made a move$")
	public void active_player_made_a_move() throws Throwable {
		state.getGame().move(1, 1);
	}

	@Then("^player (O|X) should be active$")
	public void player_should_be_active(String expectedActivePlayer) throws Throwable {
		Assert.assertEquals(expectedActivePlayer, state.getGame().getActivePlayer().toString());
	}

	@When("^Active player make a move to \\((\\d+),(\\d+)\\)$")
	public void active_player_make_a_move_to(int x, int y) throws Throwable {
		state.getGame().move(x, y);
	}

	@Then("^Active player is the winner$")
	public void active_player_is_the_winner() throws Throwable {
		Assert.assertEquals(Player.O, state.getGame().getWinner());
	}

}
