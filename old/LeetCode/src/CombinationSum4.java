import java.util.Arrays;


/* 377
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 *  Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

		Example:
		
		nums = [1, 2, 3]
		target = 4
		
		The possible combination ways are:
		(1, 1, 1, 1)
		(1, 1, 2)
		(1, 2, 1)
		(1, 3)
		(2, 1, 1)
		(2, 2)
		(3, 1)
		
		Note that different sequences are counted as different combinations.
		
		Therefore the output is 7.

 * 
 */
public class CombinationSum4 {
	
	// top-down

    public int combinationSum4(int[] nums, int target) {
        
        if(nums == null || nums.length ==0 || target ==0 ) {
            return 0;
        }
        
        int dp[] = new int[target+1];
        Arrays.sort(nums);
        Arrays.fill(dp,-1);
        dp[0] =1;
        return helper(nums, target, dp);
    }
    
    private int helper(int []nums, int t, int dp[]) {
        
        if(t<0) {
            return 0;
        }
        if(dp[t] != -1) {
            return dp[t];
        }
         dp[t] = 0;
        for(int i =0;i<nums.length;i++) {
            
            dp[t] += helper(nums,t-nums[i],dp);
        }
        
        return dp[t];
        
    }
    
    
    /*  Bottom Up
     * 
     * For example, given nums = [100], target = 100, the top-down approach will get the result directly, while the bottom-up has to build comb[1] all the way to comb[100].
   
public int combinationSum4(int[] nums, int target) {
        
         int[] comb = new int[target + 1];
        comb[0] = 1;
        
        Arrays.sort(nums);

        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }else {
                    break;
                }
            }
        }
        return comb[target];
        
        
    }
    
    */
 

}
