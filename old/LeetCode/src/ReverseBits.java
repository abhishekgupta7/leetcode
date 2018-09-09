/**
 * 
 * 
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 * https://leetcode.com/problems/reverse-bits/
 * 190. Reverse Bits
 * @author abhigupta
 *
 */
public class ReverseBits {

	public static void main(String st[]) {
		
		
		System.out.println(new ReverseBits().reverseBits(1));
	}
public int reverseBits(int n) {
        
        int r = 0;
        int i =0;
        while(i++ != 32) {
            
            r = (r<< 1 )| (1& n);
            n = n>>>1;
        }
        return r;
    }
}
