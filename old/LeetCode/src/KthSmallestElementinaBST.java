/***
 * 
 * 230. Kth Smallest Element in a BST
 * 
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @author abhigupta
 *
 */

 class Val{
     Integer val;
     int k;
     
     Val(int k, Integer val) {
         
         this.k= k;
         this.val= val;
     }
     
 }
public class KthSmallestElementinaBST {
	

	   
    public int kthSmallest(TreeNode root, int k) {
        
        Val v = new Val(k,null);
        Kth(root, v);
        return   v.val;
    }
    
    void Kth(TreeNode root, Val v) {
        
        if(v.val != null || root == null){
            return ;
        }
        
        Kth(root.left, v);
        v.k--;
        
        if(v.k==0) {
            v.val = root.val;
        }
        
        Kth(root.right,v);
        
        
    }
    
    
    


}
