package base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void convertTo2DTest() {
		Assert.assertEquals(0, board.convertTo2D(0, 0));
		Assert.assertEquals(80, board.convertTo2D(8, 8));
		Assert.assertEquals(22, board.convertTo2D(2, 4));
		Assert.assertEquals(71, board.convertTo2D(7, 8));
	}

	@Test
	public void removeValueFromRowTest() {
		board.setState(gridNumbers);
		board.removeValueFromRow(0, 9);
		GridItem[][] items = board.getState();
		for (int i = 0; i < Board.WIDTH; i++)
			Assert.assertFalse(items[0][i].isPossible(9 - 1));

		board.removeValueFromRow(4, 8);
		items = board.getState();
		for (int i = 0; i < Board.WIDTH; i++)
			Assert.assertFalse(items[4][i].isPossible(8 - 1));
	}

	@Test
	public void removeValueFromColumnTest() {
		board.setState(gridNumbers);
		board.removeValueFromColumn(8, 4);
		GridItem[][] items = board.getState();
		for (int i = 0; i < Board.LENGTH; i++)
			Assert.assertFalse(items[i][8].isPossible(4 - 1));

		board.removeValueFromColumn(2, 5);
		items = board.getState();
		for (int i = 0; i < Board.LENGTH; i++)
			Assert.assertFalse(items[i][2].isPossible(5 - 1));

	}

	@Test
	public void removeValueFromBoardTest() {
		board.setState(gridNumbers);
		board.removeValueFromBoard(1, 9);
		GridItem[][] items = board.getState();
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				Assert.assertFalse(items[row][col].isPossible(9 - 1));
			}
		}
		
		board.removeValueFromBoard(8, 2);
		items = board.getState();
		for(int row = 6; row < 9; row++)
		{
			for(int col = 3; col < 6; col++)
			{
				Assert.assertFalse(items[row][col].isPossible(2 - 1));
			}
		}
	}

	private String formSudokuInput() {
		return "9,0,0,0,0,2,0,0,4," + "0,0,6,0,0,0,0,0,1,"
				+ "0,0,2,6,5,0,0,0,0," + "0,0,0,0,0,5,2,8,0,"
				+ "0,0,7,0,0,0,1,0,0," + "0,5,3,8,0,0,0,0,0,"
				+ "0,0,0,0,4,1,8,0,0," + "8,0,0,0,0,0,6,0,0,"
				+ "1,0,0,9,0,0,0,0,7";
	}

}
