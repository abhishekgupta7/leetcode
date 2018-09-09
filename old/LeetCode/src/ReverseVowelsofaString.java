/**
 * 
 * 345. Reverse Vowels of a String
 * 
 * @author abhigupta Write a function that takes a string as input and reverse
 *         only the vowels of a string.
 * 
 *         Example 1: Given s = "hello", return "holle".
 * 
 *         Example 2: Given s = "leetcode", return "leotcede".
 * 
 *         Note: The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {

	public String reverseVowels(String s) {

		if (s == null || s.length() <= 1) {
			return s;
		}
		char ch[] = s.toCharArray();

		int i = 0;

		int j = s.length() - 1;
		while (i < j) {

			while (i < j && !isVowel(ch[i])) {
				i++;
			}

			while (i < j && !isVowel(ch[j])) {
				j--;
			}

			replace(ch, i, j);
			i++;
			j--;

		}

		return new String(ch);
	}

	boolean isVowel(char ch) {

		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U') {
			return true;
		}
		return false;

	}

	void replace(char ch[], int i, int j) {

		if (i == j) {
			return;
		}
		char c = ch[i];
		ch[i] = ch[j];
		ch[j] = c;
	}

}
