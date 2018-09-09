/**
 * 
 * https://leetcode.com/problems/power-of-three/ 326. Power of Three Given an
 * integer, write a function to determine if it is a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 * 
 * Credits: Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 * 
 * @author abhigupta
 *
 */
public class PowerofThree {

	public boolean isPowerOfThree(int n) {

		if (n == 1) {
			return true;
		}

		if (n <= 0 || n % 3 != 0) {
			return false;
		}

		return isPowerOfThree(n / 3);

	}

}
