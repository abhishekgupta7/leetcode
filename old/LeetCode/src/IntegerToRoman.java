
/**
 * 
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 * @author abhigupta
 *
 */
public class IntegerToRoman {

	private static final int[] values = {
		1000, 900, 500, 400,
		100, 90, 50, 40,
		10, 9, 5, 4,
		1
		};
		private static final String[] symbols = {
		"M", "CM", "D", "CD",
		"C", "XC", "L", "XL",
		"X", "IX", "V", "IV",
		"I"
		};
       public static String intToRoman(int num) {
	     
			if(num <= 0)
				return null;
			int len = 0;
			
			StringBuilder sb = new StringBuilder();
			
			while(num >0 ) {
			
				int value = values[len];
				
				if(value<= num) {
					num = num -value;
					sb.append(symbols[len]);
				} else {
					len++;
				}
				
			}
			
			return sb.toString();
	    }

}
