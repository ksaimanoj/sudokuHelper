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
				if(items[row][col].isValueFixed())
					solveIndividualItem(row, col);
			}
		}
	}

	private void solveIndividualItem(int row, int col) {
		handleAllRowItems(row, col);
		handleAllColumnItems(row, col);
	}

	private void handleAllRowItems(int row, int col) {
		for(int colNo = 0; colNo < GridItem.MAXIMUM_POSSIBLE_VALUES; colNo++)
		{
			items[row][colNo].setPossibleValueFalse(items[row][col].getValue());
		}
	}

	private void handleAllColumnItems(int row, int col) {
		for(int rowNo = 0; rowNo < GridItem.MAXIMUM_POSSIBLE_VALUES; rowNo++)
		{
			items[rowNo][col].setPossibleValueFalse(items[row][col].getValue());
		}
	}

	private void initializeBoard() {
		for(int row = 0; row < LENGTH; row++)
		{
			for(int col = 0; col < WIDTH; col++)
			{
				solveIndividualItem(row, col);
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
		return row * GridItem.MAXIMUM_POSSIBLE_VALUES + col;
	}
	
	public int getNumbers()
	{
		return -1;
	}

}
