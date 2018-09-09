import java.util.Iterator;
import java.util.List;
/***
 * https://leetcode.com/problems/flatten-2d-vector/
 * 251. Flatten 2D Vector
 * 
 *  Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java. 
 * @author abhigupta
 *
 */
public class Vector2D implements Iterator<Integer> {

    int ci =0;
    int cj =0;
    int maxi;
    	<List<Integer>> list = null;
    public Vector2D(List<List<Integer>> vec2d) {
        
        maxi = vec2d.size()-1;
        list = vec2d;
        
        while(ci<= maxi && list.get(ci).size() == 0){
            ci++;
        }
        
    }

    @Override
    public Integer next() {
        
        int a = list.get(ci).get(cj);
        
        if(list.get(ci).size() == cj+1) {
            ci++;
            cj =0;
        }else {
            cj++;
        }
        while(ci<= maxi && list.get(ci).size() == 0){
            ci++;
        }
        return a;
    }

    @Override
    public boolean hasNext() {
        
        if(ci> maxi){
            return false;
        }
        
        
        return true;
        
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */