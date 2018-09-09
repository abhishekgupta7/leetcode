/***
 * 
 * 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:

    The numbers can be arbitrarily large and are non-negative.
    Converting the input string to integer is NOT allowed.
    You should NOT use internal library such as BigInteger.

 * @author abhigupta
 *
 */
public class MultipleStrings {

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] result = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; --i) {
			for (int j = num2.length() - 1; j >= 0; --j) {
				int contribution = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int sum = result[i + j + 1] + contribution;
				result[i + j + 1] = sum % 10;
				result[i + j] += sum / 10;
			}
		}
		StringBuilder ans = new StringBuilder();
		for (int i = result[0] == 0 ? 1 : 0; i < result.length; ++i) {
			ans.append(result[i]);
		}
		return ans.toString();
	}
	
	public static void main(String st[]) {
		
		System.out.println(new MultipleStrings().multiply("8", "8"));
		
	}
}
