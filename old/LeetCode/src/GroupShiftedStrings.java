import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 * 249. Group Shifted Strings
 * @author abhigupta
 * #Uber #Google
 *
 */
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        
        
        List<List<String>> list = new ArrayList<List<String>>();
        
        if(strings == null || strings.length ==0) {
            
            return list;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings) {
            
            
            char ch[] = s.toCharArray();
            
            int diff = ch[0] - 'a';
            
            StringBuffer sb = new StringBuffer();
            
            for(char c : ch){
                
                int n = c - diff-'a';
                if(n < 0) {
                    n = n+ 26;
                }
                sb.append(""+(char)(n+'a'));
               
            }
             String key = sb.toString();
               List<String> l = map.get(key);
                if(l == null) {
                    
                    l = new ArrayList<String>();
                }
                l.add(s);
                map.put(key,l);
                
        }
        
        for(String k : map.keySet()) {
            List<String> l = map.get(k);

            Collections.sort(l);
            list.add(l);
        }
        return list;
    }
    
    public static void main(String st[]) {
    	
    	
    	System.out.println( new GroupShiftedStrings().groupStrings(new String[]{"abc","bcd"}));
    }

}
