package base;

public class TextParser extends Parser {

	private String[] gridCharacters;
	private int[] gridNumbers;

	@Override
	public Board parse(String input) {
		gridCharacters = getCharactersFromInput(input);
		validateInput();
		return createBoard();
	}

	public int getNumberOfCharacters() {
		return gridCharacters.length;
	}

	private String[] getCharactersFromInput(String input) {
		return input.split(",", -1);
	}

	private void validateInput() {
		validateNumberOfCharacters();
		validateIfCharactersAreNumbers();
	}

	private void validateNumberOfCharacters() {
		if (gridCharacters.length != 81)
			throw new InvalidInput();
	}

	private void validateIfCharactersAreNumbers() throws NumberFormatException {
		for (int characterNo = 0; characterNo < gridCharacters.length; characterNo++)
			convertStringToInteger(characterNo);

	}

	private void convertStringToInteger(int characterNo) {
		gridNumbers[characterNo] = Integer.parseInt(gridCharacters[characterNo]);
	}

	private Board createBoard() {
		return new Board(gridNumbers);
	}

}
