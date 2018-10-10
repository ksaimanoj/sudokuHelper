package input;

import org.junit.Before;
import org.junit.Test;

import base.Parser;

public class FileParserTest {
	
	Parser parser;
	
	@Before
	public void setUp()
	{
		parser = ParserFactory.getParser(ParserType.FILE);
	}

	@Test(expected=Parser.FileNotPresent.class)
	public void filePresentTest()
	{
		
	}
	
	@Test(expected=Parser.InvalidInput.class)
	public void validateIncorrectFormatFileTest()
	{
		
	}
	
	@Test
	public void validateCorrectFormatFileTest()
	{
		
	}
	
	@Test(expected=Parser.IncorrectGridFormat.class)
	public void validateIncorrectGridFormatFileTest()
	{
		
	}
	
	@Test
	public void validateCorrectGridFormatFileTest()
	{
		
	}

	
}
