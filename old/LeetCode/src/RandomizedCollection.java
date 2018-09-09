import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import  java.util.Random;
import java.util.Set;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 
 *   381. Insert Delete GetRandom O(1) - Duplicates allowed
 * Design a data structure that supports all following operations in average O(1) time.
Note: Duplicate elements are allowed.

    insert(val): Inserts an item val to the collection.
    remove(val): Removes an item val from the collection if present.
    getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.

Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();


 * @author abhigupta
 *
 *
 *
 *failed test Case 
 *
 *["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","getRandom","getRandom","getRandom","getRandom"]
[[],[0],[1],[2],[3],[3],[2],[3],[0],[],[],[],[]]
 */

public class RandomizedCollection {

    /** Initialize your data structure here. */
    Random ran = new Random();
    Map<Integer, Set<Integer>> map ;
    List<Integer> list ;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        Set<Integer> s = map.get(val);
        boolean a = false;
        if(s == null ) {
            s = new HashSet<>();
            map.put(val,s);
            a = true;
        }
        s.add(list.size());
        list.add(val);
        return a;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    
    
        Set<Integer> s = map.get(val);
        if(s == null) {
            return false;
        }
    
        int p = s.iterator().next();
        if(p<list.size()-1) {
            
            int c = list.get(list.size()-1);
            if(c != val) {  //trick
                map.get(c).remove(list.size()-1);
                map.get(c).add(p);
                list.set(p,c);            
            }
        }
        //System.out.println(p);

        list.remove(list.size()-1);
        s.remove(p);
        if(s.size() == 0 ) {
            map.remove(val);
        }
         /*System.out.println("");
        for(int i : map.keySet()) {
            System.out.print(i+"->"+map.get(i));
        }
        */
        return true;

    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        
        return list.get(ran.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */