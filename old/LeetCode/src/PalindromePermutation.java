import java.util.HashMap;
import java.util.Map;

/***
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * 266. Palindrome Permutation
 * #Google #Uber
 * @author abhigupta
 *
 */
public class PalindromePermutation {

	public boolean canPermutePalindrome(String s) {

		int len = s.length();
		if (len == 1) {
			return true;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int i = 0;
		while (i < s.length()) {
			if (map.get(s.charAt(i)) == null) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}

			i++;
		}

		if (len % 2 == 0) {

			for (Integer value : map.values()) {
				if (value % 2 != 0) {
					return false;
				}

			}
		} else {
			boolean isOdd = false;
			for (Integer value : map.values()) {
				if (value % 2 != 0) {
					if (!isOdd) {
						isOdd = true;
					} else {
						return false;
					}
				}

			}
		}
		return true;

	}

}
