package input;

import base.Parser;

public class ParserFactory {
	
	public static Parser getParser(ParserType parserType) {
		switch (parserType) {
		case TEXT:
			return new TextParser();
		case FILE:
			return new FileParser();
		default:
			return new TextParser();
		}
	}

}
