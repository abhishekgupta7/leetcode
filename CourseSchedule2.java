import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/course-schedule-ii/#/description
 *  210. Course Schedule II 
 * @author abhigupta
 * 
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]

There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

 *
 */
public class CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null
				|| prerequisites[0].length == 0) {

			int[] rArray = new int[numCourses];

			for (int i = 0; i < numCourses; i++) {
				rArray[i] = i;
			}
			return rArray;
		}

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int count[] = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {

			List<Integer> list = map.get(prerequisites[i][1]);

			if (list == null) {
				list = new LinkedList<Integer>();
				map.put(prerequisites[i][1], list);
			}
			list.add(prerequisites[i][0]);
			count[prerequisites[i][0]]++;
		}

		Queue<Integer> q = new LinkedList<>();
		
		int i = 0;
		while (i < numCourses) {
			if (count[i] == 0) {
				q.offer(i);
			}
			i++;
		}
		List<Integer> r = new ArrayList<>();

		while (q.size() != 0) {

			int c = q.poll();
			r.add(c);
			List<Integer> list = map.get(c);
			if (list != null) {
				for (int d : list) {

					count[d]--;
					if (count[d] == 0) {
						q.offer(d);
					}
				}
			}

		}

		if (r.size() != numCourses) {
			return new int[0];
		}
		int[] rArray = new int[r.size()];
		int p = 0;
		for (int c : r) {
			rArray[p++] = c;
		}
		return rArray;

	}

}
