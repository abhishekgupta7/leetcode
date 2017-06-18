/***
 * 
 * 
 * https://leetcode.com/problems/binary-search-tree-iterator/#/description
 *  173. Binary Search Tree Iterator 
 *  
 *  Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
 */
import java.util.Stack;

public class BinarySearchTreeIterator {

	Stack<TreeNode> s = new Stack<TreeNode>();

	public BinarySearchTreeIterator(TreeNode root) {
    
        addLeft(root);
    }

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return (s.size() != 0);
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode p = s.pop();
		int v = p.val;
		addLeft(p.right);
		return v;

	}

	private void addLeft(TreeNode root) {
		while (root != null) {
			s.add(root);
			root = root.left;
		}

	}

}
