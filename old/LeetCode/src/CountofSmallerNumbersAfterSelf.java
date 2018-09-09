import java.util.LinkedList;
import java.util.List;

/***
 *  You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Return the array [2, 1, 1, 0]. 
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 315. Count of Smaller Numbers After Self
 * @author abhigupta
 *#Google
 */
public class CountofSmallerNumbersAfterSelf {
	class TreeNode {
	    
	    public int val;
	    public TreeNode left;
	    
	    public TreeNode right;
	    public int smaller;
	    public TreeNode(int v) {
	        val = v ;
	    }
	    
	}


	public class Solution {
	    
	    public List<Integer> countSmaller(int[] nums) {
	        
	        List<Integer> list = new LinkedList<Integer>();
	        
	        if(nums == null || nums.length == 0 ) {
	            return list;
	        }
	        
	        TreeNode root = null;
	        for(int i = nums.length -1;i>=0 ;i--){
	            
	            root = add(nums[i], root, 0, list);
	            
	        }
	        
	        return list;
	        
	    }
	    TreeNode add(int node, TreeNode root, int smaller, List<Integer> list) {
	        
	        
	        if(root == null) {
	            list.add(0,smaller);
	            return new TreeNode(node);
	        }
	        if(root.val< node) {
	            
	          // smaller += root.smaller;
	           //smaller++; //for root
	          
	               root.right=  add(node, root.right,smaller+1+root.smaller , list);
	            
	        } else {
	            root.smaller++;
	           
	               root.left =  add(node, root.left,smaller , list);
	            
	            
	        }  
	        return root;
	        
	        
	    }
	}
}
