import java.util.Stack;

/***
 * 
 * 
 *  85. Maximal Rectangle 
 *  
 *   
 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 6. 
 * @author abhigupta
 *
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int area = 0;
		int height[] = new int[matrix[0].length + 1];

		for (int row = 0; row < matrix.length; row++) {

			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < height.length - 1; i++) {

				if (matrix[row][i] == '1') {
					height[i] += 1;
				} else {
					height[i] = 0;
				}

			}
			for (int i = 0; i < height.length; i++) {
				if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
					stack.push(i);
				} else {
					int pre = stack.pop();
					area = Math.max(area, height[pre] * (stack.isEmpty() ? i : (i - 1 - stack.peek())));

					i--;
				}

			}

		}

		return area;
	}

}
