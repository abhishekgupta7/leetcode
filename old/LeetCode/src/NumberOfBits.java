/**
 * 
 * https://leetcode.com/problems/number-of-1-bits/
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has (also known as the Hamming weight).

For example, the 32-bit integer 1 has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 * 191. Number of 1 Bits
 * @author abhigupta
 *
 */
public class NumberOfBits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int count =0;
        
        while(n != 0 ){
            if( (n & 1) != 0) {
                count ++;
            }
            n>>>= 1;
        }
        return count;
    }

}
