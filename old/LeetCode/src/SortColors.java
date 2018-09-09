/**
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem. 75. Sort Colors
 * 
 * PG, MS, FB
 * @author abhigupta https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

	public void sortColors(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}
		int r = 0;
		int b = nums.length - 1;
		int i = 0;
		while (i <= b) {

			if (nums[i] == 0) {
				swap(nums, i++, r++);
			} else if (nums[i] == 2) {
				swap(nums, i, b--);
			} else {
				i++;
			}

		}

	}

	void swap(int nums[], int r, int b) {

		int t = nums[r];
		nums[r] = nums[b];
		nums[b] = t;

	}

}
