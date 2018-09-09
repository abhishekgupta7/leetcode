/**
 * 
 * https://leetcode.com/problems/house-robber/ 198. House Robber You are a
 * professional robber planning to rob houses along a street. Each house has a
 * certain amount of money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were
 * broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author abhigupta
 *LinkedIn Airbnb
 */
public class HouseRobber {

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		return getMaxMoney(0, nums.length - 1, nums);
	}

	public int getMaxMoney(int s, int e, int[] nums) {

		int choose[] = new int[2];

		choose[0] = 0;
		choose[1] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int cur[] = new int[2];
			cur[1] = choose[0] + nums[i];
			// cur[0] = Math.max(choose[0],choose[1]);//[4,2,1,10]
			cur[0] = choose[1];

			choose = cur;

		}

		return Math.max(choose[0], choose[1]);
	}

}
