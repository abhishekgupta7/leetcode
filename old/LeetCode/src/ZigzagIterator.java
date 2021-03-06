import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/zigzag-iterator/
 * 281. Zigzag Iterator

    Total Accepted: 12411
    Total Submissions: 27566
    Difficulty: Medium

Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]

It should return [1,4,8,2,5,9,3,6,7]. 
 * @author abhigupta
 *
 */

public class ZigzagIterator {

	Queue<Iterator> q = new LinkedList<Iterator>();

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

		Iterator<Integer> it1 = v1.iterator();
		Iterator<Integer> it2 = v2.iterator();

		if (it1.hasNext()) {
			q.add(it1);
		}
		if (it2.hasNext()) {
			q.add(it2);
		}
	}

	public int next() {
		Iterator<Integer> it = q.remove();
		int r = it.next();
		if (it.hasNext()) {
			q.add(it);
		}

		return r;
	}

	public boolean hasNext() {
		return q.size() != 0;
	}

}
