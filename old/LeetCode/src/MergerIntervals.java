import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/ Given a collection of
 * intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 56. Merge Intervals
 * 
 * @author abhigupta
 *
 */


enum Position {

	left, right, mid
}



class TreeIntervalNode {

	Interval value;

	TreeIntervalNode left;
	TreeIntervalNode right;

}



 class Interval {
	   int start;
	   int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
 
 
 public class MergerIntervals {
	 
	 
	 public static void main(String st[]) {
		 
		 List<Interval> it  = new LinkedList<>();
		 
		 it.add( new Interval(1,3));
		 it.add( new Interval(1,3));

		 System.out.println(new MergerIntervals().merge(it));
		 
	 }

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;

		// Sort by ascending starting point using an anonymous Comparator
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});

		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
										// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}
	

    

	public List<Interval> merge_optimize(List<Interval> intervals) {

		List<Interval> list = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0) {
			return list;
		}
		
		TreeIntervalNode root = null;
		
	

		for(Interval l : intervals) {
			
			root = add(root, l);
		}
		
		getAll(root,list);
		
		
		if(list.size() !=  intervals.size()){
			return merge(list);
		}
		return list;

	}
	
	
	public void getAll(TreeIntervalNode root, List<Interval> list){
		
		
		if(root == null)
			return ;
		
		getAll(root.left, list);
		list.add(root.value);
		getAll(root.right, list);

		
	}
	public TreeIntervalNode add(TreeIntervalNode root, Interval vaInterval) {

		if (root == null) {
			TreeIntervalNode node = new TreeIntervalNode();
			node.value = vaInterval;
			return node;
		}
		Position p = comPosition(root.value, vaInterval);

		if (p == Position.mid) {
			root.value = merge(root.value, vaInterval);
			;
		} else if (p == Position.left) {

			root.left = add(root.left, vaInterval);
		} else {

			root.right = add(root.right, vaInterval);
		}
		return root;

	}

	public Interval merge(Interval s1, Interval s2) {

		Interval s = new Interval();

		if (s1.start > s2.start) {

			s.start = s2.start;
		} else {
			s.start = s1.start;

		}

		if (s1.end < s2.end) {

			s.end = s2.end;
		} else {
			s.end = s1.end;

		}

		return s;

	}

	public Position comPosition(Interval s1, Interval s2) {
		
		

		if (s1.end < s2.start) {
			return Position.right;
		}

		if (s1.start > s2.end) {
			return Position.left;
		}
		return Position.mid;
	}


}
