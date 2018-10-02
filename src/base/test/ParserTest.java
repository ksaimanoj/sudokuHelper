package base.test;

import org.junit.Test;

import base.Parser;
import base.TextParser;

public class ParserTest {
	
	@Test(expected=Parser.InvalidInput.class)
	public void validateInput()
	{
		String notValidInput = "" 
				+ "9,9,9,2,3,4,1,2,"
				+ ",,,2,4,2,3,,,"
				+ ",3,3,2,,,,,,"
				+ ",,,,,,,,,";
		
		Parser parser = new TextParser();
		parser.parse(notValidInput);
	}
	
	@Test
	public void validInput()
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
		
		Parser parser = new TextParser();
		parser.parse(notValidInput);
	}

}
