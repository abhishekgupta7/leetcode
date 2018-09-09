import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/design-phone-directory/
 * 379. Design Phone Directory

    Total Accepted: 781
    Total Submissions: 3047
    Difficulty: Medium

Design a Phone Directory which supports the following operations:

    get: Provide a number which is not assigned to anyone.
    check: Check if a number is available or not.
    release: Recycle or release a number.

Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);

 * 
 * 
 * 
 * @author abhigupta
 *
 */
public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */

        Set<Integer> assigned = null;
        List<Integer> avi = null;
        int max ;
        int n =0;
    public PhoneDirectory(int maxNumbers) {
        
        assigned = new HashSet<>(maxNumbers);
        avi = new LinkedList<Integer>();
        max = maxNumbers;
        
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(n !=max) {
            int a = n++;
            assigned.add(a);

            return a;
        }
        if(avi.size() == 0) {
            return -1;
        }
        Integer i = avi.iterator().next();
        assigned.add(i);
        avi.remove(i);
        return i;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number>=max) {
            return false;
        }
        return !assigned.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        
        if(check(number) ){
            return;
        }
        assigned.remove(number);
        avi.add(number); 
    }  
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */