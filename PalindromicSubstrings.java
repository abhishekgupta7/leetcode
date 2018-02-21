/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/description/
 * 
 * @author abhigupta
 *
 */
public class PalindromicSubstrings {

	public int countSubstrings(String s) {

		if (s == null) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int ans = 0;
		char ch[] = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {

			ans = ans + helper(ch, i, i);
			ans = ans + helper(ch, i, i + 1);
		}
		return ans;
	}

	int helper(char ch[], int l, int r) {
		if (r >= ch.length) {
			return 0;
		}
		int ans = 0;
		
		while (l >= 0 && r < ch.length) {
			if (ch[l] != ch[r]) {
				break;
			}
			l--;
			r++;
			ans++;
		}

		return ans;
	}
	
	public static void main(String st[]) {
		System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
	}

}
