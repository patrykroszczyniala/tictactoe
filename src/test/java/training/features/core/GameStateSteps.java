package training.features.core;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;

import training.core.gameservice.LocalGameService;
import training.core.model.Board;
import training.core.model.Game;
import training.core.model.Player;
import training.core.model.Symbol;
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
		state.setGameService(new LocalGameService());
	}

	@When("^game has started$")
	public void game_has_started() throws Throwable {
		state.getGameService().start(new Game(new Board()));
	}

	@When("^players made a moves$")
	public void player_made_a_moves(List<String> moves) throws Throwable {
		for (String move : moves) {
			int index = Integer.valueOf(move.trim());
			state.getGameService().mark(index);
		}
	}

	@Then("^player (O|X) should be active$")
	public void player_should_be_active(String expectedActivePlayer) throws Throwable {
		Assert.assertEquals(expectedActivePlayer, state.getGameService().getGame().getActivePlayer().toString());
	}

	@Then("^Active player is the winner$")
	public void active_player_is_the_winner() throws Throwable {
		Assert.assertEquals(Player.O, state.getGameService().getWinner());
	}

	@Then("^player '(O|X)' is the winner$")
	public void player_is_the_winner(String playerSymbol) throws Throwable {
		Assert.assertEquals(Symbol.valueOf(playerSymbol), state.getGameService().getWinner().getSymbol());
	}

}
