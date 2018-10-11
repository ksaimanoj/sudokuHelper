package solver;

import java.util.ArrayList;
import java.util.List;

import base.Board;
import base.GridItem;
import base.Solver;

public class SimpleSolver implements Solver {

	@Override
	public Board solve(Board board) {
		Board newBoard = new Board();

		int count = 0;
		do {
			GridItem[][] items = board.getState();
			for (int row = 0; row < Board.LENGTH; row++) {
				for (int col = 0; col < Board.WIDTH; col++) {
					if (items[row][col].isValueKnown()) {
						int gridNo = getGridNumber(row, col);
						board.removeValueFromRow(row, items[row][col].value());
						board.removeValueFromColumn(col,
								items[row][col].value());
						board.removeValueFromBoard(gridNo,
								items[row][col].value());
					}
				}
			}

			count = 0;

			List<Integer>[][] possibilityMatrix = new ArrayList[Board.LENGTH][Board.WIDTH];
			for (int row = 0; row < Board.LENGTH; row++) {
				for (int col = 0; col < Board.WIDTH; col++) {
					if (!items[row][col].isValueKnown()) {
						List<Integer> possibleValues = items[row][col]
								.getPossibleValues();
						possibilityMatrix[row][col] = possibleValues;
					}
				}
			}

			for (int row = 0; row < Board.LENGTH; row++) {
				for (int value = 0; value < GridItem.MAXIMUM_POSSIBLE_VALUE; value++) {
					int possibleCount = 0;
					int possibelColumn = 0;
					for (int col = 0; col < Board.WIDTH; col++) {
						if (!items[row][col].isValueKnown()) {
							if (possibilityMatrix[row][col].contains(value)) {
								possibleCount++;
								possibelColumn = col;
							}
						}
					}
					if (possibleCount == 1) {
						items[row][possibelColumn].setValue(value);
						count++;
						System.out.print("row: " + row);
						System.out.print(" col: " + possibelColumn);
						System.out.println(" possibleValues: " + value);
					}
				}
			}

			for (int col = 0; col < Board.WIDTH; col++) {
				for (int value = 0; value < GridItem.MAXIMUM_POSSIBLE_VALUE; value++) {
					int possibleCount = 0;
					int possibleRow = 0;
					for (int row = 0; row < Board.LENGTH; row++) {
						if (!items[row][col].isValueKnown()) {
							if (possibilityMatrix[row][col].contains(value)) {
								possibleCount++;
								possibleRow = row;
							}
						}
					}
					if(possibleCount == 1)
					{
						items[possibleRow][col].setValue(value);
						count++;
						System.out.print("row: " + possibleRow);
						System.out.print(" col: " + col);
						System.out.println(" possibleValues: " + value);
					}
				}
			}

			/*
			 * for (int row = 0; row < Board.LENGTH; row++) { for (int col = 0;
			 * col < Board.WIDTH; col++) { if (!items[row][col].isValueKnown())
			 * { List<Integer> possibleValues = items[row][col]
			 * .getPossibleValues(); if (possibleValues.size() == 1) { count++;
			 * items[row][col].setValue(possibleValues.get(0));
			 * System.out.print("row: " + row); System.out.print(" col: " +
			 * col); System.out.println( " possibleValues: " + possibleValues);
			 * } } } }
			 */
			System.out.println("count: " + count);
		} while (count > 0);

		newBoard.setState(board.getState());
		return newBoard;
	}

	private int getGridNumber(int row, int col) {
		return row / 3 * 3 + col / 3 + 1;
	}

}
