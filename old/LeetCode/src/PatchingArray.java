import java.util.ArrayList;
import java.util.List;

/***
 * 
 * Given a sorted positive integer array nums and an integer n, add/patch
 * elements to the array such that any number in range [1, n] inclusive can be
 * formed by the sum of some elements in the array. Return the minimum number of
 * patches required.
 * 
 * Example 1: nums = [1, 3], n = 6 Return 1.
 * 
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3,
 * 4. Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3],
 * [2,3], [1,2,3]. Possible sums are 1, 2, 3, 4, 5, 6, which now covers the
 * range [1, 6]. So we only need 1 patch.
 * 
 * Example 2: nums = [1, 5, 10], n = 20 Return 2. The two patches can be [2, 4].
 * 
 * Example 3: nums = [1, 2, 2], n = 5 Return 0.
 * 
 * Credits: Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 * This solution is based on greedy method.
For example, if you have 1, 2, it can reach 2+(2-1) = 3. So when we want to add up to 4, we have to add 4 into the list. And 1,2,4 can reach to 4+(4-1).
Similarly, for any added number n, they can add up to n+(n-1) without missing one number.
If there is one number x which satisfies n < x < n+(n-1), then we don't have to worry about the numbers until x + n + n - 1. Repeatedly evaluate the next number that the list of numbers can reach to, and add into the list next one when missing.
So basically this method is <log(n) time complexity and O(1) space complexity.
 * 
 * https://leetcode.com/problems/patching-array/ 330. Patching Array
 * 
 * @author abhigupta
 *
 */
public class PatchingArray {

	List<Integer> list = new ArrayList<Integer>();

	public int minPatches(int[] nums, int n) {

		long miss = 1;
		int i = 0;
		int added = 0;
		while (miss <= n) {

			if (i < nums.length && nums[i] <= miss) {

				miss += nums[i++];

			} else {
				added++;
				System.out.println(miss);
				miss += miss;

			}

		}
		return added;

	}

}
