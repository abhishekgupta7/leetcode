import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2. 
 * 253. Meeting Rooms II
 * @author abhigupta
 *
 */

class Time{
     
     public int time;
     public int type; // 0 end and 1 start 
     
     Time(int t, int ty){
         
         time = t;
         type = ty;
     }
 }

class TimeComparator implements Comparator<Time>{
    
    
    public int compare(Time t1, Time t2) {
        
       return t1.time != t2.time ? t1.time -t2.time : t1.type - t2.type;
        
    }
}
public class MeetingRoomsII {
	

    public int minMeetingRooms(Interval[] intervals) {
        
        
        if(intervals == null || intervals.length ==0 ){
            return 0;
        }
        PriorityQueue<Time> q = new PriorityQueue<Time>(intervals.length, new TimeComparator());
        
        for(Interval i : intervals){
            
            q.add(new Time(i.start,1));
            q.add(new Time(i.end,0));

        }
    
        int size =0;
        int a = 0;
        while(q.size() != 0) {
            
            Time t= q.poll();
            
            if(t.type == 1) {
                size ++;
                a = Math.max(size,a);
            }else{
                size --;
            }
        }
        
        return a;
        
    }


}
