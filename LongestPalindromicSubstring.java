/**
 * 
 * 
 * 5. Longest Palindromic Substring
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author abhigupta
 *
 */
public class LongestPalindromicSubstring {

	

    public String longestPalindrome(String s) {
        
        
	    if(s == null || s.length() ==0){
			return s;
		}
		int count = 0;
		int p = 0;
		int len = 0;
		for(int i =0 ;i<s.length();i++ ){
			
			len = getLenght(s,i, i);
			count = Math.max(count, len);
			if(count == len ){
				p = i;
			}
		}
        count--;
		String odd = s.substring(p-count,p+count+1);
		count = 0;
		p=0;
		for(int i =0 ;i<s.length();i++ ){
			
			len = getLenght(s, i, i+1);
			count = Math.max(count, len);
			if(count == len ){
				p = i;
			}
		} 

		String even =  s.substring(p-count+1,p+count+1); //imp
		
		return even.length() > odd.length() ? even:odd;
	    
    }
    
    public int getLenght(String st, int s, int e) {

		int count = 0;
		while (s >= 0 && e <= st.length() - 1 && st.charAt(s) == st.charAt(e)) {
			s--;
			e++;
			count++;
		}

		return count*2;
	}
	
	


}
