

/**
 * 378
 * 
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * 
 * 378. Kth Smallest Element in a Sorted Matrix

    Total Accepted: 4401
    Total Submissions: 10807
    Difficulty: Medium

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

 */
import java.util.PriorityQueue;

class  Data implements Comparable<Data>{
    
    int x;
    int y;
    int v;
    
    Data(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
        
    }
    public int compareTo(Data v) {
        if(this.v < v.v) {
            return -1;
        }
        if(this.v > v.v) {
            return 1;
        }
        return 0;
    }
    
    
}
public class KthSmallElementMatrix {
	
	

    public int kthSmallest(int[][] matrix, int k) {
     
        if(matrix == null || matrix[0] == null || matrix.length == 0 || k==0) {
            return -1;
        }
        
        PriorityQueue<Data> pq = new PriorityQueue<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i =0;i<m;i++) {
            pq.add(new Data(0,i,matrix[0][i]));
        }
        int a =0;
        while(k>0 ) {
            
            Data d = pq.poll();
            a = d.v;
            if(d.x+1<m) {
                pq.add(new Data(d.x+1,d.y,matrix[d.x+1][d.y]));
            }
            k--;
            
        }
        return a;
    }


}
