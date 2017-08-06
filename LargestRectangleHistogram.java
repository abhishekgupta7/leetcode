import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/#/description
 * @author abhigupta
 *
 */
public class LargestRectangleHistogram {
	

    public int largestRectangleArea(int[] height) {
       int len = height.length;
       Stack<Integer> s = new Stack<Integer>();
       int maxArea = 0;
       for(int i = 0; i <= len; i++){
           int h = (i == len ? 0 : height[i]);
           if(s.isEmpty() || h >= height[s.peek()]){
               s.push(i);
           }else{
               int tp = s.pop();
               maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i -1-s.peek()));//see //[4,2,0,3,2,5] (s.isEmpty() ? i : i - tp)
               i--;
           }
       }
       return maxArea;
   }
    
   public static void main(String st[]) {
	   int a[] = {4,2,0,3,2,5};
	   System.out.println( new LargestRectangleHistogram().largestRectangleArea(a));
   }
   


}
