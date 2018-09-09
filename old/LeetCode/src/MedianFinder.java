import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//learn
/***
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * 295. Find Median from Data Stream

    Total Accepted: 21306
    Total Submissions: 94176
    Difficulty: Hard

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
Examples:

[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2

 * @author abhigupta
 *
 */

class MinHeap implements Comparator<Long> {

	@Override
	public int compare(Long o1, Long o2) {
		return (int) (o1 - o2);
	}
	
	
}

class MaxHeap implements Comparator<Long> {

	@Override
	public int compare(Long o1, Long o2) {
		return (int) (o2 - o1);
	}
	
	
}



public class MedianFinder {


	
private Queue<Long> minHeap = new PriorityQueue<Long>(new MinHeap());
	
	private  Queue<Long> maxHeap = new PriorityQueue<Long>(new MaxHeap());	
	

	
	
	public  void addNum(int a) {
	    
	    
	maxHeap.add((long)a);
	
	minHeap.add(maxHeap.poll());
	
	if(maxHeap.size()<minHeap.size()) {
	    
	    maxHeap.add(minHeap.poll());

	}
	
		
	}

	public  double findMedian() {
		
		
		return (maxHeap.size()>minHeap.size()) ? maxHeap.peek() : (maxHeap.peek()+minHeap.peek())/2.0;
		
	
	}

	
}
