/**
 * 279. Perfect Squares
 * 
 * https://leetcode.com/problems/perfect-squares/ Given a positive integer n,
 * find the least number of perfect square numbers (for example, 1, 4, 9, 16,
 * ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 * 
 * Credits: Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases. https://leetcode.com/problems/perfect-squares/
 * 
 * @author abhigupta #Google
 */
public class PerfectSquares {

	public int numSquares(int n) {

		int a[] = new int[n + 1];
		a[1] = 1;
		for (int i = 2; i <= n; i++) {
			
			a[i] = Integer.MAX_VALUE;
			int upper = (int) Math.sqrt(i);
			if (i == upper * upper) {
				a[i] = 1;
				continue;
			}
			for (int j = 1; j <= upper; j++) {
				a[i] = Math.min(a[i], 1 + a[i - j * j]);
			}
		}
		return a[n];

	}

}
