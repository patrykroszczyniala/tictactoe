package training.features.core;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;

import training.core.model.Board;
import training.core.model.Board.Symbol;
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

	@When("^players made a moves$")
	public void player_made_a_moves(List<String> moves) throws Throwable {
		for (String move : moves) {
			int x = Integer.valueOf(move.substring(0, 1).trim());
			int y = Integer.valueOf(move.substring(2, 3).trim());
			state.getGame().mark(x, y);
		}
	}

	@Then("^player (O|X) should be active$")
	public void player_should_be_active(String expectedActivePlayer) throws Throwable {
		Assert.assertEquals(expectedActivePlayer, state.getGame().getActivePlayer().toString());
	}

	@Then("^Active player is the winner$")
	public void active_player_is_the_winner() throws Throwable {
		Assert.assertEquals(Player.O, state.getGame().getWinner());
	}
	
	@Then("^player '(O|X)' is the winner$")
	public void player_is_the_winner(String playerSymbol) throws Throwable {
		Assert.assertEquals(Symbol.valueOf(playerSymbol), state.getGame().getWinner().getSymbol());
	}

}
