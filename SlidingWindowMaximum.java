import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * @author abhigupta
 *
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {

		int r[] = new int[nums.length - k + 1];

		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		Deque<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			while (!q.isEmpty() && q.getLast() < nums[i]) {
				q.pollLast();
			}
			q.addLast(nums[i]);
		}

		int s = 0;
		int ri = 0;
		for (int i = k; i < nums.length; i++) {
			r[ri++] = q.getFirst();
			if (nums[s++] == q.getFirst()) {
				q.removeFirst();
			}

			while (!q.isEmpty() && q.getLast() < nums[i]) {
				q.pollLast();
			}
			q.addLast(nums[i]);

		}
		r[ri] = q.getFirst();
		return r;

	}

}
