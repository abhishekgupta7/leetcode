/**
 * https://leetcode.com/problems/sqrtx/ 69. Sqrt(x) Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author abhigupta
 *
 */
public class Sqrt {

	public int mySqrt(int x) {

		if (x < 2) {
			return x;
		}
		int s = 1;
		int e = x;
		int an = 0;
		while (s <= e) {

			int m = s + (e - s) / 2;
			if (m <= x / m) {
				an = m;
				s = m + 1;
			} else {

				e = m - 1;
			}
		}
		return an;
	}

}
