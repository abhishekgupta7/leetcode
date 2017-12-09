import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-triangle-number/description/
 * 
 * @author abhigupta
 * 
 *         Given an array consists of non-negative integers, your task is to
 *         count the number of triplets chosen from the array that can make
 *         triangles if we take them as side lengths of a triangle.
 * 
 *         Example 1:
 * 
 *         Input: [2,2,3,4] Output: 3 Explanation: Valid combinations are: 2,3,4
 *         (using the first 2) 2,3,4 (using the second 2) 2,2,3
 * 
 *         Note:
 * 
 *         The length of the given array won't exceed 1000. The integers in the
 *         given array are in the range of [0, 1000].
 *
 * 
 */
public class ValidTriangleNumber {
	int binarySearch(int nums[], int l, int r, int x) {
        while (r >= l) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
           
            for (int j = i + 1; j < nums.length && nums[i] != 0; j++) {
                int k = binarySearch(nums, j+1, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }
	
	public static void main(String st[]) {
		
		int a[] = {2,13,14};
		
		System.out.println(new ValidTriangleNumber().triangleNumber(a));
	}
	
	
	 public int triangleNumber2(int[] nums) {
	        int count = 0;
	        Arrays.sort(nums);
	        for (int i = 0; i < nums.length - 2; i++) {
	            int k = i + 2;
	            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0 ; j++) {
	                while (k < nums.length && nums[i] + nums[j] > nums[k])
	                    k++;
	                count += k - j - 1;
	            }
	        }
	        return count;
	    }
	 
	 

}
