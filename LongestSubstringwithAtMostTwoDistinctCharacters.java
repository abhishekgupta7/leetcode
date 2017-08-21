/**https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 159. Longest Substring with At Most Two Distinct Characters
 *  Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3. 
 * @author abhigupta
 *
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null ){
            return 0;
        }
        
        int c[] = new int[256];
        
        int dis = 0;
        int st =0;
        int max =0;
        int k =2;
        for(int i=0;i <s.length() ;i++) {
            
            char ch = s.charAt(i);
            
            if(c[ch] ==0){
                dis++;
            }
            c[ch]++;
            while(dis>k){
                
                if(c[s.charAt(st)] == 1){
                    dis--;
                }
                c[s.charAt(st)] --;
                st++;
                
                
            }
            max = Math.max(max,i- st+1);
            
            
        }
        return max;
    }
}
