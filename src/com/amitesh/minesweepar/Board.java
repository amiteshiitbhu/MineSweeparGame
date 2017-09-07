package com.amitesh.minesweepar;


import java.io.Serializable;
import java.util.Random;

public class Board implements Serializable{

	private static final int BOMB = -1;
	int[][] cells;
	boolean[][] open;

	public Board(int row, int col) {
		this.cells = new int[row][col];
		this.open = new boolean[row][col];

	}

	public void fillBomb(int numOfBomb) {

		Random r = new Random();

		for (int k = 0; k < numOfBomb; k++) {
			int i = r.nextInt(cells.length);
			int j = r.nextInt(cells[0].length);
			cells[i][j] = BOMB;
		}

	}

	public void print() {

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				System.out.print(cells[i][j] >= 0 ? "  " + cells[i][j] : " "
						+ cells[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void fillNumbers() {

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j] == -1) {
					continue;
				}
				int count = 0;
				// System.out.println("check1");
				// loop for middle term
				if ((i >= 1 && i <= cells.length - 2)
						&& (j >= 1 && j <= cells.length - 2)) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 2; l2++, x++) {
						for (int m = l, y = 0; y <= 2; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for left corner;
				if (i == 0 && j == 0) {
					int k = i;
					int l = j;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the right corner
				if (i == 0 && j == cells[0].length - 1) {
					int k = i;
					int l = j;
					k = k;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the bottom corner
				if (i == cells.length - 1 && j == 0) {
					int k = i;
					int l = j;
					k--;
					l = l;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the right bottom corner
				if (i == cells.length - 1 && j == cells[0].length - 1) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// for top first line
				if (i == 0 && (j >= 1 && j <= cells.length - 2)) {
					int k = i;
					int l = j;
					k = k;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 2; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for left first line
				if ((i >= 1 && i <= cells.length - 2) && j == 0) {
					int k = i;
					int l = j;
					k--;
					l = l;
					for (int l2 = k, x = 0; x <= 2; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the right line
				if ((i >= 1 && i <= cells.length - 2) && j == cells.length - 1) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 2; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the bottom line
				if (i == cells.length - 1 && (j >= 1 && j <= cells.length - 2)) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 2; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (cells[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}

				cells[i][j] = count;

			}

		}
	}

	public void printBoard() {
		for (int i = 0; i < cells[0].length; i++) {
			System.out.print(" _ _");
		}
		System.out.println();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length + 1; j++) {
				System.out.print("|");
				if (j != cells[0].length) {
					if (open[i][j]) {
						System.out.print("_"
								+ (cells[i][j] == 0 ? " "
										: cells[i][j] == BOMB ? "B"
												: cells[i][j]) + "_");
					} else {
						System.out.print("_*_");
					}
				}

			}
			System.out.println();
		}

	}

	public void openCell(int row, int col) {

		// open[row][col] = true;

		if (cells[row][col] == BOMB) {
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {
					if (cells[i][j] == BOMB) {
						open[i][j] = true;
					}
				}
			}
		}

		if (cells[row][col] >= 1 && cells[row][col] <= 9) {
			open[row][col] = true;
		}

		if (cells[row][col] == 0) {
			openZero(row, col);

		}

	}

	private void openZero(int row, int col) {

		if (cells[row][col] == 0 && open[row][col] == false) {
			open[row][col] = true;

			if (row - 1 >= 0 /* && cells[row - 1][col] == 0 */) {
				// open[row - 1][col] = true;
				openZero(row - 1, col);

			}
			if (row + 1 < cells.length /* && cells[row + 1][col] == 0 */) {
				// open[row + 1][col] = true;
				openZero(row + 1, col);

			}
			if (col - 1 >= 0 /* && cells[row][col - 1] == 0 */) {
				// open[row][col - 1] = true;
				openZero(row, col - 1);

			}
			if (col + 1 < cells[0].length /* && cells[row][col + 1] == 0 */) {
				// open[row][col + 1] = true;
				openZero(row, col + 1);

			}
			if (row - 1 >= 0 && col - 1 >= 0 && cells[row - 1][col - 1] != 0) {
				openZero(row - 1, col - 1);
			}
			if (row - 1 >= 0 && col + 1 < cells[0].length
					&& cells[row - 1][col + 1] != 0) {
				openZero(row - 1, col + 1);
			}
			if (row + 1 < cells.length && col - 1 >= 0
					&& cells[row + 1][col - 1] != 0) {
				openZero(row + 1, col - 1);
			}
			if (row + 1 < cells.length && col + 1 < cells[0].length
					&& cells[row + 1][col + 1] != 0) {
				openZero(row + 1, col + 1);
			}

		} else if (cells[row][col] != BOMB) {
			open[row][col] = true;
		}

	}

	public boolean isValidIndex(int row, int col) {
		if (row >= 0 && row < cells.length && col >= 0 && col < cells[0].length) {
			return true;
		}
		return false;
		
		
	}

	public boolean isWin() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j] != BOMB && open[i][j] == false) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isLost() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j]==-1 && open[i][j]==true) {
					return true;
				}
			}
		}
		return false;
			
		}
	
	
}
