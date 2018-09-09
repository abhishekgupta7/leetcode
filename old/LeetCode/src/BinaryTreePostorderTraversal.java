import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 145. Binary Tree Postorder Traversal
 * @author abhigupta
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 *
 */

class NodeExplore {
    
    
    public boolean isEx;
    public TreeNode node;
    
    NodeExplore( TreeNode node, boolean isEx) {
        
        this.isEx = isEx;
        this.node = node;
    }
    
}


public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        
        
        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null) {
            return list;
        }
        
        Stack<NodeExplore> stack = new Stack<NodeExplore>();
                NodeExplore curr = new NodeExplore(root, false);

        stack.push(curr);
        
       
        while(!stack.isEmpty()) {
            
            curr = stack.pop();
            if(curr.isEx || (curr.node.left == null && curr.node.right == null)) {
                
                list.add(curr.node.val);
                continue;
            }
           
            stack.push(new NodeExplore(curr.node, true));

           
        
            if(curr.node.right != null) {
            
                    stack.push(new NodeExplore(curr.node.right, false));

                }
         
             if(curr.node.left != null) {
                
                stack.push(new NodeExplore(curr.node.left, false));

            }           
    

            
        }
        
        
        
        
        return list;
        
    
        
    }

}
