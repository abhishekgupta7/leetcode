/**
 * 
 * Reverse digits of an integer.
https://leetcode.com/problems/reverse-integer/
7. Reverse Integer
Example1: x = 123, return 321
Example2: x = -123, return -321 
 * @author abhigupta
 *
 */
public class ReverseInteger {

    public int reverse(int x) {
        
        int max = Integer.MAX_VALUE/10;
        int v =0;
       
        while(x != 0) {
            
            int n = x%10;
            if((Math.abs(v) == max && Math.abs(n)>=8) || Math.abs(v)>max ) {
                return 0;
            }
            v = v*10+n;
            x = x/10;
            
            
        }
        return  v;
        
    }

}
