import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/unique-paths/
 * https://leetcode.com/problems/unique-paths/ 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author abhigupta
 *
 */
public class UniquePath {

	public int uniquePaths(int m, int n) {

		int cal[] = new int[n];

		Arrays.fill(cal, 1);

		for (int i = 1; i < m; i++) {
			int next[] = new int[n];
			next[0] = 1;
			for (int j = 1; j < n; j++) {
				next[j] = next[j - 1] + cal[j];

			}
			cal = next;

		}
		return cal[n - 1];

	}

}
