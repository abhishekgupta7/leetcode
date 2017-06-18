/***
 *  227. Basic Calculator II 
 *  https://leetcode.com/problems/basic-calculator-ii/#/description
 *  
 *  Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5

Note: Do not use the eval built-in library function. 
 * @author abhigupta
 *
 */
public class BasicCalculatorII {
	

    public int calculate(String s) {
        
        if(s== null || s.length() ==0 ) {
            return 0;
        }
        
        char sign = '+';
        int r =0;

        int num =0;
        int i =0;
        //int r = 0;
        int pre = 0;
        while(i<s.length()) {
            
            
            char ch = s.charAt(i++);
            if(ch == ' ') {

                continue;
            }
            if(!Character.isDigit(ch)) {
           
              sign = ch;
          
           
            }else{
                
                num = num*10+ch-'0';
               
               if(i<s.length() && Character.isDigit(s.charAt(i))) {
                    continue;
                }
                if(sign == '+') {
                    //st.push(num);
                    r = r+num;
                    pre = num;
                    
                }
                 if(sign == '-') {
                   // st.push(-num);
                     r = r-num;
                      pre = -num;
                     
                 }
                 if(sign == '*') {
                  //  st.push(st.pop()*num);
                    
                     r = r-pre+pre*num;
                     pre = pre*num;
                }
                 if(sign == '/') {
                    //st.push(st.pop()/num);
                    
                    r = r -pre+pre/num;
                   pre = pre/num;
              }
              
              num =0;

        }
       
        }
        
        return r;
    
        
    }


}
