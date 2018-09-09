import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {
	private Queue<Integer> minHeap = null;
	private Queue<Integer> maxHeap = null;
	
	
	

	public double[] medianSlidingWindow(int[] nums, int k) {

		if (nums == null) {
			return null;
		}
		
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());

		double result[] = new double[nums.length - k + 1];

		for (int i = 0; i < k; i++) {
			add(nums[i]);

		}

		for (int i = k; i < nums.length + 1; i++) {

			result[i - k] = getMedian();
			if (!minHeap.remove(nums[i - k])) {
				maxHeap.remove(nums[i - k]);
			}
			if (i < nums.length)
				add(nums[i]);
			

		}
		return result;

	}

	void reBalance() {
		if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	void add(int num) {

		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		reBalance();
		
	}

	double getMedian() {

		return (minHeap.size() == maxHeap.size()) ? ((double) maxHeap.peek() + (double) minHeap.peek())/ 2.0 : (double)  maxHeap.peek();
		//not 		return (minHeap.size() == maxHeap.size()) ? (maxHeap.peek() + minHeap.peek() / 2.0) : maxHeap.peek();
        // not 		return (minHeap.size() == maxHeap.size()) ? (long)(maxHeap.peek() + minHeap.peek() / 2.0) : maxHeap.peek();


	}
	public static void main(String st[]) {
		
		int nums[] = {5,3,10,-1};
		new SlidingWindowMedian().medianSlidingWindow(nums, 5);
		
	}

}
