/**
 * 
 * https://leetcode.com/problems/string-to-integer-atoi/ 8. String to Integer
 * (atoi) Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * Update (2015-02-10): The signature of the C++ function had been updated. If
 * you still see your function signature accepts a const char * argument, please
 * click the reload button to reset your code definition.
 * 
 * @author abhigupta
 *
 */
public class StringToInteger {

	public int myAtoi(String str) {

		int n = 0;
		str = str.trim();

		boolean isNegative = false;
		int i = 0;
		if (str == null || str.length() == 0) {
			return i;
		}
		if (str.charAt(i) == '-') {
			isNegative = true;
			i++;
		} else {
			if (str.charAt(i) == '+') {
				i++;
			}

		}
		int max = Integer.MAX_VALUE / 10;
		
		while (i < str.length()) {
			if (!Character.isDigit(str.charAt(i))) {
				break;
			}
			int v = Character.getNumericValue(str.charAt(i));

			if ((n == max && v >= 8) || n > max) {
				return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			n = n * 10 + v;
			i++;
		}
		return isNegative ? -n : n;

	}

}
