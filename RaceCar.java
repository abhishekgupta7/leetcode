import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar {
	class CarInfo{
        int pos, speed;
        public CarInfo(int p, int s) {
            pos = p;
            speed = s;
        }
     public String toString() {
         return pos+"/"+speed;
     }
    }
    public int racecar(int target) {
        Set<CarInfo> visited = new HashSet<>();
        Queue<CarInfo> queue = new LinkedList<>();
        queue.add(new CarInfo(0,1));
        visited.add(queue.peek());
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                CarInfo cur = queue.poll();
                
               
                if (cur.pos == target) return level;
                CarInfo next = new CarInfo(cur.pos + cur.speed, cur.speed * 2);
                CarInfo back = new CarInfo(cur.pos, cur.speed > 0 ? -1 : 1);
                if (Math.abs(next.pos- target) < target && !visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
                if (Math.abs(back.pos - target) < target && !visited.contains(back)) {
                    queue.add(back);
                    visited.add(back);
                }
            }
            
            level++;
        }
        return -1;
    }
    
    public static void main(String st[]) {
    	System.out.println( new RaceCar().racecar(330));
    }
}
