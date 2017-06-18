import java.util.Arrays;

/***
 * https://leetcode.com/problems/longest-increasing-subsequence/#/description
 * 
 *  300. Longest Increasing Subsequence 
 * @author abhigupta
 * #Todo
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int m[] = new int[nums.length];
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {

				if (nums[j] < nums[i]) {
					max = Math.max(max, m[j] + 1);
				}

			}
			m[i] = max;
			ans = Math.max(ans, max);
		}
		return ans;
	}
	
	public int lengthOfLIS2(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

//readhttps://www.youtube.com/watch?v=1RpMc3fv0y4
    
    

}
