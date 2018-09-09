
/**
 * https://leetcode.com/problems/unique-word-abbreviation/
 * 
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n

Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:

Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true

 * 288. Unique Word Abbreviation
 */
import java.util.HashMap;
import java.util.Map;

public class ValidWordAbbr {

	
	public static void main(String st[]){
		String s [] = {"deer", "deer", "cake", "card" };
		
		ValidWordAbbr vb = new ValidWordAbbr(s);
		
		System.out.println(vb.isUnique("deer"));
		
		
	}

    Map<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        
        for(String s: dictionary) {
            
            
            if(s != null) {
                
               String ab = getAb(s);
               String val = map.get(ab);
               if(val != null ){
                   
                   if(!val.equals(s))
                        map.put(ab,"");
               }else {
                   
                   map.put(ab,s);
               }
            }
        }
    }

    public boolean isUnique(String word) {
        
        String getAb = map.get(getAb(word));
        if(getAb == null){
            return true;
        }
        
       /* if(getAb.length() == 0 ){  //imp
            return false;
        }*/ 
        
        return getAb.equals(word);
        
    }
    
    String getAb(String st) {
        
        if(st.length()<3) {
            return st;
        }    
        return ""+st.charAt(0)+(st.length()-2)+st.charAt(st.length()-1);
        
    }
}