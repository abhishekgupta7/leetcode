import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/anagrams/ 
 * 49. Group Anagrams Given an array of
 * strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author abhigupta
 *
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		HashMap<String, List<String>> hm = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String currString = strs[i];
			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String sortString = new String(charArr);
			List<String> tempList = hm.getOrDefault(sortString, new ArrayList<String>());
			tempList.add(currString);
			hm.put(sortString, tempList);
		}
		return new ArrayList<>(hm.values());
	}

}
