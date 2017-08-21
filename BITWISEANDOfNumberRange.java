/**
 * 
 *  201. Bitwise AND of Numbers Range 
 *  
 *  https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/
 *  
 *  Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4. 
 * @author abhigupta
 *
 */
public class BITWISEANDOfNumberRange {

	
	public int rangeBitwiseAnd(int m, int n) {
	    int r=Integer.MAX_VALUE;
    	System.out.println(Integer.toBinaryString(r));

	    while((m&r)!=(n&r)) {
	    	r=r<<1;
	    	System.out.println(Integer.toBinaryString(r));
	    }
	    return n&r;
	}
	
	public static void main(String st[]) {
		
		System.out.println(new BITWISEANDOfNumberRange().rangeBitwiseAnd(5, 7));
		
	}
}
