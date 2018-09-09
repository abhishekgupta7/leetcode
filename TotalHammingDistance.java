/**
 * 
 * https://leetcode.com/problems/total-hamming-distance/description/
 * @author abhigupta
 * 
 * 477. Total Hamming Distance
DescriptionHintsSubmissionsDiscussSolution

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:

Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Note:

    Elements of the given array are in the range of 0 to 10^9
    Length of the array will not exceed 10^4.


 *
 */
public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		    int total = 0, n = nums.length;
		    for (int j=0;j<32;j++) {
		        int bitCount = 0;
		        for (int i=0;i<n;i++) {
		            
		           int mask = (1<<j);
		           System.out.println(nums[i]+ " - "+(nums[i] & mask));
		           bitCount = bitCount +  (nums[i] & mask) > 0 ? 1 : 0;  
		        }
		           
		        total += bitCount*(n - bitCount);
		    }
		    return total;
		}
	
	public static void main(String st[]) {
		
		int nums[] = {4,14,2};
		System.out.println(new TotalHammingDistance().totalHammingDistance(nums));
	}
}
