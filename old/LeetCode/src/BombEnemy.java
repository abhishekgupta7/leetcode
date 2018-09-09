/***
 * https://leetcode.com/problems/bomb-enemy/
 * 361. Bomb Enemy
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:

For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)

 * @author abhigupta
 *
 */

class DP {
    
    int l ;
    int r;
    int u;
    int d;
    
    
}
public class BombEnemy {
	

    public int maxKilledEnemies(char[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length ==  0 ) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        DP dp[][]  = new DP[m][n];
        
        
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
               
                dp[i][j] = new DP();
                if(grid[i][j] == 'W') {
                    continue;
                }
                
                if(grid[i][j] == 'E') {
                    dp[i][j].l++;
                    dp[i][j].u++;
                    
                }
                if(j>0) {
                    
                    dp[i][j].l += dp[i][j-1].l; 
                }
                if(i>0) {
                    
                    dp[i][j].u += dp[i-1][j].u; 
                }
            
            }
        
            
        }
        
        for(int i = m-1;i>=0;i--) {
            for(int j = n-1;j>=0;j--) {
                if(grid[i][j] == 'W') {
                    continue;
                }
                
                if(grid[i][j] == 'E') {
                    dp[i][j].r++;
                    dp[i][j].d++;
                }
                if(j<n-1) {
                    
                    dp[i][j].r += dp[i][j+1].r; 
                }
                if(i<m-1) {
                    
                    dp[i][j].d += dp[i+1][j].d; 
                }
            
            }
        
            
        }
        int max = 0;
        
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
            if(grid[i][j] == '0') {
                
            max = Math.max(max,getMax(dp, i,j))    ;
                }
            }
        }
        
        
        return max;
    }
    
    public int getMax(DP dp[][], int i , int j) {
        
        int c =0;
        
        if(j>0) {
            c += dp[i][j-1].l;
        }
        if(i>0) {
            c += dp[i-1][j].u;
        }
        if(i<dp.length-1) {
            c += dp[i+1][j].d;
        }
        if(j<dp[0].length-1) {
            c += dp[i][j+1].r;
        }
        return c;
    }


}
