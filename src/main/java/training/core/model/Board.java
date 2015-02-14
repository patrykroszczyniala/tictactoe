package training.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import training.core.GameRuntimeException;
import training.core.GameRuntimeException.Warning;

public class Board {

	private String[][] boardDefinition;

	public Board() {
		this.boardDefinition = new String[][] { { "_", "_", "_" }, { "_", "_", "_" }, { "_", "_", "_" } };
	}

	public Board(String[][] boardDefinition) {
		this.boardDefinition = boardDefinition;
	}

	public String[][] getBoardDefinition() {
		return boardDefinition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(boardDefinition);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(boardDefinition, other.boardDefinition))
			return false;
		return true;
	}

	public void setPosition(int x, int y, String string) throws GameRuntimeException {
		try {
			boolean isCellUsed = !boardDefinition[x][y].equals("_");
			if (isCellUsed) {
				throw new GameRuntimeException(Warning.POSITION_ALREADY_USED);
			}
			boardDefinition[x][y] = string;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new GameRuntimeException(Warning.BOARD_SIZE_EXCEEDED);
		}
	}

	@Override
	public String toString() {
		String boardAsString = "";
		for (int i = 0; i < boardDefinition.length; i++) {
			boardAsString += "|";
			for (int j = 0; j < boardDefinition.length; j++) {
				boardAsString += " " + boardDefinition[j][i] + " |";
			}
			boolean hasNextRow = i + 1 < boardDefinition.length;
			if (hasNextRow) {
				boardAsString += "\r\n";
			}
		}
		return boardAsString;
	}

	public boolean completed() {
		String win1 = String.format("%s%s%s", boardDefinition[0][0], boardDefinition[0][1], boardDefinition[0][2]);
		String win2 = String.format("%s%s%s", boardDefinition[1][0], boardDefinition[1][1], boardDefinition[1][2]);
		String win3 = String.format("%s%s%s", boardDefinition[2][0], boardDefinition[2][1], boardDefinition[2][2]);
		String win4 = String.format("%s%s%s", boardDefinition[0][0], boardDefinition[1][0], boardDefinition[2][0]);
		String win5 = String.format("%s%s%s", boardDefinition[0][1], boardDefinition[1][1], boardDefinition[2][1]);
		String win6 = String.format("%s%s%s", boardDefinition[0][2], boardDefinition[1][2], boardDefinition[2][2]);
		List<String> wins = new ArrayList<String>();
		wins.add(win1);
		wins.add(win2);
		wins.add(win3);
		wins.add(win4);
		wins.add(win5);
		wins.add(win6);
		if (wins.contains("xxx") || wins.contains("ooo")) {
			return true;
		}
		return false;
	}

}
