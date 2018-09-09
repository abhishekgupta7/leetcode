/**
 * https://leetcode.com/problems/power-of-two/
 * 231. Power of Two
 *  Given an integer, write a function to determine if it is a power of two. 
 * @author abhigupta
 *
 */
public class PowerOf2 {

	
	  public boolean isPowerOfTwo(int n) {
	        if( n<= 0){
	            return false;
	        }
	        return ((n & n-1) ==0);
	        //return (n>>1 ==0);
	    }
}
