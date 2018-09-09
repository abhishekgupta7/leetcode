/**
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
17. Letter Combinations of a Phone Number
    Total Accepted: 91802
    Total Submissions: 305345
    Difficulty: Medium

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationToPhone {

	


    static Map<Character, String> map = new HashMap<>();
    
    static{
        
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        
        
    }
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits == null || digits.length() ==0){
            return list;
        }
               list.add("");        

        for(int i=0;i<digits.length();i++) {
            
            int s = list.size();
            while(s>0) {
                s--;
                String cur = list.remove(0);
                
                for(char ch : map.get(digits.charAt(i)).toCharArray()) {
                    list.add(cur+ch);
                }
                
                
            }
        }
            return list;

    }
    
   

}
