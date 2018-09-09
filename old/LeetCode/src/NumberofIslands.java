import java.util.Stack;

/***
 * 
 * 200. Number of Islands Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded by water and is formed
 * by connecting adjacent lands horizontally or vertically. You may assume all
 * four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110 11010 11000 00000
 * 
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000 11000 00100 00011
 * 
 * Answer: 3
 * 
 * Credits:
 * 
 * @author abhigupta
 *
 */

class Point {

	public int x;
	public int y;

	Point(int x, int y) {

		this.x = x;
		this.y = y;
	}
}

public class NumberofIslands {

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int c = 0;

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == '1') {
					c++;
					markAll(grid, i, j);
				}

			}

		}

		return c;

	}

	public void markAll(char[][] grid, int i, int j) {

		Stack<Point> stack = new Stack<Point>();

		Point p = new Point(i, j);
		stack.push(p);

		while (!stack.isEmpty()) {

			p = stack.pop();

			grid[p.x][p.y] = '2';

			if (p.x > 0 && grid[p.x - 1][p.y] == '1') {
				stack.push(new Point(p.x - 1, p.y));
			}

			if (p.y > 0 && grid[p.x][p.y - 1] == '1') {
				stack.push(new Point(p.x, p.y - 1));
			}

			if (p.x < grid.length - 1 && grid[p.x + 1][p.y] == '1') {
				stack.push(new Point(p.x + 1, p.y));
			}
			if (p.y < grid[0].length - 1 && grid[p.x][p.y + 1] == '1') {
				stack.push(new Point(p.x, p.y + 1));
			}

		}

	}

}
