import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3


 * 346. Moving Average from Data Stream
 * @author abhigupta
 *
 */
public class MovingAveragefromDataStream {


    /** Initialize your data structure here. */
    int maxs  =0;
    double avg = 0;
    Queue<Integer> q = new LinkedList<>();
    
    public MovingAveragefromDataStream(int size) {
        maxs =size;
        
    }
    
    public double next(int val) {
        
        int remove =0;
        int s = q.size();
        if(s >= maxs){
            remove = q.poll();
        }
        avg = (avg*s+val- remove)/(q.size()+1);
        
        q.offer(val);
        return avg;
        
    }

}
