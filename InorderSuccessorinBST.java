
public class InorderSuccessorinBST {
	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        if(root == null) {
	            return null;
	        }
	        if(p.val >= root.val) {
	            return inorderSuccessor(root.right, p );
	        }else {
	            TreeNode inorderSucc = inorderSuccessor(root.left, p);
	            return inorderSucc == null ? root : inorderSucc;
	        }
	        
	    }
	    
	    public TreeNode predecessor(TreeNode root, TreeNode p) {
	          if (root == null)
	            return null;

	          if (root.val >= p.val) {
	            return predecessor(root.left, p);
	          } else {
	            TreeNode right = predecessor(root.right, p);
	            return (right != null) ? right : root;
	          }
	    }
	    
	    
	    public static void main(String st[]) {
	    	TreeNode root = new TreeNode(10);
	    	root.left = new TreeNode(5);
	    	System.out.println(new InorderSuccessorinBST().inorderSuccessor(root, root.left));
	    }
}
