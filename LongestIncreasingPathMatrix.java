
public class LongestIncreasingPathMatrix {
	int mat[][] ;
	int gMax = 0;
	
	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		mat = new int[matrix.length][matrix[0].length];
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[0].length; c++) {
				getMax(r, c, matrix);
			}
		}

		return gMax;
	}
  
  
	public int getMax(int i, int j, int matrix[][]) {

		if (i < 0 || j < 0 || i > mat.length - 1 || j > mat[0].length - 1) {
			return -1;
		}

		if (mat[i][j] != 0) {
			return mat[i][j];
		}
		int r = i;
		int c = j;
		int max = 0;

		max = 0;

		if (r > 0 && matrix[r - 1][c] > matrix[r][c]) {
			max = Math.max(max, getMax(r - 1, c, matrix));
		}

		if (c > 0 && matrix[r][c - 1] > matrix[r][c]) {
			max = Math.max(max, getMax(r, c - 1, matrix));
		}
		if (c < mat[0].length - 1 && matrix[r][c + 1] > matrix[r][c]) {
			max = Math.max(max, getMax(r, c + 1, matrix));
		}

		if (r < mat.length - 1 && matrix[r + 1][c] > matrix[r][c]) {
			max = Math.max(max, getMax(r + 1, c, matrix));
		}
		mat[r][c] = max + 1;
		gMax = Math.max(mat[r][c], gMax);
		

		return mat[i][j];

	}
    
    


}
