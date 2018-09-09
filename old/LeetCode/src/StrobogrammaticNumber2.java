import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 * 247. Strobogrammatic Number II

    Total Accepted: 11172
    Total Submissions: 31197
    Difficulty: Medium

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"]. 
 * @author abhigupta
 *
 */
public class StrobogrammaticNumber2 {

    static Map<Character, Character > map = new HashMap<Character, Character>();
static{
    map.put('0','0');

    map.put('8','8');
    map.put('1','1');
    map.put('6','9');
    map.put('9','6');
}
public List<String> findStrobogrammatic(int n) {
      List<String> list = new ArrayList<String>();
    if(n<1) {
        list.add("");
        return list;
    }
    if(n==1){
        return getForOdd("");
    }
      int even = (n/2)*2;
  
    list = getForEven("",0,even);
    if(n == even) {
        return list;
    }  
    List<String> r = new ArrayList<>();
    for(String s:list) {
        
        List<String> odd = getForOdd(s);
        r.addAll(odd);
    }
    
    return r;
    
}

public List<String> getForEven(String s, int d, int n) {
    
    List<String> list = new ArrayList<>();
    
    if(d==n) {
        list.add(s);
        return list;
    }
    
    for(char ch : map.keySet()) {
        
        if(ch == '0' && s.length()==0) {
            continue;
        }
        String ns = s.substring(0,s.length()/2)+ch+map.get(ch)+s.substring(s.length()/2);
       List<String> l = getForEven(ns,d+2,n);
       list.addAll(l);
    }
    
    return list;
    
}

public List<String> getForOdd(String s) {
    
    List<String> list = new ArrayList<>();
    
  
    for(char ch : map.keySet()) {
        
        if(ch == '6' || ch == '9') {
            continue;
        }
        String n = s.substring(0,s.length()/2)+ch+s.substring(s.length()/2);
      
       list.add(n);
    }
    
    return list;
    
}

}
