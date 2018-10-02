package base;

public class TextParser extends Parser {

	private String[] gridCharacters;
	private int[] gridNumbers;

	@Override
	public Board parse(String input) {
		gridCharacters = getCharactersFromInput(input);
		validateInput();

		return null;
	}

	private String[] getCharactersFromInput(String input) {
		return input.split(",");
	}

	private void validateInput() {
		validateNumberOfCharacters();
		validateIfCharactersAreNumbers();
	}

	private void validateNumberOfCharacters() {
		if (gridCharacters.length != 81)
			throw new InvalidInput();
	}

	private void validateIfCharactersAreNumbers() {

	}

}
