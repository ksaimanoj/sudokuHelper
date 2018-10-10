package base;

public class Board {

	public static final int LENGTH = 9;
	public static final int WIDTH = 9;

	GridItem[][] items;

	public Board() {
		items = new GridItem[LENGTH][WIDTH];
	}

	public GridItem[][] getState() {
		return items;
	}

	public void setState(int[] gridNumbers) {
		for (int row = 0; row < Board.LENGTH; row++) {
			for (int col = 0; col < Board.WIDTH; col++) {
				items[row][col] = new GridItem();
				items[row][col].setValue(gridNumbers[convertTo2D(row, col)]);
			}
		}
	}

	public int convertTo2D(int row, int col) {
		return row * Board.LENGTH + col;
	}

	public void setState(GridItem[][] items) {
		this.items = items;
	}

	public void removeValueFromRow(int row, int value) {
		for (int col = 0; col < WIDTH; col++)
			items[row][col].changePossibleValue(value, false);
	}

	public void removeValueFromColumn(int column, int value) {
		for (int row = 0; row < LENGTH; row++)
			items[row][column].changePossibleValue(value, false);
	}

	public void removeValueFromBoard(int gridNo, int value) {
		gridNo--;
		int rowStart = (gridNo / 3) * 3;
		int colStart = (gridNo % 3) * 3;
		for (int row = rowStart; row < rowStart + 3; row++) {
			for (int col = colStart; col < colStart + 3; col++) {
				items[row][col].changePossibleValue(value, false);
			}
		}
	}

}
