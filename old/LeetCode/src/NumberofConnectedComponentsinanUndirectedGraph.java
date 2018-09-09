import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 323. Number of Connected Components in an Undirected Graph
 * 
 *  Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

     0          3
     |          |
     1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

     0           4
     |           |
     1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


 * @author abhigupta
 *
 */

class UF {
    int[] id;

    public UF(int n) {
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }


    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
    }
    

	public int countComponents(int n, int[][] edges) {
  
	
	UF uf = new UF(n);
	
    if(edges == null || edges.length ==0 ) {
        return n;
    }	
	for(int i =0;i<edges.length ;i++) {
		
		uf.union(edges[i][0], edges[i][1]);
	}
	
	Set<Integer> s = new HashSet<Integer>();
	
	for(int i=0 ;i<n;i++) {
		s.add(uf.find(i));
	}
	return s.size();
}

}



public class NumberofConnectedComponentsinanUndirectedGraph {

}
