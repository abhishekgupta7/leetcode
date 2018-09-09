import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 
 * https://leetcode.com/problems/task-scheduler/#/description
 * 
 * @author abhigupta
 * 
 *         Given a char array representing tasks CPU need to do. It contains
 *         capital letters A to Z where different letters represent different
 *         tasks.Tasks could be done without original order. Each task could be
 *         done in one interval. For each interval, CPU could finish one task or
 *         just be idle.
 * 
 *         However, there is a non-negative cooling interval n that means
 *         between two same tasks, there must be at least n intervals that CPU
 *         are doing different tasks or just be idle.
 * 
 *         You need to return the least number of intervals the CPU will take to
 *         finish all the given tasks.
 * 
 *         Example 1:
 * 
 *         Input: tasks = ['A','A','A','B','B','B'], n = 2 Output: 8
 *         Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 *         Note:
 * 
 *         The number of tasks is in the range [1, 10000]. The integer n is in
 *         the range [0, 100].
 *
 * 
 */
public class TaskScheduler {

	public int leastInterval_1(char[] tasks, int n) {

		if (tasks == null || tasks.length == 0) {
			return 0;
		}
		int count[] = new int[26];

		for (char ch : tasks) {

			count[ch - 'A']++;
		}

		int time = 0;
		Arrays.sort(count);

		while (count[25] > 0) {

			int i = 0;

			while (i <= n) {

				if (count[25] == 0) {
					break;
				}
				if (i <= 25 && count[25 - i] > 0) {

					count[25 - i]--;
				}
				i++;
				time++;

			}
			Arrays.sort(count);

		}

		return time;
	}
	
	public static void main(String st[]) {
		
		char ch[] = new char[]{'A','A','A','B','B','B'};
		
		System.out.println(new TaskScheduler().leastInterval(ch, 0));
		
		
	}
	
	public int leastInterval(char[] tasks, int n) {
        
        if(tasks == null) {
            return 0;
        }
        
        int map[] = new int[26];
        
        for(char ch : tasks) {
            
            map[ch-'A']++;
            
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(26,Collections.reverseOrder());
        for(int c : map) {
            if(c == 0) {
                continue;
            }
            
            pq.add(c);
        }
        System.out.println(pq.size());
        int time = 0;
        
        while(!pq.isEmpty()) {
            
            int i =0;
            List<Integer> next = new LinkedList<>();
            
            while(i<=n) {
                
                
                int curr = pq.isEmpty() ? 0 : (pq.poll()-1);                
                if(curr !=0 ) {
                        next.add(curr);
                }
                time++;
                if(pq.isEmpty() && next.isEmpty()) {
                   break;
                }
                i++;
            }
            for(int l : next) {
            	pq.add(l);
            }
            
        }
        return time;
        
    }

}
