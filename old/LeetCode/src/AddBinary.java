/**
 * 
 * 67. Add Binary
 * 
 * @author abhigupta Given two binary strings, return their sum (also a binary
 *         string).
 *         https://leetcode.com/problems/add-binary/
 * 
 *         For example, a = "11" b = "1" Return "100".
 */
public class AddBinary {

	public String addBinary(String a, String b) {

		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		StringBuilder sb = new StringBuilder();

		int i = a.length() - 1;
		int j = b.length() - 1;

		int c = 0;

		while (i > -1 && j > -1) {

			int va = Character.getNumericValue(a.charAt(i--));
			int vb = Character.getNumericValue(b.charAt(j--));
			sb.append((va + vb + c) % 2);
			c = (va + vb + c) / 2;

		}
		while (i > -1) {

			int va = Character.getNumericValue(a.charAt(i--));
			sb.append((va + c) % 2);
			c = (va + c) / 2;
		}

		while (j > -1) {

			int vb = Character.getNumericValue(b.charAt(j--));
			sb.append((vb + c) % 2);
			c = (vb + c) / 2;
		}
		if (c > 0) {
			sb.append(c);
		}
		return sb.reverse().toString();

	}

}
