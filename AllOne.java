import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Counter {
	
	int count;
	
	Counter pre;
	Counter next;
	
	Set<String> keys = new HashSet<>(); 
	
	public Counter(int  val) {
		this.count = val;
	}
	
}
public class AllOne {
	
	Map<String, Counter> map = null;
	
	Counter min = null;
	Counter max = null;

    /** Initialize your data structure here. */
    public AllOne() {
    	
    	map = new HashMap<>();
    	min = new Counter(0);
    	max = new Counter(Integer.MAX_VALUE);
    	min.next = max;
    	max.pre = min;
        
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	
    	Counter count = map.get(key);

    	map.put(key, addAfter(count == null ? min: count, key));
    	cleanCounter(count);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        
    	Counter count = map.getOrDefault(key, null);
    	if(count == null) {
    		return;
    	}
    	
    	Counter nextCount = addBefore(count, key);
    	cleanCounter(count);
    	if(nextCount == null) {
    		return;
    	}
    	map.put(key, nextCount);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
    	
    	return max.pre.keys.size() == 0 ? "" : max.pre.keys.iterator().next();
        
    }
    
    private void cleanCounter(Counter curr){
    	
    	if(curr == null || curr.keys.size() != 0){
    		return;
    	}
    	Counter temp = curr.next;
    	curr.pre.next = temp;
    	temp.pre = curr.pre;
    	
    }
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    	return min.next.keys.size() == 0 ? "" : min.next.keys.iterator().next();

    }
     
    private Counter addBefore(Counter cur, String key) {
    	
    	cur.keys.remove(key);
    	
    	if(cur.count == 1) {
    		map.remove(key);
    		return null;
    	}
    	
    	Counter newC = null;
    	if(cur.pre.count == cur.count -1 ){
    		newC = cur.pre;
    	}else{
    		newC = new Counter(cur.count -1);
    		Counter temp = cur.pre;
    		temp.next = newC;
    		newC.pre = temp;
    		newC.next = cur;
    		cur.pre = newC;
    	}
    	newC.keys.add(key);
    	return newC;
    }
    private Counter addAfter(Counter pre, String key) {
    	Counter cur = null;
    	pre.keys.remove(key);
    	if(pre.next.count == pre.count +1) {
    		 cur = pre.next;
    	}else{
    		cur = new Counter(pre.count+1);
    		Counter temp = pre.next;
    		pre.next = cur;
    		cur.pre = pre;
    		cur.next = temp;
    		temp.pre = cur;
    	}
    	cur.keys.add(key);
    	
    	return cur;
    	
    }
    
    
    public static void main(String st[]) {
    	
    	AllOne all = new AllOne();
    	
    	all.inc("a");
    	//System.out.println(all.getMaxKey());
    	//System.out.println(all.getMaxKey());
    	//System.out.println(all.getMinKey());

    	all.inc("b");
    	all.inc("c");
    	//System.out.println(all.getMaxKey());
    	all.inc("d");
    	all.inc("a");
    	all.inc("b");
    	
    	all.inc("c");
    	all.inc("d");
    	
    	all.inc("c");
    	all.inc("d");
    	
    	all.inc("d");
    	all.inc("a");
    	//System.out.println(all.getMaxKey());
    	System.out.println(all.getMinKey());


    }
}


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */