/**
 * 
 * https://leetcode.com/problems/zigzag-conversion/ 6. ZigZag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author abhigupta
 *
 */
public class ZigZagConversion {

	public String convert(String s, int numRows) {

		if (s == null || s.length() == 0) {
			return s;

		}
		StringBuilder r[] = new StringBuilder[numRows];

		for (int i = 0; i < numRows; i++) {

			r[i] = new StringBuilder();
		}
		int i = 0;
		int sl = 0;
		while (sl < s.length()) {

			for (i = 0; i < numRows && sl < s.length(); i++) {
				r[i].append(s.charAt(sl++));
			}
			for (int up = numRows - 2; up >= 1 && sl < s.length(); up = up - 1) {
				r[up].append(s.charAt(sl++));
			}

		}
		StringBuilder res = new StringBuilder();
		for (i = 0; i < numRows; i++) {

			res.append(r[i].toString());
		}

		return res.toString();
	}

}
