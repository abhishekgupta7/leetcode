
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Data implements Comparable<Data>{
    
    long time;
    String value;
    
    public Data(long time, String value) {
        
        this.time = time;
        this.value = value;
    }
    public int compareTo(Data d) {
        
        if(this.time > d.time) {
            return 1;
        }
        if(this.time<d.time) {
            return -1;
        }
        return 0;
        
    }
    
}

class TimeMap{
    
    private Map<String, List<Data>> map = null;
    
    public TimeMap() {
        
        map = new HashMap<>();
        
    }
    
    public long set(String key, String value) {
        
        if(key == null) {
            
            return -1;//throw an exception
        }
        
        long time = System.currentTimeMillis();
        
        List<Data> list = map.getOrDefault(key, new LinkedList<>());
        
        Data d = new Data(time, value);
        
        list.add(d);
        
        map.put(key, list);
        
        return time;
    }
    
    
    public  String get(String key) {
        
       return get(key, null);

    }
    
    public  String get(String key, Long time) {
        
        if(key == null) {
            
            return null;//throw an exception
        }
        
        List<Data> l = map.get(key);
        
        if(l == null) {
            return null;
        }
        if(time == null) {
            
            return l.get(l.size()-1).value;
        }
        
        Data d = new Data(time, "");
        
        //int index = Collections.binarySearch(l, d);
        
        Data valueData = search(l,d);
        
        if(valueData == null) {
            return null;
        }
        
       return valueData.value;
    }
    
    Data search(List<Data> l, Data d) {
               
               
        Data pre = l.get(0);
        if(pre.time> d.time) {
            return null;
        }
        
        for(int i = 1;i<l.size();i++ ) {
            
            if(l.get(i).time>d.time) {
                break;
            }    
            
            pre = l.get(i);
        }
        return pre;
        
    }
    
    
}
public class TimeMapOrder {
    public static void main(String args[] ) throws Exception {
        
        TimeMap map = new TimeMap();
        
        long time = map.set("foo", "bar");
        Thread.sleep(3000);
        map.set("foo", "bar2");
        System.out.println(time);
       System.out.println(map.get("foo"));

    }
    
    
    
}


