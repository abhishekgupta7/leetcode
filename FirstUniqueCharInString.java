/**
 * 
 * https://leetcode.com/problems/first-unique-character-in-a-string/#/description
 *  387. First Unique Character in a String 
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.

Subscribe to see which companies asked this question.

 * @author abhigupta
 *
 */
public class FirstUniqueCharInString {

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		int chars[] = new int[27];
		int i = 0;
		for (char ch : s.toCharArray()) {

			chars[ch - 'a']++;
		}
		for (char ch : s.toCharArray()) {

			if (chars[ch - 'a'] == 1) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
