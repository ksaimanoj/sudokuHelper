package base;

public abstract class Parser {

	public abstract Board parse(String input);

	public static class InvalidInput extends RuntimeException {

	}
}
