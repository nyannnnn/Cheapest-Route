
//******************************************************************
//Name: Max Luo
//Date: 3/12/2022
//Description: This program reads a text file named input.txt and outputs the cheapest route it takes to traverse through the grid given 
//******************************************************************
import java.io.*;

public class i_love_recursion {

	// initializing global variables
	public static int cost = Integer.MAX_VALUE;
	public static String Lroute = "";
	public static String Ldirection = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Finding the Cheapest Routes: \n");
		try {
			BufferedReader inLine = new BufferedReader(new FileReader("input.txt"));
			int n = Integer.parseInt(inLine.readLine());
			// main loop for number of grids
			for (int i = 0; i < n; i++) {
				int row = Integer.parseInt(inLine.readLine());
				int col = Integer.parseInt(inLine.readLine());
				cost = Integer.MAX_VALUE;
				Lroute = "";
				Ldirection = "";

				// initialization
				String[] route = new String[row + col - 1];
				String[] direction = new String[route.length - 1];
				int[][] arr = new int[row][col];

				// reading inLine the data
				for (int j = 0; j < row; j++) {
					String[] split = inLine.readLine().split(" ");
					for (int k = 0; k < col; k++) {
						arr[j][k] = Integer.parseInt(split[k]);
					}
				}
				// printing out the array
				System.out.println("Grid #" + (i + 1));
				for (int j = 0; j < row; j++) {
					for (int k = 0; k < col; k++) {
						System.out.print(arr[j][k] + " ");
					}
					System.out.println();
				}
				// recursion woowoo!!!
				path(arr, row - 1, 0, 0, route, 0, direction);
				System.out.println("Cheapest Route: " + Lroute);
				System.out.println("Directions: " + Ldirection);
				System.out.println("Cheapest Cost: $" + cost);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("INVALID. File is not found");
		}
		System.out.println("Program is Complete");
	}

	// Description: outputs the cheapest path it takes to traverse through the gird
	// parameters: the grid, the current row and col the index is inLine, the sum,
	// the route it took, the direction it took, and the index of the route
	// return: nothing because the method is void
	public static void path(int[][] arr, int row, int col, int sum, String[] route, int i, String[] direction) {

		sum += arr[row][col];

		// base case
		if (col == arr[0].length - 1 && row == 0) {
			route[i] = arr[row][col] + " ";
			// if the current route's sum is smaller than the previous one
			if (cost > sum) {
				Lroute = "";
				Ldirection = "";
				cost = sum;
				// outputting to cheapest route
				for (int n = 0; n < route.length; n++) {
					Lroute += route[n];
				}
				for (int n = 0; n < route.length - 1; n++) {
					Ldirection += direction[n];
				}

			}
			return;
		}

		// check if can go up
		if (row != 0) {
			route[i] = arr[row][col] + " ";
			direction[i] = "NORTH ";
			path(arr, row - 1, col, sum, route, i + 1, direction);
		}
		// checking if can go right
		if (col != arr[0].length - 1) {
			route[i] = arr[row][col] + " ";
			direction[i] = "EAST ";
			path(arr, row, col + 1, sum, route, i + 1, direction);
		}
	}

}
