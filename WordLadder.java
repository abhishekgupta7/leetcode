import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	
	public static void main (String st[]) {
		
		
		String[] d = {"hot","dot","dog","lot","log"};
		
		Set<String> s = new HashSet<>();
		
		for(String ss : d) {
			s.add(ss);
		}
		System.out.println( new WordLadder().ladderLength("hit", "dot", s));
		
	}

   
	
	

	public int ladderLength(String beginWord, String endWord, Set<String> dict) {

		if (beginWord == null || endWord == null || dict == null || dict.size() == 0) {
			return 0;
		}
		dict.add(endWord);
		Map<String, Set<String>> map = new HashMap<>();

		for (String s : dict) {

			if (s.length() == beginWord.length()) {

				for (int j = 0; j < s.length(); j++) {

					String key = replace(s, j, '*');
					Set<String> set = map.get(key);

					if (set == null) {
						set = new HashSet<>();
						map.put(key, set);
					}
					set.add(s);

				}
			}
		}
		if (map.size() == 0) {
			return 0;
		}
		int level = 1;

		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		Set<String> seen = new HashSet<>();
		while (q.size() != 0) {

			int size = q.size();

			while (size != 0) {

				size--;

				String poll = q.poll();
				

				seen.add(poll);
				if (poll.equals(endWord)) {
					return level;
				}
				for (int j = 0; j < poll.length(); j++) {

					String key = replace(poll, j, '*');
					Set<String> next = map.get(key);
					if(next != null) { 
						
						for(String s : next) {
							
							if(!seen.contains(s)) {
								q.offer(s);
							}
						}
						
						
					}
				}

			}

			level++;

		}

		return 0;
	}

	private static String replace(String s, int index, char c) {
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);
	}


}