package base.test;

import org.junit.Before;
import org.junit.Test;

import base.Board;
import base.Parser;
import base.ParserFactory;
import base.ParserType;
import base.TextParser;
import junit.framework.Assert;

public class ParserTest {
	
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
		
	}
	
	@Test
	public void validateCorrectGridInput()
	{
		
	}
	
	@Test(expected=Parser.FileNotPresent.class)
	public void filePresentTest()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test(expected=Parser.InvalidInput.class)
	public void validateIncorrectFormatFileTest()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test
	public void validateCorrectFormatFileTest()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test(expected=Parser.IncorrectGridFormat.class)
	public void validateIncorrectGridFormatFileTest()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test
	public void validateCorrectGridFormatFileTest()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test
	public void givenNumbersTest()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
		Board board = parser.parse("");
		Assert.assertEquals(0, board.getNumbers());
	}

}
