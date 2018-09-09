import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/
 * 
 *  Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)

Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]

Credits:
Special thanks to @Stomach_ache for adding this problem and creating all test cases.


 * @author abhigupta
 *
 */
public class LargestDivisibleSubset {
	

    public List<Integer> largestDivisibleSubset(int[] nums) {
                List<Integer> ans = new LinkedList<>();

        if( nums == null || nums.length ==0 ) {
            return ans;
        }
        
        Arrays.sort(nums);
        
        int count[] = new int [nums.length];
        int p[] = new int [nums.length];
        int max = 0;
        int st = 0;
        for(int i=0; i<nums.length ;i++) {
            count[i] =1;
            p[i] = -1;
            for(int j =i-1 ;j>=0 ;j--) {
                
                if(nums[i] % nums[j] ==0 ) {
                    count[i] = Math.max(count[i],count[j]+1);
                   
                    if(count[i] == count[j]+1) {
                        p[i] = j;
                    }
                    
                }
                
                max = Math.max(max, count[i]);
                if(max == count[i]) {
                    st = i;
                }
            }

        }
        

        while(st != -1) {
            ans.add(nums[st]);
            st = p[st];
        }
        
       
            return ans;
        }


}
