import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * 269. Alien Dictionary
 * 
 * https://leetcode.com/problems/alien-dictionary/
 * 
 *  There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

The correct order is: "wertf".

Note:

    You may assume all letters are in lowercase.
    If the order is invalid, return an empty string.
    There may be multiple valid order of letters, return any one of them is fine.

 * @author abhigupta
 *
 */
public class AlienDictionary {
	

    
	public String alienOrder(String[] words) {
	    Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
	    Map<Character, Integer> degree=new HashMap<Character, Integer>();
	    String result="";
	    if(words==null || words.length==0) return result;
	    for(String s: words){
	        for(char c: s.toCharArray()){
	            degree.put(c,0);
	            map.put(c, new HashSet<Character>());
	        }
	    }
	    for(int i=0; i<words.length-1; i++){
	        String cur=words[i];
	        String next=words[i+1];
	        int length=Math.min(cur.length(), next.length());
	        for(int j=0; j<length; j++){
	            char c1=cur.charAt(j);
	            char c2=next.charAt(j);
	            if(c1!=c2){
	                Set<Character> set= map.get(c1);
	                
	                if(!set.contains(c2)){
	                    set.add(c2);
	                    degree.put(c2, degree.get(c2)+1);
	                }
	                break;
	            }
	        }
	    }
	    Queue<Character> q=new LinkedList<Character>();
	    for(char c: degree.keySet()){
	        if(degree.get(c)==0) q.add(c);
	    }
	    StringBuilder sb = new StringBuilder();
	    
	    while(!q.isEmpty()){
	        char c=q.remove();
	        
	        sb.append(c);
            for(char c2: map.get(c)){
                degree.put(c2,degree.get(c2)-1);
                if(degree.get(c2)==0) q.add(c2);
            }
	        
	    }
	    if(sb.length() !=degree.size()) return "";
	    return sb.toString();
	}
	
	public static void main(String st[]) {
		
		String s[] = {"qaswedcfg"};
		System.out.println(new AlienDictionary().alienOrder(s));
		
	}




}
