/***
 * 
 * 
 *  347. Top K Frequent Elements 
 *  
 *   Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer> l = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<>();
		if (nums == null || nums.length == 0) {
			return l;
		}

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Integer> ar[] = new List[nums.length + 1];

		for (int i : map.keySet()) {
			int f = map.get(i);

			if (ar[f] == null) {
				ar[f] = new LinkedList<Integer>();
			}
			ar[f].add(i);
		}

		for (int i = ar.length - 1; i >= 0 && l.size() < k; i--) {
			if (ar[i] != null) {
				l.addAll(ar[i]);
			}
		}
		return l;

	}

}
