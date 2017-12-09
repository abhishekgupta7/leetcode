import java.util.HashMap;
import java.util.Map;

/**
 * 659. Split Array into Consecutive Subsequences
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * description/
 * 
 * @author abhigupta
 *
 */
public class SplitArrayConsecutiveSubseque {

	public boolean isPossible(int[] nums) {

		Map<Integer, Integer> count = new HashMap<>();
		Map<Integer, Integer> pre = new HashMap<>();

		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		for (int n : nums) {

			if (count.get(n) == 0) {
				continue;
			}
			if (pre.getOrDefault(n, 0) > 0) {

				pre.put(n, pre.get(n) - 1);
				pre.put(n + 1, count.getOrDefault(n + 1, 0) + 1);

			} else if (count.getOrDefault(n + 1, 0) > 0 && count.getOrDefault(n + 2, 0) > 0) {

				count.put(n + 1, count.get(n + 1) - 1);
				count.put(n + 2, count.get(n + 2) - 1);
				pre.put(n + 3, pre.getOrDefault(n + 3, 0) + 1);
			} else {
				return false;
			}

			count.put(n, count.get(n) - 1);

		}
		return true;

	}
	
	public static void main(String arg[]) {
		int a[] = {1,2,3,4,4,5};
		System.out.println(new SplitArrayConsecutiveSubseque().isPossible(a));
	}

}
