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

	@Test
	public void getGridNumberTest() {
		Assert.assertEquals(1, getGridNumber(0, 0));
		Assert.assertEquals(9, getGridNumber(8, 8));
		Assert.assertEquals(4, getGridNumber(4, 2));
		Assert.assertEquals(8, getGridNumber(7, 4));
	}

	private String formSudokuInput() {
		return "0,0,0,4,6,0,0,0,0," + 
				"5,0,0,0,0,0,4,0,0," + 
				"0,2,0,8,7,0,0,6,0," + 
				"3,0,0,0,1,2,9,0,8," + 
				"0,6,0,0,0,0,0,3,0," + 
				"7,0,2,3,8,0,0,0,6," + 
				"0,5,0,0,3,7,0,2,0," + 
				"0,0,4,0,0,0,0,0,1," + 
				"0,0,0,0,4,8,0,0,0";
	}

	private int getGridNumber(int row, int col) {
		return row / 3 * 3 + col / 3 + 1;
	}

}
