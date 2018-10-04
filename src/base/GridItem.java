package base;

public class GridItem {
	
	public static final int MAXIMUM_POSSIBLE_VALUES = 9;
	
	private int value;
	private boolean[] possibleValues;
	
	public GridItem() {
		super();
		possibleValues = new boolean[MAXIMUM_POSSIBLE_VALUES];
	}

	public void setValue(int value) {
		this.value = value;
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
	
	public boolean isValueFixed()
	{
		return this.value != 0;
	}
	
}
