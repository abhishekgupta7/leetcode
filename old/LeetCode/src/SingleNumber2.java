/**
 * 
 * https://leetcode.com/problems/single-number-ii/
 *  Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 * @author abhigupta
 *
 */
public class SingleNumber2 {

	public int singleNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int a[] = new int[32];
		int num = 0;
		for (int i = 0; i < 32; i++) {

			for (int j = 0; j < nums.length; j++) {

				if ((1 & (nums[j] >> i)) == 1) {
					a[i]++;
				}

			}

			num = num | (a[i] % 3 << i);
		}

		return num;

	}

}
