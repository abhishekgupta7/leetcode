import java.util.HashMap;
import java.util.Map;

/***
 * 242. Valid Anagram
 * 
 * https://leetcode.com/problems/valid-anagram/#/description
 * 
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 * @author abhigupta
 *
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {

		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : t.toCharArray()) {
			Integer v = map.getOrDefault(ch, 0);
			if (v == 0) {
				return false;
			}
			v--;
			if (v == 0) {
				map.remove(ch);
			} else {
				map.put(ch, v);
			}

		}
		return (map.keySet().size() != 0) ? false : true;

	}

}
