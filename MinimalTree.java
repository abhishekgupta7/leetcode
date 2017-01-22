/**
 * 
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 108. Convert Sorted Array to Binary Search Tree
 * @author abhigupta
 *
 */
public class MinimalTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return null;
        }
        return getTree(nums, 0,nums.length-1);
    }
    
    TreeNode getTree(int nums[], int s, int e) {
        
        if(s>e) {
            return null;
        }
        int mid = s+(e-s)/2;
        TreeNode root = new TreeNode(nums[mid]); 
        root.left = getTree(nums,s,mid-1); 
        root.right = getTree(nums,mid+1,e);
        return root;
    }
    

}
