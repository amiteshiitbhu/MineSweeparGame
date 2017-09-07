package com.amitesh.minesweepar;

public class PrintBoard {
	
 public static void main(String[] args) {
	 
	 int[][] arr = new int[5][5];
	 
	 for (int i = 0; i < arr.length; i++) {
		 System.out.print(" _ _");
	}
	 System.out.println();
	 for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[0].length+1; j++) {
			System.out.print("|");
			if (j!=arr.length) {
				System.out.print("_*_");
			}
			
		}
		System.out.println();
		
		
	}
	
}
}
