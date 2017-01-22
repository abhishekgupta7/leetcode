/**
 * 
 * https://leetcode.com/problems/climbing-stairs/
 *  70. Climbing Stairs 
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * @author abhigupta
 *
 */
public class ClimbingStairs {

	public int climbStairs(int n) {

		if (n <= 2) {
			return n;

		}
		int one = 1;
		int two = 2;
		int i = 3;
		while (i <= n) {

			int t = one + two;
			one = two;
			two = t;
			i++;
		}
		return two;

	}

}
