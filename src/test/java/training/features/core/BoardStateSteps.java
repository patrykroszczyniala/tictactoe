package training.features.core;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;

import training.core.GameRuntimeException;
import training.core.gameservice.LocalGameService;
import training.core.model.Board;
import training.core.model.Game;
import training.core.model.Symbol;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Unit test for simple App.
 */
@ScenarioScoped
public class BoardStateSteps {

	private ScenarioState state;
	private GameRuntimeException lastWarning;

	@Inject
	public BoardStateSteps(ScenarioState state) {
		super();
		this.state = state;
	}

	@Given("^a game with an empty board$")
	public void a_game_with_an_empty_board() throws Throwable {
		state.setGameService(new LocalGameService());
		state.getGameService().start(new Game(new Board()));
	}

	@Given("^a game with a board$")
	public void a_game_with_a_board(List<String> boardDefinition) throws Throwable {
		Board board = new Board(convertToArray(boardDefinition));
		state.setGameService(new LocalGameService());
		state.getGameService().start(new Game(board));
	}

	@When("^active player made a move to (\\d)$")
	public void active_player_made_a_move_to(int index) throws Throwable {
		try {
			state.getGameService().mark(index);
		} catch (GameRuntimeException e) {
			this.lastWarning = e;
		}
	}

	@Then("^board should be equal to$")
	public void board_should_be_equal_to(List<String> boardDefinition) throws Throwable {
		Board expected = new Board(convertToArray(boardDefinition));
		Board returned = state.getGameService().getGame().getBoard();
		boolean isEqual = returned.equals(expected);
		Assert.assertTrue("Boards aren't equal!\r\nexpected: " + expected + "\r\nreturned: " + returned
				+ "\r\ncucumber def: " + boardDefinition, isEqual);
	}

	@Then("^error should be returned \"(.*?)\"$")
	public void error_should_be_shown(String expectedWarning) throws Throwable {
		Assert.assertEquals(expectedWarning, lastWarning.getMessage());
	}

	@Then("^board is full$")
	public void board_is_completed() throws Throwable {
		Assert.assertTrue(state.getGameService().getGame().getBoard().isFull());
	}

	public static List<Symbol> convertToArray(List<String> boardDefinition) {
		List<Symbol> boardDef = new LinkedList<Symbol>();
		for (String symbolString : boardDefinition) {
			if (symbolString.equals("o")) {
				boardDef.add(Symbol.O);
			} else if (symbolString.equals("x")) {
				boardDef.add(Symbol.X);
			} else {
				boardDef.add(Symbol.EMPTY);
			}
		}

		return boardDef;
	}

}
