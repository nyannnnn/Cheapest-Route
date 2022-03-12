import java.io.*;
public class i_love_recursion {

	public static int cost = Integer.MAX_VALUE;
	public static String Lroute = "";
	public static String Ldirection = "";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Finding the Cheapest Routes: \n");
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));			
			int n = Integer.parseInt(in.readLine());
			for(int i = 0; i < n;  i++) {
				int row = Integer.parseInt(in.readLine());
				int col = Integer.parseInt(in.readLine());
				cost = Integer.MAX_VALUE;
				Lroute = "";
				Ldirection = "";
				
				//initalization
				String [] route = new String[row+col-1];
				String [] direction = new String[route.length-1];
				int [][] arr = new int [row][col];
				
				//reading in the data
				for(int j = 0; j < row; j++) {
					String [] split = in.readLine().split(" ");
					for(int k = 0; k < col; k++) {
						arr[j][k] = Integer.parseInt(split[k]);
					}
				}
				//printing out the array
				System.out.println("Grid #" + (i+1));
				for(int j = 0; j < row; j++) {
					for(int k = 0; k < col; k++) {
						System.out.print(arr[j][k] + " ");
					}
					System.out.println();
				}
				//recursion woowoo
				path(arr, row-1, 0, 0, route, 0, direction);
				System.out.println("Cheapest Route: " + Lroute);
				System.out.println("Directions: " + Ldirection);
				System.out.println("Cheapest Cost: $" + cost);
				System.out.println();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("INVALID. File is not found");
		}
		System.out.println("Program is Complete");
	}
	
	public static void path (int [][] arr, int row, int col, int sum, String [] route, int i, String [] direction){
		
		sum+= arr[row][col];
		
		//base case		
		if(col == arr[0].length-1 && row == 0) {
			route[i] = arr[row][col] + " ";
			if(cost > sum) {
				cost = sum;
				for (int n = 0; n < route.length; n++) {
					Lroute += route[n];
				}
				for (int n = 0; n < route.length-1; n++) {
					Ldirection += direction[n];
				}
				
			}
			return;
		}
		
		//check if can go up
		if(row != 0) {
			route[i] = arr[row][col] + " ";
			direction[i] = "NORTH ";
			path(arr, row-1, col, sum, route, i+1, direction);
		}
		//checking if can go right
		if(col != arr[0].length-1){
			route[i] = arr[row][col] + " ";
			direction[i] = "EAST ";
			path(arr, row, col+1, sum, route, i+1, direction);
		}
		
	}

}
