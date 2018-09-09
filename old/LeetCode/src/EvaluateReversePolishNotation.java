import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * 150. Evaluate Reverse Polish Notation
 * 
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/ Evaluate the
 * value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] ->
 * (4 + (13 / 5)) -> 6
 * 
 * @author abhigupta
 *
 */
public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {

		Set<String> set = new HashSet<String>();
		set.add("+");
		set.add("-");
		set.add("*");
		set.add("/");

		Stack<Integer> s = new Stack<Integer>();
		int r = 0;
		for (int i = 0; i < tokens.length; i++) {

			String t = tokens[i];
			if (!set.contains(t)) {

				s.push(Integer.parseInt(t));
			} else {
				r = 0;
				int v1 = s.pop();
				int v2 = s.pop();

				if (t.equals("+")) {
					r = v1 + v2;
				}
				if (t.equals("*")) {
					r = (v1 * v2);
				}
				if (t.equals("/")) {
					r = (v2 / v1);
				}
				if (t.equals("-")) {
					r = v2 - v1;
				}
				s.push(r);
			}

		}
		return s.pop();
	}

}
