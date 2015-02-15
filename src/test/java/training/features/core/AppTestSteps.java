package training.features.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import training.core.GameRuntimeException;
import training.core.model.Board;
import training.core.model.Board.Symbol;
import training.core.model.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Unit test for simple App.
 */
public class AppTestSteps {

	protected Game game;
	private GameRuntimeException lastWarning;

	@Given("^a game with an empty board$")
	public void a_game_with_an_empty_board() throws Throwable {
		game = new Game();
		game.start(new Board());
	}

	@Given("^a game with a board$")
	public void a_game_with_a_board(List<List<String>> boardDefinition) throws Throwable {
		game = new Game();
		game.start(new Board(convertToArray(boardDefinition)));
	}

	public static List<List<Symbol>> convertToArray(List<List<String>> boardDefinition) {
		List<List<Symbol>> boardDef = new ArrayList<List<Symbol>>();
		for (List<String> row : boardDefinition) {
			List<Symbol> boardDefRow = new ArrayList<Symbol>();
			for (String symbolString : row) {
				if (symbolString.equals("o")) {
					boardDefRow.add(Symbol.O);
				}
				else if (symbolString.equals("x")) {
					boardDefRow.add(Symbol.X);
				}
				else {
					boardDefRow.add(Symbol.EMPTY);
				}
			}
			boardDef.add(boardDefRow);
		}
		return boardDef;
	}

	@When("^player made a move to \\((\\d),(\\d)\\)$")
	public void player_made_a_move_to(int x, int y) throws Throwable {
		try {
			game.move(x, y);
		} catch (GameRuntimeException e) {
			this.lastWarning = e;
		}
	}

	@Then("^board should be equal to$")
	public void board_should_be_equal_to(List<List<String>> boardDefinition) throws Throwable {
		boolean isEqual = game.getBoard().equals(new Board(convertToArray(boardDefinition)));
		Assert.assertTrue("Boards aren't equal!", isEqual);
	}

	@Then("^error should be shown \"(.*?)\"$")
	public void error_should_be_shown(String expectedWarning) throws Throwable {
		Assert.assertEquals(expectedWarning, lastWarning.getMessage());
	}
	
	@Then("^board is full$")
	public void board_is_completed() throws Throwable {
		Assert.assertTrue(game.getBoard().isFull());
	}

}
