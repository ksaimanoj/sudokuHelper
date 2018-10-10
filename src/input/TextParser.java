package input;

import base.Board;
import base.Parser;

public class TextParser extends Parser {

	private String[] gridInput;
	private int[] gridNumbers;

	@Override
	public int[] parse(String input) {
		validateInitialInput(input);
		gridInput = splitInputByDelimiter(input);
		gridNumbers = new int[gridInput.length];
		validateInputCharacters();
		return gridNumbers;
	}

	private void validateInitialInput(String input) {
		if (input == null)
			throw new NullInput();
		if (input.equals(""))
			throw new EmptyInput();
	}

	private String[] splitInputByDelimiter(String input) {
		return input.split(",", -1);
	}

	private void validateInputCharacters() {
		validateNumberOfCharacters();
		validateIfCharactersAreNumbers();
	}

	private void validateNumberOfCharacters() {
		if (gridInput.length != 81)
			throw new InvalidInput("Expected 81 numbers. Obtained "
					+ gridInput.length + "characters");
	}

	private void validateIfCharactersAreNumbers() throws NumberFormatException {
		for (int characterNo = 0; characterNo < gridInput.length; characterNo++)
			convertStringToInteger(characterNo);

	}

	private void convertStringToInteger(int characterNo)
			throws NumberFormatException {
		gridNumbers[characterNo] = Integer.parseInt(gridInput[characterNo]);
	}
}
