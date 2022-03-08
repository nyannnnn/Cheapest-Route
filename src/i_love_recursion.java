import java.io.*;
public class i_love_recursion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));			
			int n = Integer.parseInt(in.readLine());
			for(int i = 0; i < n;  i++) {
				int x = Integer.parseInt(in.readLine());
				int y = Integer.parseInt(in.readLine());
				int [][] arr = new int [x][y];
				for(int j = 0; j < x; j++) {
					String [] split = in.readLine().split(" ");
					for(int k = 0; k < y; k++) {
						arr[j][k] = Integer.parseInt(split[k]);
					}
				}
				System.out.println(arr[0].length);
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("INVALID. File is not found");
		}
		
	}
	
	public static void shortest (int [][] arr, int x, int y){
		
		if(arr[0].length - 1 == x && y == 0) {
			return;
		}
		if(x > arr[0].length || y > 0) {
			return;
		}
		return shortest([][] arr, x+1, y-1);
	}

}
