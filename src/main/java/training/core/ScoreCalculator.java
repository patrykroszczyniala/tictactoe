package training.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import training.core.model.Player;

/**
 * Class that represents game board.
 */
public class ScoreCalculator {
		
	private Map<Player, Integer[]> score;
	private int boardSize = 3;

	public ScoreCalculator(Player player1, Player player2) {
		score = new HashMap<Player, Integer[]>();
		score.put(player1, new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0 });
		score.put(player2, new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0 });
	}

	public void calculate(Player player, int x, int y) {
		Integer[] scoreTable = score.get(player);
		int row = y;
		int col = x+boardSize;
		int diag1 = 2*boardSize; 
		int diag2 = 2*boardSize+1;
		scoreTable[row]++;
		scoreTable[col]++;
		if (x==y) {
			scoreTable[diag1]++;
		}
		if (y==(boardSize-1-x)) {
			scoreTable[diag2]++;
		}
	}
	
	public boolean isWinner(Player player) {
		return Arrays.asList(score.get(player)).contains(boardSize);
	}

}
