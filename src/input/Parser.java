package input;

import base.Board;

public abstract class Parser {

	public abstract Board parse(String input);

	public static class InvalidInput extends RuntimeException {

	}

	public static class FileNotPresent extends RuntimeException {

	}

	public static class IncorrectGridFormat extends RuntimeException {

	}
}
