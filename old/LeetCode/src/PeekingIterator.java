/***
 * https://leetcode.com/problems/peeking-iterator/
 * 284. Peeking Iterator
 * 
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

Follow up: How would you extend your design to be generic and work with all types, not just integer?

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.
 * @author abhigupta
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	

	public static void main(String st[]){
		
		List<Integer> l = new ArrayList<Integer>();
		
		l.add(1);
		l.add(2);
		PeekingIterator it = new PeekingIterator(l.iterator());
		
		while(it.hasNext()){
			System.out.println("peek"+it.peek());
			System.out.println(it.next());
		}
	
	}

    private Integer peek = null;
    Iterator<Integer> iterator = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	   this.iterator = iterator;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(peek != null) {
	        return peek;
	    }
	    if(iterator.hasNext()) {
	    	peek = iterator.next();
	    }
	    return peek;
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer r = peek;
	    if(peek != null){
	    	peek = null;
	        return r;
	    } 
	    return iterator.next();
	    
	}

	@Override
	public boolean hasNext() {
	    return peek!= null || iterator.hasNext();
	    
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
