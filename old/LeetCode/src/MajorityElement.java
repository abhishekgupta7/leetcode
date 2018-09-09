/***
 * https://leetcode.com/problems/majority-element/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.

You may assume that the array is non-empty and the majority element always exist in the array.
 * 169. Majority Element
 * @author abhigupta
 *
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if(nums == null || nums.length ==0) {
            return 0;
        }
        int c = 1;
        int mx = nums[0];
        
        for(int i = 1;i<nums.length;i++) {
            
            if(nums[i] != mx) {
                c--;
            }else{
                c++;
            }
            if(c ==0) {
                c  =1;
                mx = nums[i];
            }
            
            
        }
        
        
        return mx;
    }

}
