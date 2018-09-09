/**https://leetcode.com/problems/jump-game-ii/
 * 45. Jump Game II
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 * @author abhigupta
 *
 */
public class JumpGame2 {

	public int jump(int[] nums) {

		return jumpFind(nums);

	}

	public int jumpFind(int nums[]) {

		int count = 0;

		if (nums == null || nums.length < 2) {
			return 0;
		}
		int l = 1;
		int r = nums[0];
		int max = 0;
		int nl = 0;
		while (true) {

			if (r >= nums.length - 1) {
				return count + 1;
			}
			max = 0;
			for (; l <= r; l++) {

				max = Math.max(max, l + nums[l]);
				if (max == l + nums[l]) {
					nl = l;
				}
			}
			l = nl;
			r = max;
			count++;
		}

	}

}
