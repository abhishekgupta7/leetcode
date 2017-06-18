/**
 * 
 * 230. Kth Smallest Element in a BST
 * 
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/description
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @author abhigupta
 *
 */

class Val {
	Integer val;
	int k;

	Val(int k, Integer val) {

		this.k = k;
		this.val = val;
	}

}

public class KthSmallestElement {

	public int kthSmallest(TreeNode root, int k) {

		Val v = new Val(k, null);
		Kth(root, v);
		return v.val;
	}

	void Kth(TreeNode root, Val v) {

		if (v.val != null || root == null) {
			return;
		}

		Kth(root.left, v);
		v.k--;

		if (v.k == 0) {
			v.val = root.val;
		}

		Kth(root.right, v);

	}

}
