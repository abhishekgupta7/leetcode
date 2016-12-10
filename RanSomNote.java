/**
 * 
 * https://leetcode.com/problems/ransom-note/
 * 
 *
 */
public class RanSomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        
        if(ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
      
        if(magazine == null  || magazine.length() == 0) {
            return false;
        }
        int count[] = new int[26];
        for(char ch : magazine.toCharArray()) {
            
            count[ch-'a']++;
        }
        
        for(char ch : ransomNote.toCharArray()) {
            int c = count[ch-'a'];
            if(c == 0 ) {
                return false;
            }else {
                count[ch-'a']--;
            }
        }
        return true;
    }

}
