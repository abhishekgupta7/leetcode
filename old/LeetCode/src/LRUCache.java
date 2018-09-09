import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
 * 146. LRU Cache
 * @author abhigupta
 *   ALL
 */

class LRUNode {

	public int value;
	public LRUNode left;
	public LRUNode right;
	int key;

	LRUNode(int key, int val) {
		this.value = val;
		this.key = key;
	}
}

public class LRUCache {
    
    Map<Integer,LRUNode> map = new HashMap<>();
    
    LRUNode start = new LRUNode(0,0);
    LRUNode end = new LRUNode(1,1);

    int cap = 0;
    
    public LRUCache(int capacity) {
        
        cap = capacity;
        start.right = end;
        end.left = start;
        
    }
    
    public int get(int key) {
    
        LRUNode node = map.get(key);
        
        if(node == null) {
            return -1;
        }
        moveToLast(node);
        
        return node.value;
        
        
    }
    
    public void set(int key, int value) {
        
        LRUNode node = map.get(key);
        if(node == null) {
            node = new LRUNode(key, value);
            
            if(cap == map.size()) {
                removeFromFront();
            }
            map.put(key, node);
        } 
        
        node.value = value;
        
        
        moveToLast(node);        
        
    }
    
    void moveToLast(LRUNode node) {
        
        if(node.right == end) {
            return ;
        }
        
        if(node.left != null) {
            LRUNode left = node.left;
            LRUNode right = node.right;
            left.right = right;
            right.left = left;

        }
        
        LRUNode lefte = end.left;
        end.left = node;
        node.right = end;
        lefte.right = node;
        node.left = lefte;
        
    }
    void removeFromFront() {
        
        if(start.right == end) {
            return;
        }
        
        start = start.right;
        map.remove(start.key);
        
    }
    
    
}
