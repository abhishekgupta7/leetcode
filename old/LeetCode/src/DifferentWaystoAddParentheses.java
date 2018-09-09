import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 241. Different Ways to Add Parentheses
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * 
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1

Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2

Output: [0, 2]

Example 2

Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Output: [-34, -14, -10, -10, 10]
 * @author abhigupta
 *
 */
public class DifferentWaystoAddParentheses {

	Set<Character> set = new HashSet<Character>();
	Map<String, List<Integer>> map = new HashMap<>();

	public List<Integer> diffWaysToCompute(String input) {
		set.add('+');
		set.add('-');
		set.add('*');

		return getValues(input);
	}

	public List<Integer> getValues(String s) {

		List<Integer> list = new ArrayList();

		if (s == null || s.length() == 0) {
			return list;
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}

		int i = 0;
		char ch;
		boolean f = false;
		while (i < s.length()) {

			ch = s.charAt(i);
			if (set.contains(ch)) {

				List<Integer> l1 = getValues(s.substring(0, i));
				List<Integer> l2 = getValues(s.substring(i + 1));

				getCalValues(l1, ch, l2, list);

			}

			i++;
		}
		if (list.size() == 0)
			list.add(Integer.parseInt(s));
		map.put(s, list);
		return list;

	}

	public void getCalValues(List<Integer> l1, Character ch, List<Integer> l2, List<Integer> list) {

		for (Integer num : l1) {
			for (Integer v : l2) {

				switch (ch) {

				case '-':
					list.add(num - v);
					break;
				case '+':
					list.add(num + v);
					break;
				case '*':
					list.add(num * v);
					break;
				default:
					continue;
				}

			}

		}

	}

}
