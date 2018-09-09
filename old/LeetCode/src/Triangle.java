import java.util.LinkedList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/triangle/
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle
 * 
 * @author abhigupta
 *
 */
public class Triangle {

	public int minimumTotal_other(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
			return -1;
		}
		int count = Integer.MAX_VALUE;// imp

		List<Integer> toAdd = null;

		List<Integer> pre = new LinkedList<Integer>();

		List<Integer> curr = null;
		pre.add(triangle.get(0).get(0));
		for (int i = 0; i < triangle.size() - 1; i++) {

			curr = new LinkedList<Integer>();
			toAdd = triangle.get(i + 1);
			for (int j = 0; j < pre.size(); j++) {

				curr.add(pre.get(j) + toAdd.get(j));

				if (curr.size() > j && curr.size() > 2) {
					int p1 = curr.get(curr.size() - 1);
					curr.remove(curr.size() - 1);
					int p2 = curr.get(curr.size() - 1);
					curr.remove(curr.size() - 1);
					p1 = Math.min(p1, p2);
					curr.add(p1);
				}

				curr.add(pre.get(j) + toAdd.get(j + 1));

			}
			pre = curr;

		}

		for (int v : pre) {

			count = Math.min(count, v);
		}

		return count;

	}

	
	public int minimumTotal(List<List<Integer>> triangle) {
	    int[] A = new int[triangle.size()+1];
	    for(int i=triangle.size()-1;i>=0;i--){
	        for(int j=0;j<triangle.get(i).size();j++){
	            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
	        }
	    }
	    return A[0];
	}
}
