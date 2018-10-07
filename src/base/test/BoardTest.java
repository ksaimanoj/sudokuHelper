package base.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import base.Board2;
import input.Parser;
import input.ParserFactory;
import input.ParserType;

public class BoardTest {

	Board2 board;
	Parser parser;
	int[] gridNumbers;

	@Before
	public void setUp() {
		board = new Board2();
		parser = ParserFactory.getParser(ParserType.TEXT);
		gridNumbers = parser.parse(formSudokuInput());
	}

	@Test
	public void initializeEmptyBoardTest() {
		Assert.assertNotNull(board.getState());
	}

	@Test
	public void setBoardTest() {
		board.setState(gridNumbers);

		Assert.assertEquals(Board2.LENGTH, board.getState().length);
		Assert.assertEquals(Board2.WIDTH, board.getState()[0].length);

		Assert.assertNotNull(board.getState()[0][0]);
		Assert.assertEquals(9, board.getState()[0][0].value());
	}

	private String formSudokuInput() {
		return "9,0,0,0,0,2,0,0,4," + "0,0,6,0,0,0,0,0,1,"
				+ "0,0,2,6,5,0,0,0,0," + "0,0,0,0,0,5,2,8,0,"
				+ "0,0,7,0,0,0,1,0,0," + "0,5,3,8,0,0,0,0,0,"
				+ "0,0,0,0,4,1,8,0,0," + "8,0,0,0,0,0,6,0,0,"
				+ "1,0,0,9,0,0,0,0,7";
	}

}
