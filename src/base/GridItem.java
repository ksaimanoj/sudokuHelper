package base;

public class GridItem {
	
	public static final int MAXIMUM_POSSIBLE_VALUE = 9;
	
	private int value;
	private boolean[] possibleValues;
	
	public GridItem() {
		super();
		initializeAllPossibleValuesAsTrue();
	}

	private void initializeAllPossibleValuesAsTrue() {
		possibleValues = new boolean[MAXIMUM_POSSIBLE_VALUE];
		setAllPossibleValues(true);
	}

	public void setValue(int value) {
		this.value = value;
		initializeAllPossibleValuesAsTrue();
		if(isValueKnown())
			setAllPossibleValues(false);
	}

	private void setAllPossibleValues(boolean state) {
		for(int i = 0; i < MAXIMUM_POSSIBLE_VALUE; i++)
			possibleValues[i] = state;
	}
	
	public int value()
	{
		return this.value;
	}
	
	public void changePossibleValue(int index, boolean state)
	{
		possibleValues[index] = state;
	}
	
	public boolean isPossible(int index)
	{
		return possibleValues[index];
	}
	
	public boolean isValueKnown()
	{
		return this.value != 0;
	}

	public int[] getPossibleValues() {
		int[] possibleInts = new int[MAXIMUM_POSSIBLE_VALUE];
		for(int i = 0; i < MAXIMUM_POSSIBLE_VALUE; i++)
			if(possibleValues[i])
				possibleInts[i] = i + 1;
		return possibleInts;
	}
	
	
	
}
