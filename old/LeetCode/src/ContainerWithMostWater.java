/**
 * 
 * https://leetcode.com/problems/container-with-most-water/
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
 * @author abhigupta
 *
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {

		int maxA = 0;
		if (height == null || height.length == 0) {
			return 0;
		}

		int s = 0;
		int e = height.length - 1;

		while (s < e) {

			maxA = Math.max(maxA, Math.min(height[s], height[e]) * (e - s));

			if (height[s] > height[e]) {
				e--;
			} else {
				s++;
			}

		}
		return maxA;
	}

}
