import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 163. Missing Ranges https://leetcode.com/problems/missing-ranges/
 * 
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 * 
 * @author abhigupta
 *
 */
public class MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> l = new ArrayList<String>();

		if (nums == null || nums.length == 0) {
			l.add(getDiff(lower, upper)); // Trick
			return l;
		}
		int s = lower - 1;
		int i = 0;
		String d = null;
		while (i < nums.length) {

			int p = s;
			while (i + 1 < nums.length && p + 1 == nums[i]) {
				p = nums[i];
				i++;
			}
			d = getDiff(p + 1, nums[i] - 1);

			if (d != null) {
				l.add(d);
			}
			s = nums[i];

			i++;

		}

		d = getDiff(nums[i - 1] + 1, upper);
		if (d != null) {
			l.add(d);
		}
		return l;
	}

	String getDiff(int s, int e) {

		if (s > e) {
			return null;
		}
		if (s == e) {
			return "" + s;
		}
		return s + "->" + e;

	}

}
