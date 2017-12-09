import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/accounts-merge/description/
 * 
 *  721. Accounts Merge 
 *  
 *  Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:

Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

Note:
The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 * @author abhigupta
 *
 */
public class AccountsMerge {
	
public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        if(accounts == null) {
            return null;
        }
        
        Map<String, String[]> map = new HashMap<>();
        int i = 0;
        Map<Integer, Integer> idMapping = new HashMap<>();
        for(List<String> account : accounts) {
            
            Iterator<String> it  = account.iterator();
            String name =  it.next();
            while(it.hasNext()) {
                String email = it.next();
                String data[] = map.get(email);
                
                if(data != null && data[0].equals(name)) {
                   idMapping.put(Integer.parseInt(data[1]), i);
                }else {
                    data = new String[] {name,""+i};
                    map.put(email, data);
                }
            }
            i++;
        }
        
        Map<Integer, Set<String>> m = new HashMap<>();
        Map<Integer,String> names = new HashMap<>();
        i = 0;
        for(List<String> account : accounts) {
            
            Integer parent = idMapping.get(i);
            Iterator<String> it  =  account.iterator();
            Set<String> set = null;
            if(parent == null) {
                set = new TreeSet<>();
                m.put(i,set);
                names.put(i, it.next());
            }else {
                set = m.get(parent);
                it.next();
            }
            while(it.hasNext()) {
             set.add(it.next());   
            }
            
        }
        List<List<String>> ans = new ArrayList<>();
        
        for(int pos : m.keySet()) {
            
            String name = names.get(i);
            List<String> l = new ArrayList<>();
            
            l.add(name);
            l.addAll(m.get(pos));
            ans.add(l);
        }
        return ans;
        
    }

}
