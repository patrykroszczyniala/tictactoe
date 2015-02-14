package training.features.core;

import java.util.List;

import org.junit.Assert;

import training.core.model.Board;
import training.core.model.Game;
import training.core.model.Game.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Unit test for simple App.
 */
public class GameStateSteps {

	private Game game;

	@Given("^new game$")
	public void new_game() throws Throwable {
		game = new Game();
	}

	@When("^game has started$")
	public void game_has_started() throws Throwable {
		game.start();
	}

	@When("^active player made a move$")
	public void active_player_made_a_move() throws Throwable {
		game.move(1, 1);
	}

	@Then("^player \"(O|X)\" should be active$")
	public void player_O_should_be_active(String expectedActivePlayer) throws Throwable {
		Assert.assertEquals(expectedActivePlayer, game.getActivePlayer().toString());
	}
	
	@Given("^game with a board$")
	public void game_with_a_board(List<List<String>> boardDefinition) throws Throwable {
		game = new Game();
		game.start(new Board(AppTestSteps.convertToArray(boardDefinition)));
	}

	@When("^Active player make a move to \\((\\d+),(\\d+)\\)$")
	public void active_player_make_a_move_to(int x, int y) throws Throwable {
		game.move(x, y);
	}

	@Then("^Active player is the winner$")
	public void active_player_is_the_winner() throws Throwable {
		Assert.assertEquals(Player.O, game.getWinner());
	}
	
}
