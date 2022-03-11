import java.io.*;
public class i_love_recursion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));			
			int n = Integer.parseInt(in.readLine());
			for(int i = 0; i < n;  i++) {
				int row = Integer.parseInt(in.readLine());
				int col = Integer.parseInt(in.readLine());
				int [][] arr = new int [row][col];
				for(int j = 0; j < row; j++) {
					String [] split = in.readLine().split(" ");
					for(int k = 0; k < col; k++) {
						arr[j][k] = Integer.parseInt(split[k]);
					}
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("INVALID. File is not found");
		}
	}
	
	public static void shortest (int [][] arr, int row, int col){
		
		if(arr[0].length - 1 == row && col == 0) {
			return;
		}
		if(row > arr[0].length || col > 0) {
			return;
		}
		return shortest([][] arr, row+1, col-1);
	}

}
