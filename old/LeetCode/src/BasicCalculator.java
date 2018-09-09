import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 * 
 * 224. Basic Calculator
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:

"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

Note: Do not use the eval built-in library function. 
 * @author abhigupta
 *
 */
public class BasicCalculator {

    

    public int calculate(String s) {
        
        
    int len = s.length(), sign = 1, result = 0;
	Stack<Integer> stack = new Stack<Integer>();
	
	for (int i = 0; i < len; i++) {
	    
		if (Character.isDigit(s.charAt(i))) {
		    int p =i;    
			while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
				i++;
			}
			
			int temp  = Integer.parseInt(s.substring(p,i+1));
			
		    result = result +(sign*temp);

		} else if (s.charAt(i) == '+')
			sign = 1;
		else if (s.charAt(i) == '-')
			sign = -1;
		else if(s.charAt(i) == '(') {
		    stack.push(result);
		    stack.push(sign);

		    result =0;
		    sign = 1;
		}else if(s.charAt(i) == ')') {
		    result = (stack.pop() *result) + stack.pop() ;
		}		
	

	}
	
	return result;
        
    }
    

}
