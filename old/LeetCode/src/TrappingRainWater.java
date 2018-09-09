import java.util.Stack;

/**
 * 42. Trapping Rain Water
 * 
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 * @author abhigupta
 *
 */
public class TrappingRainWater {
	

    public int trap(int[] height) {
        
        if(height == null || height.length ==0) {
            return 0;
        }
        
        Stack<Integer> s = new Stack<>();
        
        int i =0;
        int amount = 0;
        for( i = 0; i < height.length;) {            
            
            if(s.isEmpty() || height[s.peek()] >= height[i]) {
                
                s.push(i);
            i++;
            }else {
                
                int lowest = s.pop();
                
               if(!s.isEmpty()) {
                   
                   
                   amount += ((Math.min(height[i], height[s.peek()]) - height[lowest]) * (i-1-s.peek()));
                 
               } 
                
               
                
            }
            
            
            
        }
        return amount;
    }


}
