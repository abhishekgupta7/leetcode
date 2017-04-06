import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {

	private Queue<Double> minHeap = null;
	private Queue<Double> maxHeap = null;
	
	
	public static void main(String st[]) {
		
		
		System.out.println();
		Arrays.toString(new SlidingWindowMedian().medianSlidingWindow( new int[]{2,3},2));
	}

	public double[] medianSlidingWindow(int[] n, int k) {

		if (n == null) {
			return null;
		}
		Double[] nums = new Double[n.length];
		
		for(int i = 0;i<nums.length;i++) {
			nums[i] = (double)n[i];
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

	void add(double num) {

		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		reBalance();

	}

	double getMedian() {

		return (minHeap.size() == maxHeap.size()) ? (maxHeap.peek() + minHeap.peek() )/ 2.0 : maxHeap.peek();
		//		//not 		return (minHeap.size() == maxHeap.size()) ? (maxHeap.peek() + minHeap.peek() / 2.0) : maxHeap.peek();
        // not 		return (minHeap.size() == maxHeap.size()) ? (long)(maxHeap.peek() + minHeap.peek() / 2.0) : maxHeap.peek();

	}

}
