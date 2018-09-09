/**
 * 
 * https://leetcode.com/problems/prefix-and-suffix-search/description/
 * 
 *  Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:

Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1

Note:

    words has length in range [1, 15000].
    For each test case, up to words.length queries WordFilter.f may be made.
    words[i] has length in range [1, 10].
    prefix, suffix have lengths in range [0, 10].
    words[i] and prefix, suffix queries consist of lowercase letters only.

 * @author abhigupta
 *
 */
public class PrefixandSuffixSearch {
	
	 TrieNode trie;
	    public PrefixandSuffixSearch(String[] words) {
	        trie = new TrieNode();
	        for (int weight = 0; weight < words.length; ++weight) {
	            String word = words[weight] + "{";
	            for (int i = 0; i < word.length(); ++i) {
	                TrieNode cur = trie;
	                cur.weight = weight;
	                System.out.println();
	                for (int j = i; j < 2 * word.length() - 1; ++j) {
	                    int k = word.charAt(j % word.length()) - 'a';
	                    System.out.print(word.charAt(j % word.length()));
	                    if (cur.children[k] == null)
	                        cur.children[k] = new TrieNode();
	                    cur = cur.children[k];
	                    cur.weight = weight;
	                }
	            }
	        }
	    }
	    public int f(String prefix, String suffix) {
	        TrieNode cur = trie;
	        for (char letter: (suffix + '{' + prefix).toCharArray()) {
	            if (cur.children[letter - 'a'] == null) return -1;
	            cur = cur.children[letter - 'a'];
	        }
	        return cur.weight;
	    }
	    
		 public static void main(String st[]) {
			 String w[] = {"apple"};
			 System.out.println(new PrefixandSuffixSearch(w));
		 }
	}

	class TrieNode {
	    TrieNode[] children;
	    int weight;
	    public TrieNode() {
	        children = new TrieNode[27];
	        weight = 0;
	    }
	
	    
}
