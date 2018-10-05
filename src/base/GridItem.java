package base;

public class GridItem {
	
	public static final int MAXIMUM_POSSIBLE_VALUES = 9;
	
	private int value;
	private boolean[] possibleValues;
	
	public GridItem() {
		super();
		initializePossibleValues();
	}

	private void initializePossibleValues() {
		possibleValues = new boolean[MAXIMUM_POSSIBLE_VALUES];
		
		for(int i = 0; i < MAXIMUM_POSSIBLE_VALUES; i++)
			possibleValues[i] = true;
	}

	public void setValue(int value) {
		this.value = value;
		initializePossibleValues();
		if(value != 0)
		{
			for(int i = 0; i < MAXIMUM_POSSIBLE_VALUES; i++)
				possibleValues[i] = false;
		}
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public void setPossibleValueFalse(int value)
	{
		possibleValues[value] = false;
	}
	
	public boolean isPossible(int index)
	{
		return possibleValues[index];
	}
	
	public boolean isValueFixed()
	{
		return this.value != 0;
	}
	
}
