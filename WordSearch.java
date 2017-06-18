/***
 * 
 * https://leetcode.com/problems/word-search/#/description 79. Word Search Given
 * a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * word = "ABCCED", -> returns true, word = "SEE", -> returns true, word =
 * "ABCB", -> returns false.
 * 
 * @author abhigupta
 *
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0) {
			return false;
		}

		if (word == null || word.length() == 0) {
			return true;
		}

		boolean mrk[][] = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				if (srch(board, word, 0, mrk, i, j)) {
					return true;
				}

			}

		}
		return false;
	}

	boolean srch(char[][] b, String word, int p, boolean mrk[][], int r, int c) {

		if (word.length() == p) {
			return true;
		}

		if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || mrk[r][c]) {
			return false;
		}

		if (b[r][c] != word.charAt(p)) {

			return false;
		}

		mrk[r][c] = true;

		if (srch(b, word, p + 1, mrk, r + 1, c) || srch(b, word, p + 1, mrk, r, c + 1)
				|| srch(b, word, p + 1, mrk, r - 1, c) || srch(b, word, p + 1, mrk, r, c - 1)) {
			return true;
		}
		mrk[r][c] = false;

		return false;

	}

}
