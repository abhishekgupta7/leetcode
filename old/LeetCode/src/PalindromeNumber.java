/**https://leetcode.com/problems/palindrome-number/
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.
Some hints:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

 * @author abhigupta
 *
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        
        if(x<0) {
            return false;
        }
        int l = 0;
        int t = x;
        while(t != 0) {
            t = t/10;
            l++;
        }
       
        int ten = (int)Math.pow(10,l-1);
        
        while(x != 0) {
            
           int f = x/ten;
           int e = x%10;
           if(f != e) {
               return false;
           }
            x = x%ten;
            x = x/10;
            ten = ten/100;
            
        }
        
        return true;
    }

}
