import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * 
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3]. 
 * @author abhigupta
 *
 */
public class BTPreOrderTraversal {
	

    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        if(root == null) {
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(s.size() != 0) {
            
            TreeNode pop = s.pop();
            list.add(pop.val);
            if(pop.right != null) {
                s.push(pop.right);
            }
            if(pop.left != null) {
                s.push(pop.left);
            }
            
            
            
        }
        return list;
    }


}
