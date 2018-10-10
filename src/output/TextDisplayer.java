package output;

import base.Board;
import base.Displayer;
import base.GridItem;

public class TextDisplayer implements Displayer {

	Board board;
	
	public TextDisplayer() {
		super();
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}
	
	@Override
	public void display() {
		GridItem[][] gridItems = board.getState();
		System.out.println(formSudokuString(gridItems));
	}

	private String formSudokuString(GridItem[][] gridItems) {
		String sudokuString = "";
		for(int row = 0; row < Board.LENGTH; row++)
		{
			sudokuString += formEntrireRow(gridItems,row);
		}
		return sudokuString;
	}

	private String formEntrireRow(GridItem[][] gridItems, int row) {
		String sudokuString = formRowGridSeperator(row);
		for(int col = 0; col < Board.WIDTH; col++)
		{
			sudokuString += formColGridSeperator(col);
			sudokuString += gridItems[row][col].value();
		}
		sudokuString += formRowEnding();
		return sudokuString;
	}

	private String formRowEnding() {
		return "|\n";
	}

	private String formRowGridSeperator(int row) {
		return (row % 3 == 0) ? "------------\n" : "";
	}

	private String formColGridSeperator(int col) {
		return col % 3 == 0 ? "|" : "";
	}
}
