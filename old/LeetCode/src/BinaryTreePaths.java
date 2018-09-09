import java.util.ArrayList;
import java.util.List;

/** Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]
 * 
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 * @author abhigupta
 *
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> l = new ArrayList<>();
        if(root == null) {
            return l;
        }
        binaryTreePaths(root,l,"");
        
        return l;
        
    }
    
    
    private void binaryTreePaths(TreeNode root, List<String> l, String s) {
        
        if(root == null) {
            
            return;
        }
        
        if(s.length() != 0){
            s = s+"->";
        }
        s = s+root.val;
        if(root.left == null && root.right == null) {
            l.add(s);
            return;
            
        }
        binaryTreePaths(root.left, l,s);
        binaryTreePaths(root.right, l, s);

        
    }

}
