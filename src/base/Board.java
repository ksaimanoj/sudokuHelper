package base;

public class Board {
	
	public static final int LENGTH = 9;
	public static final int WIDTH = 9;
	
	GridItem[][] items;
	
	public Board(int[] gridNumbers) {
		items = new GridItem[LENGTH][WIDTH];
		initializeBoard();
		initializeValues(gridNumbers);
	}
	
	public void solve()
	{
		for(int row = 0; row < LENGTH; row++)
		{
			for(int col = 0; col < WIDTH; col++)
			{
				if(items[row][col].isValueKnown())
					solveIndividualItem(row, col);
			}
		}
	}

	private void solveIndividualItem(int row, int col) {
		handleAllRowItems(row, col);
		handleAllColumnItems(row, col);
	}

	private void handleAllRowItems(int row, int col) {
		for(int colNo = 0; colNo < GridItem.MAXIMUM_POSSIBLE_VALUE; colNo++)
		{
			items[row][colNo].changePossibleValue(items[row][col].value(), false);
		}
	}

	private void handleAllColumnItems(int row, int col) {
		for(int rowNo = 0; rowNo < GridItem.MAXIMUM_POSSIBLE_VALUE; rowNo++)
		{
			items[rowNo][col].changePossibleValue(items[row][col].value(), false);
		}
	}

	private void initializeBoard() {
		for(int row = 0; row < LENGTH; row++)
		{
			for(int col = 0; col < WIDTH; col++)
			{
				items[row][col] = new GridItem();
			}
		}
	}

	private void initializeValues(int[] gridNumbers) {
		for(int row = 0; row < LENGTH; row++)
		{
			for(int col = 0; col < WIDTH; col++)
			{
				items[row][col].setValue(gridNumbers[obtainSequenceNumber(row, col)]);
			}
		}
	}

	private int obtainSequenceNumber(int row, int col) {
		return row * GridItem.MAXIMUM_POSSIBLE_VALUE + col;
	}
	
	public int getNumbers()
	{
		return -1;
	}
	
	public GridItem[][] getState()
	{
		return items;
	}

}
