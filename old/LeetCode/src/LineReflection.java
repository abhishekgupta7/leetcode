import java.util.HashSet;
import java.util.Set;

/***
 * https://leetcode.com/problems/line-reflection/ Given n points on a 2D plane,
 * find if there is such a line parallel to y-axis that reflect the given
 * points.
 * 
 * Example 1:
 * 
 * Given points = [[1,1],[-1,1]], return true.
 * 
 * Example 2:
 * 
 * Given points = [[1,1],[-1,-1]], return false.
 * 
 * Follow up: Could you do better than O(n2)? 356. Line Reflection
 * 
 * @author abhigupta
 *
 */
public class LineReflection {

	public boolean isReflected(int[][] points) {

		if (points == null || points.length == 0) {
			return true;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Set<String> s = new HashSet<>();
		for (int p[] : points) {

			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
			s.add(p[0] + "-" + p[1]);
		}

		int l = (min + max); // mistake

		for (int p[] : points) {

			String str = (l - p[0]) + "-" + p[1];
			if (!s.contains(str)) {
				return false;
			}
		}
		return true;

	}

}
