import java.util.LinkedList;
import java.util.List;

/**
 * 229. Majority Element II
 * @author abhigupta
 * 
 * Given an integer array of size n, find all elements that appear more than  n/3  times. The algorithm should run in linear time and in O(1) space.
 *
 */
public class MajorityNumber2 {
	

    public List<Integer> majorityElement(int[] nums) {
        
	     
		 
		 List<Integer> list = new LinkedList<Integer>();
		 
		 if(nums == null || nums.length ==0) {
			 return list;
		 }
		 
		  int l = nums.length;
		  if(l == 1){
			  
			  list.add(nums[0]);
			  return list;
		  }
		 
		 int c[] = new int[2];
		 int r[] = new int[2];
		 
		 c[0] = 0;
		 c[1] = 0;
		 
		 r[0] = nums[0];
		 r[1] = nums[1];
		for(int i = 0 ;i<l;i++){
			
			if(nums[i] == r[0]) {
				c[0]++;
			}else if(nums[i] == r[1]){
				c[1]++;
			}else if(c[0] == 0) {
				r[0] = nums[i];
				c[0] =1;
			}else if(c[1] == 0) {
				r[1] = nums[i];
				c[1] =1;
			}else {
				c[0]--;
				c[1]--;
			}
			
			
			
		}
		
		c[0] = 0;
		c[1] = 0;
		for(int n : nums){
			if(n == r[0])
				c[0]++;
			else if(n == r[1])
				c[1]++;
		}
		if(c[0]> l/3){
			list.add(r[0]);
		}
		if(c[1]> l/3){
			list.add(r[1]);
		}
		 
		 
		 return list;
	    
        
    }


}
