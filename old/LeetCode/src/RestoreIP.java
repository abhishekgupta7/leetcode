import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * 93. Restore IP Addresses 
 * @author abhigupta
 *
 *
 *Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 */
public class RestoreIP {

	

    public List<String> restoreIpAddresses(String s) {
       List<String> res = new ArrayList<String>();
       int len = s.length();
       for(int i = 1; i<4 && i<len-2; i++){
            String s1 = s.substring(0,i);
            if(!isValid(s1)){
                continue;
            }
           for(int j = i+1; j<i+4 && j<len-1; j++){
                String s2 = s.substring(i,j);
                if(!isValid(s2)){
                    continue;
                }
               for(int k = j+1; k<j+4 && k<len; k++){
                    String s3 = s.substring(j,k);
                    if(!isValid(s3)){
                        continue;
                    }
                  String  s4 = s.substring(k,len);
                   if( isValid(s4)){
                       res.add(s1+"."+s2+"."+s3+"."+s4);
                   }
               }
           }
       }
       return res;
   }
   public boolean isValid(String s){
       if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
           return false;
       return true;
   }

}
