/**
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * 63. Unique Paths II
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [ [0,0,0], [0,1,0], [0,0,0] ]
 * 
 * The total number of unique paths is 2.
 * 
 * @author abhigupta
 *
 */
public class UnqiuePath2 {

	public int uniquePathsWithObstacles(int[][] a) {

		if (a == null || a.length == 0) {

			return 0;
		}

		int n = a[0].length;

		int v[] = new int[n];

		if (a[0][0] == 1)
			return 0;

		v[0] = 1;

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < n; j++) {

				if (a[i][j] == 1) {
					v[j] = 0;
				} else if (j > 0) {
					v[j] = v[j - 1] + v[j];
				}
			}
		}

		return v[n - 1];

	}

}
