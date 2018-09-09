/**
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * @author abhigupta
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}

		int i = 0;
		if (strs.length == 1) {
			return strs[0];
		}

		if (strs[0] == null || strs[0].length() == 0) {
			return strs[0];
		}
		int len = 0;
		String r = strs[0];
		int min = Integer.MAX_VALUE;
		for (String s : strs) {

			if (s.length() == Math.min(min, s.length())) {
				min = s.length();
				r = s;
			}

		}

		while (len < strs.length) {
			String c = strs[len++];
			if (r.length() == 0 || c == null || c.length() == 0) {
				return "";
			}
			if (c.startsWith(r)) {
				continue;
			}
			i = 0;
			char cc[] = c.toCharArray();
			char rc[] = r.toCharArray();

			while (i < min && i < r.length() && cc[i] == rc[i]) {
				i++;
			}

			r = c.substring(0, i);

		}
		return r;

	}

}
