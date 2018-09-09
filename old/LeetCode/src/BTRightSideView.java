import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4]. 
 * 199. Binary Tree Right Side View
 * @author abhigupta
 *  AMZ
 */
public class BTRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root == null){
            return l;
        }
        Queue<TreeNode> q= new LinkedList<>();
      
        q.add(root);
        while(q.size() != 0) {
            
            int s = q.size();
            
            while(s>0){
                
                TreeNode pop = q.poll();
                if(s == 1){
                    l.add(pop.val);
                }
                if(pop.left != null) {
                    q.add(pop.left);
                }
                if(pop.right != null) {
                    q.add(pop.right);
                }
                s--;
                
            }
            
            
        }
        return l;
        
    }

}
