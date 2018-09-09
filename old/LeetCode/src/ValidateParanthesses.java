import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/***
 * https://leetcode.com/problems/valid-parentheses/
 * 

    Total Accepted: 124589
    Total Submissions: 408274
    Difficulty: Easy

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

#google

 * 20. Valid Parentheses
 * @author abhigupta
 *
 */
public class ValidateParanthesses {

	

    public boolean isValid(String s) {
        
        if(s == null || s.length() ==0 ) {
            return true;
        }
        
        Map<Character,Character> map = new HashMap<Character,Character>();
        
        map.put('{','}');
        map.put('(',')');

        map.put('[',']');

        Stack<Character> st = new Stack<Character>();
        
        int i =0;
        while(i<s.length()) {
            
            if(map.containsKey(s.charAt(i))) {
                st.push(map.get(s.charAt(i)));
            }else {
                
                if(st.size() ==0  || !(st.pop().equals(s.charAt(i)))) {//fix
                    return false;
                }
            }
            i++;
        }
        return (st.size()==0);
    }

}
