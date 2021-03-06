import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/graph-valid-tree/ Given n nodes labeled from 0
 * to n - 1 and a list of undirected edges (each edge is a pair of nodes), write
 * a function to check whether these edges make up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false. 261. Graph Valid Tree
 * 
 * Note: you can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * @author abhigupta
 *
 */

class UF {
	int[] id;

	public UF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	public void union(int q, int p) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		id[pRoot] = qRoot;
	}

	public boolean isValid(int i) {

		return id[i] == i;
	}
}

public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {

		UF uf = new UF(n);

		if (edges == null || edges.length == 0) {
			return n <= 1;
		}
		for (int i = 0; i < edges.length; i++) {

			if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
				return false;
			}
			uf.union(edges[i][0], edges[i][1]);
		}

		Set<Integer> s = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			s.add(uf.find(i));
		}
		return s.size() == 1;

	}

}
