import java.util.LinkedList;
import java.util.List;

/**
 * 254. Factor Combinations
 * @author abhigupta
 *Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:

    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

Examples:
input: 1
output:

[]

input: 37
output:

[]

input: 12
output:

[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

input: 32
output:

[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

 */
public class FactorCombinations {
	
    public List<List<Integer>> getFactors(int n) {
        
        return helper(n, 2);
    }
    
   List<List<Integer>> helper(int num, int s) {
        
    	List<List<Integer>> res = new LinkedList<>();
        
        for(int i =s;i<=Math.sqrt(num);i++) {
            
            if(num %i == 0) {
                if(i> (num/i)) {
                    break;
                }
                List<Integer> l = new LinkedList<>();
                l.add(i);
                l.add(num/i);
                res.add(l);
                for(List<Integer> ll : helper(num/i, i)) {
                    ll.add(0, i);
                    res.add(ll);
                }
            }
            
            
        }
        return res;
        
    }

}
