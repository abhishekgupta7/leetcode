package com.abhig.questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortingFrequency {
	// package whatever; // don't place package name!

	// 3, 3, 7, 7, 7, 5, 5, 18 input
	// 7, 7, 7, 3, 3, 5, 5, 18 output

	// 5, 3, 3, 7, 7, 7, 5, 18 input
	// 7, 7, 7, 5, 5, 3, 3, 18 output
	
	class MyComparator implements Comparator<int []> {
		
		
		public int compare(int[] o1, int[] o2) {
			if(o1[1]>o2[1]) {
				return 1;
			}
			return -1;
		}

				
	}

	int[] getFrequencySorted(int array[]) {

		if (array == null || array.length == 0) {

			return array;// throw an exce
		}

		Map<Integer, Integer> count = new HashMap<>();

		Map<Integer, Integer> pos = new HashMap<>();

		int max = 0;

		for (int i = 0; i < array.length; i++) {

			int val = array[i];

			count.put(val, count.getOrDefault(val, 0) + 1);

			if (!pos.containsKey(val)) {

				pos.put(val, i);

			}
			max = Math.max(count.get(val), max);

		}

		PriorityQueue<int[]>[] sort = new PriorityQueue[max + 1];

		for (int key : count.keySet()) {

			int val = count.get(key);

			if (sort[val] == null) {

				sort[val] = new PriorityQueue<>(1, new MyComparator());

			}
			sort[val].add(new int[]{key,pos.get(key)});

		}

		int res[] = new int[array.length];

		int p = 0;

		for (int i = sort.length - 1; i >= 0; i--) {

			PriorityQueue<int[]> list = sort[i];
			if(list == null) {
				continue;
			}
			
			while(!list.isEmpty()) {
				
				int[] val = list.poll();
				
				for (int j = 1; j <= i; j++) {
					res[p++] = val[0];

				}
			}
			

		}

		return res;

	}


	
	public static void main(String st[]) {
		
		
		int [] array= {4,7,7,7,4,3,1};
		int[] sorted = new SortingFrequency().getFrequencySorted(array);
		for(int i : sorted) {
			System.out.print(i+",");
		}
		
		
		
		
	}

}
