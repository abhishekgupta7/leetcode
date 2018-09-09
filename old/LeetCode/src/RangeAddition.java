/***
 * 370. Range Addition
 * 
 * 
 * https://leetcode.com/problems/range-addition/
 * @author abhigupta
 *Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]

Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]

 */
public class RangeAddition {
	

    public int[] getModifiedArray(int length, int[][] updates) {
        
        if(length ==0 ) {
            return new int[length];
        }
        if(updates == null || updates.length ==0 || updates[0] == null || updates[0].length ==0) {
            return new int[length];
        }
        
       int s[] = new int [length]; 
        
        int e[] = new int [length]; 


        for(int i =0;i<updates.length ;i++) {
            
            
            s[updates[i][0]] += updates[i][2];
            
            e[updates[i][1]] += updates[i][2];

        }
        
        int r[] = new int[length];
        r[0] = s[0];
        int sum = s[0];
        for(int i=1;i<length;i++) {
            
            sum += s[i] - e[i-1];
            r[i] = sum;
        }
        
        return r;
    }


}
