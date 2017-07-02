import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

	private Queue<Long> minHeap = new PriorityQueue<Long>();

	private Queue<Long> maxHeap = new PriorityQueue<Long>(10, Collections.reverseOrder());

	public void addNum(int a) {

		maxHeap.add((long) a);

		minHeap.add(maxHeap.poll());

		if (maxHeap.size() < minHeap.size()) {

			maxHeap.add(minHeap.poll());

		}

	}

	public double findMedian() {

		return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) / 2.0;

	}

}
