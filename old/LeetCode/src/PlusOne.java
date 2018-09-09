/**Given a non-negative number represented as an array of digits, plus one to the number.
https://leetcode.com/problems/plus-one/
The digits are stored such that the most significant digit is at the head of the list.
 * 
 * 66. Plus One
 * @author abhigupta
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        
        if(digits == null || digits.length ==0){
            return digits;
        }
        int i = digits.length-1;
        int c =1;
        while(i>=0){
            int n = digits[i]+c;
            digits[i--]= n%10;
            c = n/10;
            if(c ==0) {
                return digits;
            }
        }

        int r [] = new int[digits.length+1];
        r[0] =1;
        
        return r;
        
    }


}
