/**
 *  212. Word Search II
 *  
 *   https://leetcode.com/problems/word-search-ii/#/description
 *   
 *    Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Return ["eat","oath"]. 
 You may assume that all inputs are consist of lowercase letters a-z. 
 */

import java.util.ArrayList;
import java.util.List;

class Trie2Node2 {
	// Initialize your data structure here.

	Trie2Node2 child[] = new Trie2Node2[26];
	// Map<Character,Trie2Node2> map = new HashMap<Character,Trie2Node2>();
	public String v;

}

class Trie2 {

	public Trie2Node2 root;

	public Trie2() {
		root = new Trie2Node2();
	}

	// Inserts a word into the Trie2.
	public void insert(String word) {

		if (word == null) {

			return;
		}

		insert(word.toCharArray(), root, 0, word);

	}

	private void insert(char[] w, Trie2Node2 r, int p, String word) {

		if (word.length() == p) {
			r.v = word;
			return;
		}

		// Trie2Node2 c = r.map.get(word.charAt(p));
		Trie2Node2 c = r.child[w[p] - 'a'];
		if (c == null) {
			c = r.child[word.charAt(p) - 'a'] = new Trie2Node2();

		}

		insert(w, c, p + 1, word);

	}

}

public class WordSearch2 {

	List<String> ans = new ArrayList<String>();

	public List<String> findWords(char[][] board, String[] words) {

		Trie2 trie = new Trie2();

		for (String s : words) {
			trie.insert(s);
		}

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				srch(board, trie.root, i, j);
			}

		}

		return ans;

	}

	void srch(char[][] b, Trie2Node2 root, int r, int c) {

		if (r < 0 || c < 0 || r >= b.length || c >= b[0].length) {
			return;
		}

		char ch = b[r][c];
		if (ch == '#' || root.child[ch - 'a'] == null) {
			return;
		}

		root = root.child[ch - 'a'];

		if (root.v != null) {

			ans.add(root.v);
			root.v = null;
		}

		b[r][c] = '#';

		srch(b, root, r + 1, c);

		srch(b, root, r, c + 1);
		srch(b, root, r - 1, c);
		srch(b, root, r, c - 1);

		b[r][c] = ch;

	}

}
