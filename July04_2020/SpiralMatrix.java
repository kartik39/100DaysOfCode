import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] mat = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
	}
	
	public static List<Integer> spriralMatrix(int[][] mat, int row, int col) {
		List<Integer> result = new ArrayList<>();
		int i=0, j=0;
		while(row != 0 || col != 0) {
			while(j<col) {
				result.add(mat[i][j]);
				j++;
			}
			++i;
			while(i<row) {
				result.add(mat[i][j]);
				i++;
			}
			j = col - 1;
			
		}
		return result;
	}

}
