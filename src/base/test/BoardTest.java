package base.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import base.Board;
import input.Parser;
import input.ParserFactory;
import input.ParserType;

public class BoardTest {

	Board board;
	Parser parser;
	int[] gridNumbers;

	@Before
	public void setUp() {
		board = new Board();
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

		Assert.assertEquals(Board.LENGTH, board.getState().length);
		Assert.assertEquals(Board.WIDTH, board.getState()[0].length);

		Assert.assertNotNull(board.getState()[0][0]);
		Assert.assertEquals(9, board.getState()[0][0].value());
	}
	
	@Test
	public void convertTo2DTest()
	{
		Assert.assertEquals(0, board.convertTo2D(0, 0));
		Assert.assertEquals(80, board.convertTo2D(8, 8));
		Assert.assertEquals(22, board.convertTo2D(2, 4));
		Assert.assertEquals(71, board.convertTo2D(7, 8));
	}

	private String formSudokuInput() {
		return "9,0,0,0,0,2,0,0,4," + "0,0,6,0,0,0,0,0,1,"
				+ "0,0,2,6,5,0,0,0,0," + "0,0,0,0,0,5,2,8,0,"
				+ "0,0,7,0,0,0,1,0,0," + "0,5,3,8,0,0,0,0,0,"
				+ "0,0,0,0,4,1,8,0,0," + "8,0,0,0,0,0,6,0,0,"
				+ "1,0,0,9,0,0,0,0,7";
	}

}
