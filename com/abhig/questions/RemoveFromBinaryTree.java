package com.abhig.questions;

public class RemoveFromBinaryTree {

	public TreeNode remove( TreeNode root, TreeNode r) {

		if (r == null || root == null) {
			return null;
		}
		if(root == r) {
			return helper(root);
		}
		if (root.val < r.val) {
			root.right = remove(root.right,r );
		} else {
			root.left = remove(root.left, r);
			
		}
		return root;
		
	}

	TreeNode helper(TreeNode root) {

		if (root.left == null && root.right == null) {
			return null;
		}
		if (root.right == null) {
			return root.left;
		}
		if(root.left == null) {
			return root.right;
		}
		TreeNode replace = getLeftChild(root.right);
		root.right = remove(root.right, replace);//imp
		replace.left = root.left;
		replace.right = root.right;
		
		return replace;

	}

	TreeNode getLeftChild(TreeNode root) {

		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	TreeNode add(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}
		if(root.val< val) {
			root.right = add(root.right, val);
		}else {
			root.left = add(root.left, val);
		}
		
		return root;
	}
	
	public static void main(String st[]) {
		
		RemoveFromBinaryTree obj = new RemoveFromBinaryTree();
		TreeNode root = null;
		root = obj.add(root,20);
		root = obj.add(root,10);
		root = obj.add(root,7);
		root = obj.add(root,15);
		

		obj.print(root);
		root = obj.remove(root, root.left.right);
		obj.print(root);

		
	}
	
	void print(TreeNode root) {
		if(root == null) {
			return;
		}
		print(root.left);
		System.out.print(" "+root.val);
		print(root.right);
	}

}
