/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 * @author abhigupta
 *
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:

Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.

Note:
nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).


 */
public class MaximumSum3NonOverlappingSubarrays {

	public int[] maxSumOfThreeSubarrays1(int[] nums, int K) {
		// W is an array of sums of windows
		int[] W = new int[nums.length - K + 1];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= K)
				sum -= nums[i - K];
			if (i >= K - 1)
				W[i - K + 1] = sum;
		}

		int[] left = new int[W.length];
		int best = 0;
		for (int i = 0; i < W.length; i++) {
			if (W[i] > W[best])
				best = i;
			left[i] = best;
		}

		int[] right = new int[W.length];
		best = W.length - 1;
		for (int i = W.length - 1; i >= 0; i--) {
			if (W[i] >= W[best])
				best = i;
			right[i] = best;
		}

		int[] ans = new int[] { -1, -1, -1 };
		for (int j = K; j < W.length - K; j++) {
			int i = left[j - K], k = right[j + K];
			if (ans[0] == -1 || W[i] + W[j] + W[k] > W[ans[0]] + W[ans[1]] + W[ans[2]]) {

				ans[0] = i;
				ans[1] = j;
				ans[2] = k;
			}
		}
		return ans;
	}
	
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i=0;i<n;i++) sum[i+1] = sum[i] + nums[i];
        int[] posLeft = new int[n], posRight = new int[n];
        // left start from 0 to n-k to get max sum left interval values
        for(int i=k, total=sum[k]-sum[0]; i<n;i++){
            if(sum[i+1]-sum[i-k+1]>total){
                total = sum[i+1]-sum[i-k+1];
                posLeft[i] = i-k+1;
            }else{
                posLeft[i] = posLeft[i-1];
            }
        }
        
        // right start from 0 to n-k to get max sum right interval values
        posRight[n-k]=n-k;
        for(int i=n-k-1, total=sum[n]-sum[n-k]; i>=0;i--){
            if(sum[k+i]-sum[i]>total){
                total = sum[k+i]-sum[i];
                posRight[i] = i;
            }else{
                posRight[i] = posRight[i+1];
            }
        }
        
        // test all middle interval
        int maxsum = 0;
        int[] ans = new int[3];
        for(int i=k;i<=n-2*k;i++){
            int l = posLeft[i-1], r = posRight[i+k];
            int total = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if(total>maxsum){
                maxsum = total;
                ans[0]=l; ans[1]=i; ans[2]=r;
            }
        }
        return ans;
    }

	
	public static void main(String st[]) {
		int a[]= {1,2,3,4,5,6};
		System.out.println(new MaximumSum3NonOverlappingSubarrays().maxSumOfThreeSubarrays(a,2));
	}
}
