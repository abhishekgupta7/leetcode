/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 #AMZ
#Adobe
#Bloom
#yelp
 *
 */

import java.util.Arrays;

public class LongestSubstringWithoutRepChar {

    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() ==0 ) {
            return 0;
        }
         int p[] = new int[256];
        
        
        Arrays.fill(p, -1);
       
       int st = 0;
       int max = -1;
       for(int i =0 ;i<s.length();i++) {
           
           if(p[s.charAt(i)] <st) { //tricky p[s.charAt(i)] ==0
               p[s.charAt(i)] = i;
              
           }else {
               
               max = Math.max(max, i-st);
            
               st = p[s.charAt(i)]+1;//tricky not st = i
               p[s.charAt(i)] = i;

           }

       }
           max = Math.max(max, s.length()-st);
           return max; 
    }

}
