/**
 * 
 * 298. Binary Tree Longest Consecutive Sequence
 * 
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 *  Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5

Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1

Longest consecutive sequence path is 2-3,not3-2-1, so return 2. 
 * @author abhigupta
 *#google
 */
public class BTLOngestConsecutiveSeq {

	int max = 0;

	public int longestConsecutive(TreeNode root) {

		longestConsecutiveHelper(root);
		return max;

	}

	public int longestConsecutiveHelper(TreeNode root) {

		if (root == null) {
			return 0;
		}
		max = Math.max(max, 1);

		int l = 0;
		int r = 0;
		boolean isLeft = false;

		if (root.left != null) {

			l = longestConsecutiveHelper(root.left);
			if (root.val + 1 == root.left.val) {
				l++;
				isLeft = true;
			}
		}
		boolean isRight = false;
		if (root.right != null) {

			r = longestConsecutiveHelper(root.right);
			if (root.val + 1 == root.right.val) {
				r++;
				isRight = true;
			}
		}
		max = Math.max(max, Math.max(l, r));

		if (isLeft)
			return l;
		if (isRight)
			return r;
		return 1;
	}

}
