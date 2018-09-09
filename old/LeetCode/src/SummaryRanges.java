import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * 
 * 228. Summary Ranges
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author abhigupta
 *
 */
public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {

		List<String> l = new LinkedList<>();

		if (nums == null || nums.length == 0) {
			return l;
		}
		int i = 0;
		while (i < nums.length) {

			int p = i;

			while (p + 1 < nums.length && nums[p] + 1 == nums[p + 1]) {
				p++;
			}
			if (p == i) {
				l.add("" + nums[i]);
			} else {
				l.add(nums[i] + "->" + nums[p]);
			}
			i = p + 1;

		}

		return l;

	}

}
