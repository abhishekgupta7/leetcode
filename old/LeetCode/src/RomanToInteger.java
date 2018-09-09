import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 13. Roman to Integer
 * @author abhigupta
 *
 */
public class RomanToInteger {
	

    
	private static final int[] values = {
	1000, 500,
	100,  50, 
	10,  5, 
	1
	};
	private static final Character[] symbols = {
	'M',  'D', 
	'C', 'L', 
	'X',  'V',
	'I'
	};
	Map<Character,Integer> map = new HashMap<Character, Integer>();
	
public int romanToInt(String s) {
   
    if(s== null || s.length() ==0 ){
        return 0;
    } 
    for(int i =0;i<values.length;i++){
        map.put(symbols[i],values[i]);
    }
    
   
    
    int pre=0;
    int r=0;
    int c ;
    int i =0;
    
    
    while(i<s.length()) {
        
        c = map.get(s.charAt(i));
        
        if(c>pre) {
            r = r+c-2*pre;
        }else {
            r = r +c;
        }
        pre = c;
        i++;
    }
    return r;

}


}
