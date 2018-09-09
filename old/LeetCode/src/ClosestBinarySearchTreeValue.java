/***
 * 
 * 270. Closest Binary Search Tree Value
 * 
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 *  Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

 * @author abhigupta
 *
 */
public class ClosestBinarySearchTreeValue {
	

    public int closestValue(TreeNode root, double target) {
        
      return getclose(root, target);
    }
    
    private Integer getclose(TreeNode root, double target) {
        
        
        if(root == null) {
            return null;
        }
        
        TreeNode next = root.val <target ?root.right :root.left ;
        
        
        Integer child = getclose(next, target);
        
        if(child == null){
            
            return root.val;
        }
        
        return Math.abs(root.val - target) >Math.abs(child - target) ? child : root.val;
    }


}
