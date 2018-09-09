/**
 * 48. Rotate Image
 * 
 * https://leetcode.com/problems/rotate-image/ You are given an n x n 2D matrix
 * representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author abhigupta
 *AMZ MS APPLE
 */
public class RotateImage {

	public void rotate(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0] == null) {
			return;
		}

		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			int c = i;

			while (c < i + (n - 2 * i) - 1) {// imp
				int p = matrix[i][c];
				int next = matrix[c][n - 1 - i];
				matrix[c][n - 1 - i] = p;
				p = next;
				next = matrix[n - 1 - i][n - 1 - c];
				matrix[n - 1 - i][n - 1 - c] = p;
				p = next;
				next = matrix[n - 1 - c][i];
				matrix[n - 1 - c][i] = p;
				p = next;
				matrix[i][c] = p;
				c++;

			}

		}

	}

}
