import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/word-pattern/description/
 * 
 * @author abhigupta Given a pattern and a string str, find if str follows the
 *         same pattern.
 * 
 *         Here follow means a full match, such that there is a bijection
 *         between a letter in pattern and a non-empty word in str.
 * 
 *         Examples:
 * 
 *         pattern = "abba", str = "dog cat cat dog" should return true. pattern
 *         = "abba", str = "dog cat cat fish" should return false. pattern =
 *         "aaaa", str = "dog cat cat dog" should return false. pattern =
 *         "abba", str = "dog dog dog dog" should return false.
 * 
 *         Notes: You may assume pattern contains only lowercase letters, and
 *         str contains lowercase letters separated by a single space.
 * 
 *         Credits: Special thanks to @minglotus6 for adding this problem and
 *         creating all test cases.
 */
public class WordPattern {

	public boolean wordPattern(String pattern, String str) {

		if (str == null || pattern == null) {
			return false;
		}

		String s[] = str.split(" ");
		if (pattern.length() != s.length) {
			return false;
		}

		Map<Character, Integer> ci = new HashMap<>();
		Map<String, Integer> si = new HashMap<>();

		for (int i = 0; i < s.length; i++) {
			
			Integer l = ci.put(pattern.charAt(i), i);
			Integer r = si.put(s[i], i);
			if((l == null && r == null)) {
				continue;
			}
			if(l == null || r == null || !l.equals(r)) {
				return false;
			}
			
			

		}
		return true;
	}
	
	public static void main(String st[]) {
		System.out.println(new WordPattern().wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd", "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
	}

}
