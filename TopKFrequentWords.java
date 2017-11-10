import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	 class MyComparator implements Comparator<Entry<String, Integer>>  {
	        
	        @Override
	        public int compare (Entry<String, Integer> o1, Entry<String, Integer> o2) {
	            
	            if(o1.getValue() > o2.getValue()) {
	                return 1;
	            }
	            if(o1.getValue() == o2.getValue()) {
	                return o1.getKey().compareTo(o2.getKey());
	            }
	            return -1;
	            
	            
	        }
	        
	        
	    }
	    public List<String> topKFrequent(String[] words, int k) {
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(String s : words) {
	            map.put(s, map.getOrDefault(s,0)+1);
	        }
	        
	        PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue(1, new MyComparator());
	        
	        for(Entry<String, Integer> e : map.entrySet()) {
	            if(pq.size()<k){
	                pq.add(e);
	            }else{
	                if(pq.peek().getValue() < e.getValue()) {
	                    pq.pop();
	                    pq.add(e);
	                } 
	            }
	        }
	        List<String> r = new LinkedList<>();
	        
	        while(!pq.isEmpty()) {
	            
	            r.add(0,pq.pop().getKey());
	        }
	        return r;
	    }
}
