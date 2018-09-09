import java.util.TreeSet;

/**
 * 
 * 363. Max Sum of Rectangle No Larger Than K
 * iven a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2

The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

Note:

    The rectangle inside the matrix must have an area > 0.
    What if the number of rows is much larger than the number of columns?

 * https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
 * @author abhigupta
 *
 */
public class MaxSumofRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        
        if(matrix == null || matrix.length ==0 || matrix[0] == null || matrix[0].length ==0) {
            return 0;
        }
        int m = matrix.length;
        int n  = matrix[0].length;
        int dp[] = new int[m];
        int res = Integer.MIN_VALUE;
		for (int l = 0; l < n; l++) { // n

			dp = new int[m];

			for (int r = l; r < n; r++) { // n

				for (int i = 0; i < m; i++) {
					dp[i] += matrix[i][r]; // m
				}

				int max = getConMax(dp, k);// mlog(m)
				res = Math.max(max, res);

			}
		}
        return res;
        
    }
    
    public int getConMax(int dp[], int k) {
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        set.add(0);
        int s =0;
        int max = Integer.MIN_VALUE;
        for(int n : dp) {
            s+= n;
            
            Integer num = set.ceiling(s-k);
            if(num != null) {
                max = Math.max(max, s-num);
            }
            set.add(s);
            
        }
        return max;
        
    }
    
    public static void main(String st[]) {
    	
    	int matrix[][] = new int[][] {{ 1,  0, 1, },{0, -2, 3}};
    	
    	//System.out.println( new MaxSumofRectangleNoLargerThanK().maxSumSubmatrix(matrix, 2));
    	System.out.println( new MaxSumofRectangleNoLargerThanK().getConMax(new int[]{1,10,3,5,7}, 9));

    	        
    }

}
