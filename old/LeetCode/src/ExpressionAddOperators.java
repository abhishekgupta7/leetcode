import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 282. Expression Add Operators
 * 
 * https://leetcode.com/problems/expression-add-operators/
 *  Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples:

"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []

Credits:
Special thanks to @davidtan1890 for adding this problem and creating all test cases.
 * @author abhigupta
 *
 */
public class ExpressionAddOperators {

    
	public List<String> addOperators(String num, int target) {

	List<String> s = new ArrayList<String>();

	if (num == null || num.length() == 0) {
		return s;
	}
	addOperators(num, target, null, s, "", 0);


	return s;

}

public void addOperators(String num, int target, Long sum,
		List<String> sList, String s, long pre) {

	// System.out.println(s + "pre=" + pre);

	
	if (sum != null && target == sum && num.length() == 0) {
		sList.add(s);
		return;
	}
	if (num.length() == 0) {
		return;
	}

	for (int i = 0; i < num.length(); i++) {

		String sub = num.substring(0, i + 1);
		if (sub.length()>1&&sub.startsWith("0")) {
			continue;
		}
		long n = Long.parseLong(sub);

        if(sum == null) {
            addOperators(num.substring(i + 1), target, n, sList, sub , n);
        } else {
			addOperators(num.substring(i + 1), target, sum + n, sList, s + "+"
					+ sub, n);

			addOperators(num.substring(i + 1), target, sum - pre + n * pre, sList, s + "*" + sub, n * pre); // learn

			addOperators(num.substring(i + 1), target, sum - n, sList, s + "-"
					+ sub, -n);
	
        }				
	}

}

}
