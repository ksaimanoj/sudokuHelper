package solver;

import base.Board;
import base.Solver;

public class SimpleSolver implements Solver {

	@Override
	public Board solve(Board board) {
		Board newBoard = new Board();
		newBoard.setState(board.getState());
		return newBoard;
	}

}
