/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
 * 99. Recover Binary Search Tree
 * @author abhigupta
 *
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
 */
public class RecoverBST {

	

    
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    boolean found = false;
    
    public void recoverTree(TreeNode root) {
        
        recoverTrees(root);
      
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
    public void recoverTrees(TreeNode root) {
    
    if(root == null || found) {
        return;
    }    
    
    recoverTrees(root.left);
    
    if(pre != null && pre.val >= root.val) {
        if(first == null) {
            first = pre;
            second = root;
        }else {
            second = root;
            found = true;
        }
    }    
    pre = root;
    recoverTrees(root.right);        
    }

}
