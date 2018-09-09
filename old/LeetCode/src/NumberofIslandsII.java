import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/***
 * 
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0

Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0

Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0

Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0

We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
 * @author abhigupta
 *
 */

class Union {
    
    
    int a[]= null;
    int h[] = null;
    Union(int m, int n) {
        
        a = new int[m*n];
        h = new int[m*n];
        for(int i=0;i<m*n;i++) {
            a[i] =i;
            h[i] =1;
        }
        
    }
    
    void union(int p, int q) {
        
        int pp = find(p);
        int pq = find(q);
        if(pq == pp) {
            return ;
        }
        if(h[pq] <= h[pp]) {
            h[pp] += h[pq];
            a[pq] = pp;
        }else if(h[pq] > h[pp]) {
             h[pq] += h[pp];
            a[pp] = pq;
        }
        
        
    }
    int find(int p) {
        
            //System.out.println("in find"+p);

        while(p != a[p]) {
            int cu = a[p];
            a[p] = a[cu];//imp
            p = a[p];
            
            
        }
        return p;
        
    }
    
    
}

public class NumberofIslandsII {

	

public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> l = new LinkedList<>();
        
        
        if(m<0 || n<0 || (m==0 && n ==0 ) || positions== null || positions.length ==0 || positions[0] == null  ) {
            return l;
        }
        int mat[][] = new int[m][n];
        Union u = new Union(m,n);
        Set<Integer> s = new HashSet<>();
        
        int np[] ={0,1,0,-1,0};
        for(int k=0;k<positions.length ;k++) {
            int i = positions[k][0];
            int j = positions[k][1];
            mat[i][j] = 1;
            int pos = get(m,n,i,j);
            
            
            for(int inp =0; inp<np.length-1; inp++) {
            	
            	int ni = i+np[inp];
            	int nj = j+np[inp+1];
            	
            	if(ni>=0 && ni<m && nj>=0 && nj<n && mat[ni][nj] ==1) {
            		 s.remove(u.find(get(m,n,ni,nj)));

                    u.union(pos, get(m,n,ni,nj));
            	}

            }

            s.add(u.find(pos));
            l.add(s.size());
        } 
        return l;
    }
    
    int get(int m, int n, int i, int j) {
        
        return n*i+j; //imp
        
    }
}
