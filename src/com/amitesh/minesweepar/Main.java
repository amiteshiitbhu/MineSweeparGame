package com.amitesh.minesweepar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {

		Board board = readBoard();
		if (board != null) {
			int option = readInt("1.Resume ? ");
			if (option == 1) {
			} else {
				board = new Board(10, 10);
				board.fillBomb(10);
				board.fillNumbers();
			}
		} else {
			board = new Board(10, 10);
			board.fillBomb(10);
			board.fillNumbers();
		}

		board.printBoard();

		while (true) {

			int row = readInt("Enter row value");

			int col = readInt("Enter column value");

			if (board.isValidIndex(row, col)) {
				board.openCell(row, col);
				board.printBoard();
			} else {
				System.out.println("Please Enter Valid Index");
			}
			if (board.isWin()) {
				System.out.println("Woohh !!! You Won the Game");
				break;
			}

			if (board.isLost()) {
				System.out.println("Better Luck Next Time !!! Try New Game");
				break;
			}
			int option = readInt("1.save \n 2.Continue \n 3.exit");
			if (option == 1) {
				save(board);
				break;
			}
		}

	}

	private static Board readBoard() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new FileInputStream(new File(
							"C:\\Users\\Amitesh\\Desktop\\MineSweepar.txt")));
			Object obj = objectInputStream.readObject();
			return (Board) obj;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void save(Board board) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream(new File(
							"C:\\Users\\Amitesh\\Desktop\\MineSweepar.txt")));
			objectOutputStream.writeObject(board);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int readInt(String message) {
		System.out.println(message);
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));

		String string = null;
		try {
			string = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
		}
		return -1;

	}

}
