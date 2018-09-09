/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 329 Longest Increasing Path in a Matrix
 * 
 * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * @author abhigupta
 *
 */
public class LongestIncreasingPathinaMatrix {
	

	int mat[][] ;
	int gMax = 0;
	
  public int longestIncreasingPath(int[][] matrix) {
        
	  
	  
	  if(matrix == null || matrix.length ==0 || matrix[0] == null ||matrix[0].length ==0 ) {
		  return 0;
	  }
	  mat = new int[matrix.length] [matrix[0].length];
	  
	  
	  
	   for(int r =0 ;r<mat.length;r++) {
		 
		  
		  for(int c =0 ;c<mat[0].length;c++) {
    
                getMax(r,c,matrix);
		  }
	   }
      
	  return gMax;
  }
  
  
  public int getMax( int i, int j,int matrix[][]) {
	  
	  
	  if(i <0 || j<0 || i>mat.length-1 || j>mat[0].length-1) {
		  return -1;
	  }
	  
	  if(mat[i][j] != 0 ) {
		  return mat[i][j] ;
	  }
	 //System.out.println(mat[r][c] );
        int r =i;
        int c =j;
	  int max = 0;
	  //for(int r =i ;r<mat.length;r++) {
		 
		  
		//  for(int c =j ;c<mat[0].length;c++) {
			  max = 0;
			  
			
			  
			  if(r>0 && matrix[r-1][c]>matrix[r][c]) {
				  max = Math.max(max,getMax( r-1, c, matrix));
			  }
			  
			  if(c>0 && matrix[r][c-1]>matrix[r][c]) {
				  max = Math.max(max,getMax( r, c-1, matrix));
			  }
			  if(c<mat[0].length-1 && matrix[r][c+1]>matrix[r][c]) {
				  max = Math.max(max,getMax( r, c+1, matrix));
			  }
			  
			  if(r<mat.length-1 && matrix[r+1][c]>matrix[r][c]) {
				  max = Math.max(max,getMax( r+1, c, matrix));
			  }
			  mat[r][c] = max+1;
			  gMax = Math.max(mat[r][c], gMax);
//		  }
//	  }
	  
	  return mat[i][j];
	  
	  
	  
  }
    
    


}
