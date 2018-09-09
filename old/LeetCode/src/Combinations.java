import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 
 * 
 * @author abhigupta
 *
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> l = new ArrayList<List<Integer>>();//mistake
		List<Integer> list = new ArrayList<Integer>();
		combine(n, k, l, list, 1);
	//	System.out.println(l);
		return l;

	}

	public void combine(int n, int k, List<List<Integer>> l,
			List<Integer> list, int s) {

		if (list.size() == k) {
			l.add(list);
			return;
		}

		for (int i = s; i <= n; i++) {

			List<Integer> ll = new ArrayList<Integer>();//TODO why LinkedList is bad than ArrayList
			ll.addAll(list);// mistake
			ll.add(i);
			combine(n, k, l, ll, i + 1);
		}

	}


}
