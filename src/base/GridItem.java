package base;

import java.util.ArrayList;
import java.util.List;

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
		possibleValues[index - 1] = state;
	}
	
	public boolean isPossible(int index)
	{
		return possibleValues[index];
	}
	
	public boolean isValueKnown()
	{
		return this.value != 0;
	}

	public List<Integer> getPossibleValues() {
		List<Integer> possibleIntegerList = new ArrayList<>();
		for(int i = 0; i < GridItem.MAXIMUM_POSSIBLE_VALUE; i++)
		{
			if(possibleValues[i])
				possibleIntegerList.add(i + 1);
		}
		return possibleIntegerList;
	}
	
	
	
}
