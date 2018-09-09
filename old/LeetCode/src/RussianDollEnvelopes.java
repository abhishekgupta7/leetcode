import java.util.Arrays;
import java.util.Comparator;

/***
 * 
 * https://leetcode.com/problems/russian-doll-envelopes/
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]). 
 * 354. Russian Doll Envelopes
 * @author abhigupta
 *
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
     
     
      if (   envelopes           == null
        || envelopes.length    == 0
        || envelopes[0]        == null
        || envelopes[0].length == 0){
        return 0;    
    }

    Arrays.sort(envelopes, new Comparator<int[]>(){
        @Override
        public int compare(int[] e1, int[] e2){
            return Integer.compare(e1[0], e2[0]);
        }
    });
    int dp[] = new int[envelopes.length];
    int max =0;
    for(int i =1;i<envelopes.length;i++) {
        
        for(int j =0;j<i;j++) {
        
        if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]) {
            dp[i] = Math.max(dp[i], dp[j]+1);   
        }
           
        
     }
    max  = Math.max(dp[i],max);

    }
   
    return max+1;
    }

}
