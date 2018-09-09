/**
 * 
 * https://leetcode.com/problems/rotate-array/ Rotate an array of n elements to
 * the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * [show hint]
 * 
 * Related problem: Reverse Words in a String II
 * 
 * Credits: 189. Rotate Array
 * 
 * @author abhigupta
 *
 */
public class RotateArray {

	public void rotate(int[] nums, int k) {

		if (k == 0) {
			return;
		}
		if (k > nums.length) {
			k = k - nums.length;
		}
		int l = nums.length - 1;
		reverse(nums, 0, l - k);
		reverse(nums, l - k + 1, l);
		reverse(nums, 0, l);
	}

	void reverse(int nums[], int l, int r) {

		int t = 0;
		while (l < r) {

			t = nums[l];
			nums[l] = nums[r];
			nums[r] = t;
			l++;
			r--;

		}

	}

}
