import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
/**
 * 
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 * @author abhigupta
 *
 */
public class Dijkstra {

	int getMinCost(int[][] flights, int src, int des, int n) {

		Map<Integer, List<int[]>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {

			map.put(i,  new ArrayList<>());
		}
		for (int[] f : flights) {

			List<int[]> l = map.get(f[0]);
			int t[] = new int[] { f[1], f[2] };
			l.add(t);
			map.put(f[0], l);

		}
		

		int dis[] = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int d[] : map.get(src)) {

			dis[d[0]] = d[1];
		}
		Set<Integer> done = new HashSet<>();
		done.add(src);

		int cur = src;
		dis[src] = 0;
		while (cur != des) {

			int next = getMin(dis, done);
			if (next == -1) {
				return -1;
			}
			for (int d[] : map.get(next)) {
				dis[d[0]] = Math.min(dis[d[0]], d[1] + dis[next]);

			}
			done.add(next);
			cur = next;

		}

		return dis[des] == Integer.MAX_VALUE ? -1 : dis[des];

	}
	
	
	int getMin(int dis[], Set<Integer> set) {

		int min = Integer.MAX_VALUE;
		int mini = -1;
		for (int i = 0; i < dis.length; i++) {

			if (set.contains(i)) {
				continue;
			}
			if (min > dis[i]) {
				min = dis[i];
				mini = i;
			}

		}
		return mini;

	}
	
	int getMinCostWithK(int[][] flights, int src, int des, int n, int k) {

		Map<Integer, List<int[]>> map = new HashMap<>();

		
		for (int i = 0; i < n; i++) {

			map.put(i,  new ArrayList<>());
		}
		for (int[] f : flights) {

			List<int[]> l = map.get(f[0]);
			int t[] = new int[] { f[1], f[2] };
			l.add(t);
			map.put(f[0], l);

		}
		
		PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[]{src,0,k});
		while(!pq.isEmpty()) {
			
			int cur[] = pq.poll();
			
			if(cur[0] == des) {
				return cur[1];
			}
			
			if(cur[2] == -1){
				continue;
			}
			
			for (int d[] : map.get(cur[0])) {
				pq.add(new int[]{d[0],cur[1]+d[1],cur[2]-1});
				
			}
			
		}
		return -1;

	}
	
	int getMinCost2(int[][] flights, int src, int des, int n) {
		
		Map<Integer, List<int[]>> map = new HashMap<>();

		
		for (int i = 0; i < n; i++) {

			map.put(i,  new ArrayList<>());
		}
		for (int[] f : flights) {

			List<int[]> l = map.get(f[0]);
			int t[] = new int[] { f[1], f[2] };
			l.add(t);
			map.put(f[0], l);

		}
		boolean seen[] = new boolean[n];
		int dis[] = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		
		dis[src] = 0;
		
		int cur = src;
		while(!seen[cur]) {
			
			seen[cur] = true;
			for (int d[] : map.get(cur)) {
				dis[d[0]] = Math.min(dis[d[0]], d[1] + dis[cur]);
				parent[d[0]] = cur;
			}
			int maxD = Integer.MAX_VALUE;
			int next = 1;
			for (int i = 0; i < dis.length; i++) {
				if(!seen[i] && maxD> dis[i]) {
					next = i;
					maxD = next;
				}
				
			}
			cur = next;
			
		}

		return dis[des]  == Integer.MAX_VALUE ?-1 : dis[des];
	}

	public static void main(String st[]) {

		int flights[][] = { { 0,3,59 }, { 2,0,83 }, { 2,3,32 }, { 0,2,97 }, { 3,1,16 }, { 1,3,16 }

		};

		System.out.println(new Dijkstra().getMinCost(flights, 3, 0, 4));
		System.out.println(new Dijkstra().getMinCost2(flights, 3, 0, 4));
		System.out.println(new Dijkstra().getMinCostWithK(flights, 3, 0, 4,3));
		
		/*
		 * 4
[[0,3,59],[2,0,83],[2,3,32],[0,2,97],[3,1,16],[1,3,16]]
3
0
3
		 */


	}

}
