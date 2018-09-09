/**
 *  Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.

Example 2:

str = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.

Example 3:

str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.

 * 358. Rearrange String k Distance Apart
 * 
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * @author abhigupta
 *#google
 */
public class RearrangeStringkDistanceApart {
	

    public String rearrangeString(String str, int k) {
     
     
     if(str == null || str.length() ==0 || k<2) {
         return str;
     }   
     int count[] = new int[26];
     int nextp[] = new int[26];
    // str = str.toLowerCase();
     
     StringBuilder sp = new StringBuilder();
     for(int i=0;i<str.length();i++) {
         
         count[str.charAt(i)-'a'] ++;
         
     }
     
     for(int i =0; i<str.length();i++) {
         
         int p = getValidNumber(i, nextp,count);
         if(p == -1) {
             return "";
         }
         nextp[p] = i+k;
         count[p] --;
         sp.append((char)(p+'a'));
         
     }
     return sp.toString();
     
    }
    
    private int getValidNumber(int cp, int nextp[], int count[]) {
        int max = 0;
        int and = -1;
        
        for(int i =0;i<count.length;i++) {
            
            if(count[i]>0 && nextp[i]<=cp && count[i]>max) {
                
                max = count[i];
                and = i;
            }
            
            
        }
        return and;
        
        
    }


}
