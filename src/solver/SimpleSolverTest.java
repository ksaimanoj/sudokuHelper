package solver;

import org.junit.Before;
import org.junit.Test;

import base.Board;
import base.Solver;
import input.ParserFactory;
import input.ParserType;
import junit.framework.Assert;

public class SimpleSolverTest {

	Solver solver;
	Board board;

	@Before
	public void setUp() {
		solver = new SimpleSolver();
		createBoard();
	}

	private void createBoard() {
		board = new Board();
		board.setState(ParserFactory.getParser(ParserType.TEXT)
				.parse(formSudokuInput()));
	}

	@Test
	public void solveNotNullTest() {
		Assert.assertNotNull(solver.solve(board));
	}

	private String formSudokuInput() {
		return "9,0,0,0,0,2,0,0,4," + "0,0,6,0,0,0,0,0,1,"
				+ "0,0,2,6,5,0,0,0,0," + "0,0,0,0,0,5,2,8,0,"
				+ "0,0,7,0,0,0,1,0,0," + "0,5,3,8,0,0,0,0,0,"
				+ "0,0,0,0,4,1,8,0,0," + "8,0,0,0,0,0,6,0,0,"
				+ "1,0,0,9,0,0,0,0,7";
	}

}
