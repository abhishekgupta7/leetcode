import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 94. Binary Tree Inorder Traversal Given a binary tree, return the inorder
 * traversal of its nodes' values.
 * 
 * For example: Given binary tree [1,null,2,3],
 * 
 * 1 \ 2 / 3
 * 
 * return [1,3,2]. https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author abhigupta
 *
 */
public class BTInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {

		TreeNode cur = root;
		TreeNode pre = null;
		TreeNode t = null;

		List<Integer> list = new ArrayList<Integer>();
		while (cur != null) {
			if (cur.left == null) {
				list.add(cur.val);
				cur = cur.right;
			} else {

				pre = cur;
				t = cur.left;

				while (t.right != null && t.right != pre) {

					t = t.right;
				}
				if (t.right == null) {
					t.right = pre;
					cur = cur.left;
				} else {
					list.add(t.right.val);

					cur = t.right.right;
					t.right = null;
				}

			}
		}
		return list;
	}

}
