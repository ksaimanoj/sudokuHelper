package base;

public class Board {
	
	public static final int LENGTH = 9;
	public static final int WIDTH = 9;
	
	GridItem[][] items;
	
	public Board(int[] gridNumbers) {
		items = new GridItem[LENGTH][WIDTH];
		initializeBoard();
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
	
	public int getNumbers()
	{
		return -1;
	}

}
