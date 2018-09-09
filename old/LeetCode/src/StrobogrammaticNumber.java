import java.util.HashMap;
import java.util.Map;

/***
 * 
 * 246. Strobogrammatic Number
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * https://leetcode.com/problems/strobogrammatic-number/
 * @author abhigupta
 *
 */
public class StrobogrammaticNumber {

    
    Map<Character, Character > map = new HashMap<Character, Character>();
    
    public boolean isStrobogrammatic(String num) {
        
        if(num == null || num.length() ==0) {
            return true;
        }
        map.put('0','0');

        map.put('8','8');
        map.put('1','1');
        map.put('6','9');
        map.put('9','6');

       // StringBuilder sb = new StringBuilder();
        int e =num.length()-1;
        int s  = 0;
        
        while(s<=e) {
            Character sc = map.get(num.charAt(s));
            if(sc == null || sc != num.charAt(e)) {
                return false;
            }
            s++;
            e--;
            
            
        }
      /*  while(i>=0) {
            
            Character c = map.get(num.charAt(i));
            if(c == null){
                return false;
            }
            sb.append(c);
            i--;
            
        }
        if(num.equals(sb.toString())) {
            return true;
        }
        */
        return true;
        
            
    }

}
