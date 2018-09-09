/**
 * 
 * https://leetcode.com/problems/sort-transformed-array/
 * 360. Sort Transformed Array
 * 
 *  Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:

nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]

 * @author abhigupta
 *
 */
public class SortTransformedArray {
	

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
        if(nums == null || nums.length ==0) {
            return null;
        }
        
        int rs [] = new int[nums.length];
        
        if(a>0) {
        int p = nums.length -1;    
            
            int i = 0;
            int j = p;
            
            
            while(i<=j) {
                int l = getValue(nums[i],a,b,c);
                int r = getValue(nums[j],a,b,c);
                 rs[p] = Math.max(l,r);
                if(rs[p] == l) {
                    i++;
                }else {
                    j--;
                }
                p--;
            }
            
            
        } else {
            
            
        int j = nums.length -1;    
            
            int i = 0;
            int p = 0;
            
            
            while(i<=j) {
                int l = getValue(nums[i],a,b,c);
                int r = getValue(nums[j],a,b,c);
                 rs[p] = Math.min(l,r);
                if(rs[p] == l) {
                    i++;
                }else {
                    j--;
                }
                p++;
            }
            
            
        }
        return rs;
    }
    int getValue(int x, int a, int b , int c) {
        
        return a*x*x+b*x+c;
        
        
    }


}
