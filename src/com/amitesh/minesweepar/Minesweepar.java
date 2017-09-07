package com.amitesh.minesweepar;

import java.util.Random;

public class Minesweepar {

	public static void main(String[] args) {

		
		Random r = new Random();

		int[][] arr = new int[5][5];

		for (int k = 0; k < 10; k++) {
			int i = r.nextInt(5);
			int j = r.nextInt(5);
			arr[i][j] = -1;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] == 0 ? "  " + arr[i][j] : " "
						+ arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == -1) {
					continue;
				}
				int count = 0;
				// System.out.println("check1");
				// loop for middle term
				if ((i >= 1 && i <= arr.length - 2)
						&& (j >= 1 && j <= arr.length - 2)) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 2; l2++, x++) {
						for (int m = l, y = 0; y <= 2; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
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
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the right corner
				if (i == 0 && j == arr[0].length - 1) {
					int k = i;
					int l = j;
					k = k;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the bottom corner
				if (i == arr.length - 1 && j == 0) {
					int k = i;
					int l = j;
					k--;
					l = l;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the right bottom corner
				if (i == arr.length - 1 && j == arr[0].length - 1) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// for top first line
				if (i == 0 && (j >= 1 && j <= arr.length - 2)) {
					int k = i;
					int l = j;
					k = k;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 2; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for left first line
				if ((i >= 1 && i <= arr.length - 2) && j == 0) {
					int k = i;
					int l = j;
					k--;
					l = l;
					for (int l2 = k, x = 0; x <= 2; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the right line
				if ((i >= 1 && i <= arr.length - 2) && j == arr.length - 1) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 2; l2++, x++) {
						for (int m = l, y = 0; y <= 1; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}
				// loop for the bottom line
				if (i == arr.length - 1 && (j >= 1 && j <= arr.length - 2)) {
					int k = i;
					int l = j;
					k--;
					l--;
					for (int l2 = k, x = 0; x <= 1; l2++, x++) {
						for (int m = l, y = 0; y <= 2; m++, y++) {
							if (!(l2 == i && m == j)) {
								if (arr[l2][m] == -1) {
									count++;
								}
							}
						}
					}
				}

				arr[i][j] = count;

			}

		}
		for (int m = 0; m < arr.length; m++) {
			for (int n = 0; n < arr[0].length; n++) {
				System.out.print(arr[m][n] >= 0 ? "  " + arr[m][n] : " "
						+ arr[m][n]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
