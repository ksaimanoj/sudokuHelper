package input.test;

import org.junit.*;

import base.*;
import input.Parser;
import input.ParserFactory;
import input.ParserType;
import input.TextParser;
import junit.framework.Assert;

public class TextParserTest {
	
	private Parser parser;
	
	@Before
	public void setUp()
	{
		parser = ParserFactory.getParser(ParserType.TEXT);
	}

	@Test(expected=Parser.InvalidInput.class)
	public void validateIncorrectTextInput()
	{
		String notValidInput = "" 
				+ "9,9,9,2,3,4,1,2,"
				+ ",,,2,4,2,3,,,"
				+ ",3,3,2,,,,,,"
				+ ",,,,,,,,,";
		
		parser.parse(notValidInput);
	}
	
	@Test
	public void validateCorrectTextInput()
	{
		String notValidInput = "" 
				+ "9,9,9,2,3,4,1,2,3,"
				+ "1,1,1,2,4,2,3,1,1,"
				+ "1,3,3,2,1,1,1,1,1,"
				
				+ "1,2,3,1,1,1,1,1,1,"
				+ "1,1,1,4,1,1,1,1,1,"
				+ "1,1,1,1,2,1,1,1,1,"
				
				+ "1,1,1,1,2,1,1,1,1,"
				+ "1,1,1,1,1,9,1,1,1,"
				+ "1,1,1,1,1,1,8,1,1,";
		
		parser.parse(notValidInput);
	}
	
	@Test(expected=Parser.IncorrectGridFormat.class)
	public void validateIncorrectGridInput()
	{
		String notValidInput = "" 
				+ "9,9,9,2,3,4,1,2,3,"
				+ "1,1,1,2,4,2,3,1,1,"
				+ "1,3,3,2,1,1,1,1,1,"
				
				+ "1,2,3,1,1,1,1,1,1,"
				+ "1,1,1,4,1,1,1,1,1,"
				+ "1,1,1,1,2,1,1,1,1,"
				
				+ "1,1,1,1,2,1,1,1,1,"
				+ "1,1,1,1,1,9,1,1,1,"
				+ "1,1,1,1,1,1,8,1,1,";
		
		parser.parse(notValidInput);
	}
	
	@Test
	public void validateCorrectGridInput()
	{
		
	}
		
	@Test
	public void givenNumbersTest()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
		Board board = parser.parse("");
		Assert.assertEquals(0, board.getNumbers());
	}
	
	@Test
	public void gridCharactersSizeTest() {
		Parser parser = ParserFactory.getParser(ParserType.TEXT);
		String incompleteInput = "" 
				+ "9,9,9,2,3,4,1,2,"
				+ ",,,2,4,2,3,,,"
				+ ",3,3,2,,,,,,"
				+ ",,,,,,,,,";
		
		parser.parse(incompleteInput);
		TextParser textParser = (TextParser) parser;
		Assert.assertEquals(36, textParser.getNumberOfCharacters());
		
		incompleteInput = "" 
				+ "9,9,9,2,3,4,1,2,"
				+ ",,,2,4,2,3,,,"
				+ ",3,3,2,,,,,,"
				+ ",,,,,,,,,"
				+ ",,,,,,,,,"
				+ ",,,,,,,,,"
				+ ",,,,,,,,,"
				+ ",,,,,,,,,"
				+ ",,,,,,,,,";
		parser.parse(incompleteInput);
		textParser = (TextParser) parser;
		Assert.assertEquals(81, textParser.getNumberOfCharacters());
		
		incompleteInput = "" 
				+ "9,9,9,2,3,4,1,2,3,"
				+ "1,1,1,2,4,2,3,1,1,"
				+ "1,3,3,2,1,1,1,1,1,"
				
				+ "1,2,3,1,1,1,1,1,1,"
				+ "1,1,1,4,1,1,1,1,1,"
				+ "1,1,1,1,2,1,1,1,1,"
				
				+ "1,1,1,1,2,1,1,1,1,"
				+ "1,1,1,1,1,9,1,1,1,"
				+ "1,1,1,1,1,1,8,1,1";
		parser.parse(incompleteInput);
		textParser = (TextParser) parser;
		Assert.assertEquals(81, textParser.getNumberOfCharacters());
		
	}

}
