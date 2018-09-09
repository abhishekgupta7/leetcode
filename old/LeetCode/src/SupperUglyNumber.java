/***
 * 313. Super Ugly Number
 * https://leetcode.com/problems/super-ugly-number/
 *  Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * @author abhigupta
 *
 */
public class SupperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        
        if(primes == null || primes.length == 0) {
            return 0;
        }

        int r[] = new int[n];
        r[0] = 1;
        
     
        int p[] = new int [primes.length]; 
    
       
        for(int i =1;i<n;i++) {
            
             r[i]  = Integer.MAX_VALUE;
            
            for(int j =0;j<primes.length;j++) {
                 r[i] = Math.min( r[i],r[p[j]]*primes[j]);
            }
            
            for(int j =0;j<primes.length;j++) {
                if(r[i]  == r[p[j]]*primes[j]) {
                    p[j]++;
                }
            }
        
            
            
        }
        
    
        
        return r[n-1];
        
 
        
    }

}
