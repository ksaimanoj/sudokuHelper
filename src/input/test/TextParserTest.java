package input.test;

import static org.junit.Assert.assertNotNull;

import org.junit.*;

import base.Board;
import input.*;

public class TextParserTest {

	Parser parser;
	String sudokuInputText;

	@Before
	public void setUp() {
		parser = ParserFactory.getParser(ParserType.TEXT);
		sudokuInputText = "";
	}

	@Test(expected = Parser.NullInput.class)
	public void nullInputTest() {
		sudokuInputText = null;
		parser.parse(sudokuInputText);
	}

	@Test(expected = Parser.EmptyInput.class)
	public void emptyInputTest() {
		parser.parse(sudokuInputText);
	}

	@Test(expected = Parser.InvalidInput.class)
	public void invalidInputTest() {
		sudokuInputText = "2,1,4,2,1,4,2";
		parser.parse(sudokuInputText);
	}

	@Test(expected = NumberFormatException.class)
	public void numbersTest() {
		sudokuInputText = numbersTestInput();
		parser.parse(sudokuInputText);
	}

	@Test
	public void validInputTest() {
		sudokuInputText = validInput();
		Board board = parser.parse(sudokuInputText);
		assertNotNull(board);
	}

	private String numbersTestInput() {
		return "0,0,0,0,1,9,0,8,0," + "3,7,0,0,0,0,5,0,0,"
				+ "0,2,0,6,0,0,4,0,0," + "0,3,7,0,a,0,0,0,0,"
				+ "4,0,0,0,0,0,0,0,2," + "0,0,0,0,0,0,8,1,0,"
				+ "0,0,3,0,0,6,0,7,0," + "0,0,1,0,0,0,0,5,6,"
				+ "0,8,0,3,5,0,0,0,0";
	}

	private String validInput() {
		return "0,0,0,0,1,9,0,8,0," + "3,7,0,0,0,0,5,0,0,"
				+ "0,2,0,6,0,0,4,0,0," + "0,3,7,0,0,0,0,0,0,"
				+ "4,0,0,0,0,0,0,0,2," + "0,0,0,0,0,0,8,1,0,"
				+ "0,0,3,0,0,6,0,7,0," + "0,0,1,0,0,0,0,5,6,"
				+ "0,8,0,3,5,0,0,0,0";
	}
}
