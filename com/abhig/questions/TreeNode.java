package com.abhig.questions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
	
	
	
	
	public void print() {
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		level(this, 0, map);
		
		for(int s = 0;s<map.size();s++) {
			
			printSpaces((map.size()-s)*2);
			for(Integer val : map.get(s)) {
				System.out.print(val+"  ");
			}
			System.out.println();
		}
		
		
	}
	void printSpaces(int n ){
		
		while(n != 0) {
			System.out.print(" ");
			n--;
		}
	}
	public void level(TreeNode root, int level, Map<Integer, List<Integer>> map) {
		if(root == null) {
			return ;
		}
		 List<Integer> l = map.getOrDefault(level, new ArrayList<>());
		 l.add(root.val);
		 map.put(level,l);
		 
		 level(root.left, level+1, map);
		 level(root.right, level+1, map);

		
	}
	
	
	
	
}
