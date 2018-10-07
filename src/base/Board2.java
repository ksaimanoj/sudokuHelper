package base;

public class Board2 {

	public static final int LENGTH = 9;
	public static final int WIDTH = 9;

	GridItem[][] items;

	public Board2() {
		items = new GridItem[LENGTH][WIDTH];
	}

	public GridItem[][] getState() {
		return items;
	}

	public void setState(int[] gridNumbers) {
		for(int row = 0; row < Board2.LENGTH; row++)
		{
			for(int col = 0; col < Board2.WIDTH; col++)
			{
				items[row][col] = new GridItem();
				items[row][col].setValue(gridNumbers[row * Board2.LENGTH + col]);
			}
		}
			
	}

}
