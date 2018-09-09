import java.util.HashMap;
import java.util.Map;

/**https://leetcode.com/problems/two-sum/
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
#LinkedIn
#Uber
#Airbnb
#FB
#AMZ
#ALL
 *
 * @author abhigupta
 *
 */


public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        
        if(nums == null || nums.length ==0) {
            return null;
        }
        
        int r[] = new int[2];

        Map<Integer,Integer> map= new HashMap<>();
        
        for(int i =0;i<nums.length;i++) {
            
            int n = nums[i];
            Integer v = map.get(target-n);
            if(v != null) {
                r[0] = v;
                r[1] = i;
                return r;
            }
            map.put(n,i);
            
            
        }
        return r;
        
    }

}
