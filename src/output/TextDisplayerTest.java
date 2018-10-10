package output;

import org.junit.*;

import base.*;
import input.*;
import output.*;

public class TextDisplayerTest {

	Parser parser;
	Displayer displayer;

	@Before
	public void setUp() {
		parser = ParserFactory.getParser(ParserType.TEXT);
		displayer = DisplayerFactory.getDisplayer(DisplayerType.TEXT);
	}

	@Test
	public void displayTest()
	{
		String inputString = sudokuInput();
		Board board = new Board();
		board.setState(parser.parse(inputString));
		displayer.setBoard(board);
		displayer.display();
	}

	private String sudokuInput() {
		return "0,0,0,0,1,9,0,8,0," + 
				"3,7,0,0,0,0,5,0,0," + 
				"0,2,0,6,0,0,4,0,0," + 
				"0,3,7,0,0,0,0,0,0," + 
				"4,0,0,0,0,0,0,0,2," + 
				"0,0,0,0,0,0,8,1,0," + 
				"0,0,3,0,0,6,0,7,0," + 
				"0,0,1,0,0,0,0,5,6," + 
				"0,8,0,3,5,0,0,0,0";
	}

}
