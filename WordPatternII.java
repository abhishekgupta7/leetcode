import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
	Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
	
	public boolean wordPatternMatch(String pattern, String str) {

		// base cases;

		return wordPatternMatch(pattern, str, 0, 0);
	}

	public boolean wordPatternMatch(String pattern, String str, int p, int s) {
		//System.out.println(pattern.substring(p));

		if (p == pattern.length() && s == str.length()) {
			return true;
		}
		if (p >= pattern.length() || s >= str.length()) {
			return false;
		}

			char ch = pattern.charAt(p);

			String key = map.get(ch);

			if (key != null) {
				int j = 0;
				while (j < key.length() && j + s < str.length() && key.charAt(j) == str.charAt(j + s)) {
					j++;
				}
				if (j == key.length()) {
					return wordPatternMatch(pattern, str, p + 1, j+s);

				}
				return false;

			} else {

				for (int j = s + 1; j < str.length() + 1; j++) {
					String sub = str.substring(s, j);
					if(set.contains(sub)){ // tricky
						continue;
					}
					map.put(ch, sub);
					set.add(sub);
					boolean ans = wordPatternMatch(pattern, str, p + 1, j);
					if (ans)
						return true;
					map.remove(ch);
					set.remove(sub);
				}

			}

		
		return false;

	}
	public static void main(String st[]) {
		
		System.out.println(new WordPatternII().wordPatternMatch("ab", "aa"));
	}
}
