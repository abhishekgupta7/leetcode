/**
 * 
 * 
 *  307. Range Sum Query - Mutable 
 *  
 *  Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:

    The array is only modifiable by the update function.
    You may assume the number of calls to update and sumRange function is distributed evenly.

Subscribe to see which companies asked this question.

 * @author abhigupta
 *
 */

public class NumArray {

	
	int iarray [] = null;
    public NumArray(int[] nums) {
    	iarray =  new int[nums.length +1];
    	for(int i=1;i<iarray.length;i++) {
    		
    		addValue(i, nums[i-1]);
    		
    	}
    }

    void addValue(int i, int val) {
 
    	while(i<iarray.length) {
    		iarray[i] = iarray[i]+val;
    		i = getNext(i);
    	}
    	
        
    }
    
    void update(int i, int val) {

    	
    	addValue(i+1, val - sumRange(i+1, i+2));
    }
    
    public int sumRange(int i, int j) {
     
    	return getSum(j+1) - getSum(i+1);
    }
    private int getSum(int p) { // from 0 to p
    	int s = 0;
    	while(p>0) {
    		s = s + iarray[p];
    		p = getParent(p);
    	}
    	
    	return s;
    	
    }
    int getParent(int n) {
    	return n-(n&-n);
    }
    
    int getNext(int n) {
    	return n +(n&-n);
    }
    
    
    public static void main(String st[]) {
    	

        int input[] = {1,2,3,4,5,6,7};
        NumArray ft = new NumArray( input);
        assert 6 == ft.sumRange(0, 2);
        
    
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);