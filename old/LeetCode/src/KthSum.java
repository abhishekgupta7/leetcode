import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 * 
 * https://leetcode.com/problems/3sum/
 * https://leetcode.com/problems/4sum/
 * @author abhigupta
 *
 */
public class KthSum {

	

    
    
    public static List<List<Integer>> getKSum(int [] nums, int p , int k, int sum) {
  
    List<List<Integer>> l  = new ArrayList<>();
   
    if(k>nums.length-p) {
        return l; 
    }
    
    if(k>2){
        for(int i = p;i<nums.length; i++) {
            
           if( i>p && nums[i-1] == nums[i]) {continue;}
            List<List<Integer>> ll = getKSum(nums, i+1, k-1, sum-nums[i]);
            for(List<Integer> list : ll) {
                list.add(0,nums[i]);
                l.add(list);
         }
        }
        
      
    }else{
        
        int e = nums.length-1;
        while(p<e) {
            
            if(nums[p]+nums[e] ==sum ){
                	List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[p]);
                    list.add(nums[e]);
                
                    p++;
                    e--;
                    l.add(list);
                    while(p<e && nums[p-1] == nums[p]) { p++;}
                    while(p<e && nums[e+1] == nums[e]) { e--;}

            } else if(sum>nums[p]+nums[e]) {
                p++;
            }else{
                e--;
            }
            
        }
        
    }
      return l;
    
}
public List<List<Integer>> fourSum(int[] a, int target) {
    
  
   List<List<Integer>>  list = new ArrayList<List<Integer>> ();
   
    if(a == null || a.length <4) {
        return list;
    } 
   
   Arrays.sort(a);
   
  return getKSum(a,0,4,target);
}

}
