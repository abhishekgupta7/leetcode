/**
 * 
 * 404. Sum of Left Leaves 
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 */
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {

		return sumOfLeftLeaves(root, false);
	}

	private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {

		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			if (isLeft) {
				return root.val;
			}
			return 0;
		}
		return sumOfLeftLeaves(root.right, false) + sumOfLeftLeaves(root.left, true);
	}
	
	
	public int sumOfLeftLeaves2(TreeNode root) {
		
		int ans = 0;
		if(root == null) {
			return ans;
		}
		TreeNode left = root.left;
		
		if(left != null && left.left == null && left.right == null) {
			ans += root.val;
		}else {
			ans += sumOfLeftLeaves2(left);
		}
		ans += sumOfLeftLeaves2(root.right);
		
		return ans;
		
	}
 
}
