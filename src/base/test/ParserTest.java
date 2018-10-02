package base.test;

import org.junit.Test;

import base.Board;
import base.Parser;
import base.ParserFactory;
import base.ParserType;
import base.TextParser;
import junit.framework.Assert;

public class ParserTest {
	
	@Test(expected=Parser.InvalidInput.class)
	public void validateIncorrectTextInput()
	{
		String notValidInput = "" 
				+ "9,9,9,2,3,4,1,2,"
				+ ",,,2,4,2,3,,,"
				+ ",3,3,2,,,,,,"
				+ ",,,,,,,,,";
		
		Parser parser = ParserFactory.getParser(ParserType.TEXT);
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
		
		Parser parser = ParserFactory.getParser(ParserType.TEXT);
		//parser.parse(notValidInput);
	}
	
	@Test(expected=Parser.IncorrectGridFormat.class)
	public void validateIncorrectGridInput()
	{
		Parser parser = ParserFactory.getParser(ParserType.TEXT);
	}
	
	@Test
	public void validateCorrectGridInput()
	{
		Parser parser = ParserFactory.getParser(ParserType.TEXT);
	}
	
	@Test(expected=Parser.FileNotPresent.class)
	public void filePresentTest()
	{
		Parser parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test(expected=Parser.InvalidInput.class)
	public void validateIncorrectFormatFileTest()
	{
		Parser parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test
	public void validateCorrectFormatFileTest()
	{
		Parser parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test(expected=Parser.IncorrectGridFormat.class)
	public void validateIncorrectGridFormatFileTest()
	{
		Parser parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test
	public void validateCorrectGridFormatFileTest()
	{
		Parser parser = ParserFactory.getParser(ParserType.FILE);
	}
	
	@Test
	public void givenNumbersTest()
	{
		Parser parser = ParserFactory.getParser(ParserType.FILE);
		Board board = parser.parse("");
		Assert.assertEquals(0, board.getNumbers());
	}

}
