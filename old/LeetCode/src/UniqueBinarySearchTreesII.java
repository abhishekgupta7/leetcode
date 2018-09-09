import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/unique-binary-search-trees-ii/ Given an integer
 * n, generate all structurally unique BST's (binary search trees) that store
 * values 1...n.
 * 
 * For example, Given n = 3, your program should return all 5 unique BST's shown
 * below.
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * Unique Binary Search Trees II
 * 
 * @author abhigupta
 *
 */
public class UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int n) {

		List<TreeNode> l = new ArrayList<>();

		if (n < 1) {
			return l;
		}

		return genTreeList(1, n);

	}

	private List<TreeNode> genTreeList(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
		}
		for (int idx = start; idx <= end; idx++) {
			List<TreeNode> leftList = genTreeList(start, idx - 1);
			List<TreeNode> rightList = genTreeList(idx + 1, end);
			for (TreeNode left : leftList) {
				for (TreeNode right : rightList) {
					TreeNode root = new TreeNode(idx);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}
		return list;
	}

}
