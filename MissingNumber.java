/**
 * 
 *  268. Missing Number 
 *  https://leetcode.com/problems/missing-number/#/description
 *  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 
 * @author abhigupta
 *
 */
public class MissingNumber {
	

    public int missingNumber(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int m = (len+1)*len;
        m = m/2 ;
        int s = 0;
        for(int i : nums) {
            s= s+i;
        }
        return m -s;
        
    }


}
