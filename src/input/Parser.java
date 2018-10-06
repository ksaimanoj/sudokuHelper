package input;

import base.Board;

public abstract class Parser {

	public abstract Board parse(String input);
	
	public static class FileNotPresent extends RuntimeException {

	}

	public static class IncorrectGridFormat extends RuntimeException {

	}

	public class NullInput extends RuntimeException {

	}

	public class EmptyInput extends RuntimeException {

	}

	public static class InvalidInput extends RuntimeException {
		
		String message;
		
		public InvalidInput(String message) {
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;
		}
	}

}
