/**
 * https://leetcode.com/problems/3sum-closest/
 * 16. 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
import java.util.Arrays;

public class SumClosest3 {

	public int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length < 3) {
			return 0;
		}

		Arrays.sort(nums);
		int minValue = Integer.MAX_VALUE;
		int actualV = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {

			int f = nums[i];
			int r = nums.length - 1;
			int l = i + 1;

			while (l < r) {// was(l != r)

				int diff = f + nums[r] + nums[l] - target;
				if (diff == 0) {
					return target;
				}
				minValue = Math.min(minValue, Math.abs(diff));
				if (minValue == Math.abs(diff)) {
					actualV = diff;
				}

				if (diff > 0) {
					r--;
				} else {
					l++;
				}
			}
		}
		return target + actualV;

	}

}
