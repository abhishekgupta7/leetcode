/**
 * 283. Move Zeroes
 * 
 * https://leetcode.com/problems/move-zeroes/#/description
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * @author abhigupta
 *
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = 0;
		int j = 0;

		while (j < nums.length) {

			if (nums[j] != 0) {
				nums[i++] = nums[j++];
			} else {
				j++;
			}

		}
		while (i < nums.length) {

			nums[i++] = 0;
		}

	}

}
