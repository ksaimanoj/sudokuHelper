package output;

import base.Board;
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
		String sudokuString = "";
		GridItem[][] gridItems = board.getState();
		
	}


}
