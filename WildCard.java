import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/wildcard-matching/description/
 * 44. Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

 * @author abhigupta
 *
 */
public class WildCard {
	public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
       while (s < str.length()){
           // advancing both pointers
           if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
               s++;
               p++;
           }
           // * found, only advancing pattern pointer
           else if (p < pattern.length() && pattern.charAt(p) == '*'){
               starIdx = p;
               match = s;
               p++;
           }
          // last pattern pointer was *, advancing string pointer
           else if (starIdx != -1){
               p = starIdx + 1;
               match++;
               s = match;
           }
          //current pattern pointer is not star, last patter pointer was not *
         //characters do not match
           else return false;
       }
       
       //check for remaining characters in pattern
       while (p < pattern.length() && pattern.charAt(p) == '*')
           p++;
       
       return p == pattern.length();
   }
 	
 	public static void main(String st[]) {
 		
 		System.out.println(new WildCard().isMatch("abdc", "a*c"));
 	}
 	
 	
 	  public boolean isMatch1(String s, String p) {
 	        
 	        if(s == null && p == null) {
 	            return true;
 	        }
 	        
 	        return isMatch(s.toCharArray(), 0, trim(p.toCharArray()), 0, new HashMap<>());
 	        
 	    }
 	    
 	    char[] trim(char ch[]) {
 	        
 	        char n[] = new char[ch.length];
 	        int ps = -1;
 	        int np = 0;

 	        for(int i=0;i<n.length;i++) {
 	            
 	            if(ch[i] == '*') {
 	                if(ps == -1) {
 	                    n[np++] = ch[i];
 	                }
 	                ps = i;
 	            }else {
 	                n[np++] = ch[i];
 	                 ps = -1;
 	            }
 	        
 	            
 	        }
 	        char r[] = new char[np];
 	        
 	        for(int i=0;i<np;i++) {
 	            r[i] = n[i];
 	        }
 	        
 	        return r;
 	        
 	        
 	    }
 	    
 	    public boolean isMatch(char s[], int ps,  char p[], int pp, Map<String, Boolean> map) {
 	        
 	        if(map.containsKey(ps+"-"+pp)) {
 	            return map.get(ps+"-"+pp);
 	        }
 	        
 	        if(s.length == ps && p.length == pp) {
 	            
 	            map.put(ps+"-"+pp, true);
 	            return true;
 	        }
 	        
 	        if(p.length <= pp) {
 	             map.put(ps+"-"+pp, false);
 	            return false;
 	            
 	        }
 	        if(p[pp] == '*') {
 	            
 	            for(int i=ps;i<=s.length;i++) {
 	                
 	                if(isMatch(s, i, p,pp+1, map)) {
 	                    
 	                    map.put(ps+"-"+pp, true);
 	                    return true;
 	                }
 	            }
 	            map.put(ps+"-"+pp, false);
 	            return false;
 	            
 	        }
 	        if(s.length <= ps) {
 	            map.put(ps+"-"+pp, false);
 	            return false;
 	        }
 	        
 	        if(s[ps] == p[pp] || p[pp] == '?') {
 	            return isMatch(s, ps+1, p, pp+1, map);
 	        }
 	        map.put(ps+"-"+pp, false);
 	        return false;
 	    }
}
