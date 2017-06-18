/**
 *  350. Intersection of Two Arrays II 
 *   Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArrays {

	public int[] intersect(int[] nums1, int[] nums2) {

		if (nums1 == null || nums2 == null) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Integer> list = new LinkedList<>();

		for (int i : nums2) {

			Integer v = map.getOrDefault(i, 0);
			if (v > 0) {
				list.add(i);
				map.put(i, map.get(i) - 1);
			}

		}

		int r[] = new int[list.size()];
		int i = 0;
		for (int v : list) {

			r[i++] = v;
		}
		return r;

	}

}
