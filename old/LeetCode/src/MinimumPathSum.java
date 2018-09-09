/**
 * 
 * 64. Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * @author abhigupta
 *https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0] == null) {
			return Integer.MAX_VALUE;
		}

		int cal[] = new int[grid[0].length];
		cal[0] = grid[0][0];

		for (int i = 1; i < grid[0].length; i++) {
			cal[i] = grid[0][i] + cal[i - 1];
		}

		for (int i = 1; i < grid.length; i++) {

			int next[] = new int[grid[0].length];
			next[0] = grid[i][0] + cal[0];
			for (int j = 1; j < grid[0].length; j++) {

				next[j] = Math.min(next[j - 1], cal[j]) + grid[i][j];

			}
			cal = next;

		}
		return cal[grid[0].length - 1];

	}

}
