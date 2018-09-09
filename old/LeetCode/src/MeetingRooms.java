import java.util.Arrays;
import java.util.Comparator;

/***
 * https://leetcode.com/problems/meeting-rooms/
 * 252. Meeting Rooms
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false. 
 * @author abhigupta
 *
 */
public class MeetingRooms {

	

    public boolean canAttendMeetings(Interval[] intervals) {
        
        Arrays.sort(intervals, new Comparator<Interval>() { 
            
            public int compare(Interval t1 , Interval t2) {
                
                return t1.start - t2.start;
            }
             
        });
        
        
        for(int i =1 ;i<intervals.length; i++) {
            
            if(intervals[i-1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
        
        
    }

}
