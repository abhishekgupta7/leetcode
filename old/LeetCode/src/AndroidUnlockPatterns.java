/**
 * 351. Android Unlock Patterns
 * Android Unlock Patterns
 * 
 *  Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:

    Each pattern must connect at least m keys and at most n keys.
    All the keys must be distinct.
    If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
    The order of keys used matters.

Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |

Invalid move: 4 - 1 - 3 - 6
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9. 
 * @author abhigupta
 *
 */
public class AndroidUnlockPatterns {

    public int numberOfPatterns(int m, int n) {
        int [][]jumps = new int[10][10];
    jumps[1][3] = jumps[3][1] = 2;
    jumps[4][6] = jumps[6][4] = 5;
    jumps[7][9] = jumps[9][7] = 8;
    jumps[1][7] = jumps[7][1] = 4;
    jumps[2][8] = jumps[8][2] = 5;
    jumps[3][9] = jumps[9][3] = 6;
    	jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
    boolean v[] = new boolean[10];
    
    int count =0;
    
    count += dfs(1,0,m,n,v,jumps,0)*4 ;
    
    count += dfs(2,0,m,n,v,jumps,0)*4;

    count += dfs(5,0,m,n,v,jumps,0);
    return count;

    }
    
    int dfs(int s, int c, int min, int max, boolean v[], int p[][], int n) {
        
        n++;
        
        if(n>= min) {
            c++;
        }
        if(n >=max) {
            return c;
        }
        v[s] = true;
       
        for(int i=1; i<=9; i++) {
            
            if( !v[i] && (p[s][i] == 0 || (p[s][i] !=0  && v[p[s][i]]))) {
                    c = dfs(i,c,min, max, v,p, n);// trick
            }
            
            
        }
        v[s] = false;

        return c;
    }

}
