import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3  1,3,2
3,2,1  1,2,3
1,1,5  1,5,1
 * 31. Next Permutation
 * @author abhigupta
 *
 */
public class NextPermutation {

	
public void nextPermutation(int[] nums) {
        
        if(nums == null || nums.length<=1) {
            return;
        }
        
        int i = nums.length - 1;
        
        while(i>0 && nums[i-1] >= nums[i]) {
            i--;
        }
        if( i == 0) {
            reverse(nums, 0, nums.length -1);
            return;
        }
        
        int firstsmall = nums[i-1];
        int firstsmallP = i-1;
      
        int nextsmall = nums[i];
        int nextsmallP = i;
      
        while(i<nums.length) {
            
            if(nums[i]>firstsmall && nums[i]<=nextsmall) {//imp =
                nextsmall = nums[i];
                nextsmallP =i;
            }
            i++;     
        }
        nums[firstsmallP] = nextsmall;
        nums[nextsmallP] = firstsmall;
        reverse(nums,firstsmallP+1, nums.length-1);
        
        
    }

	  void reverse(int nums[], int l, int r) {
	        
	        int temp = 0;
	        while(l<r) {
	            
	            temp = nums[l];
	            nums[l] = nums[r];
	            nums[r] = temp;
	            l++;
	            r--;
	        }
	        
	        
	        
	    }

	/*   
	public void nextPermutation(int[] nums) {

		if (nums == null || nums.length == 0) {
			return;
		}
		
		
		int l = nums.length -1;
		int i = l;
		
		while(i>=1 && nums[i-1]>=nums[i]) {
			i--;
		}
		
		if(i ==0 ){
			reverse(0, nums.length-1, nums);
			return;
		}
		
		int mx = nums[i-1];

		int mxp = i-1;
		int p = i;
		int nmp =i; 
		int nmx = nums[nmp];
		
		while (p <=l ){
			
			if(nums[p]>mx){
				nmx = Math.min(nmx, nums[p]);
				nmp = p;
			}
			p++;
		}

	//	System.out.println(nums[nmp]);
		int t= nums[mxp];
		nums[mxp] = nums[nmp];
		nums[nmp] = t;
		//Arrays.sort(nums,mxp+1, nums.length);
		reverse(i,nums.length-1,nums);
	
		//replace
		
		
		
	}*/
	  
	public static void main(String st[]) {
		
		int nums[] ={1,3,4,3,0};
		new NextPermutation().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		
	}
	
	

}
