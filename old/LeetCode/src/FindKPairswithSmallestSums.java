import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 * 
 *  You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]

Credits:
 * @author abhigupta
 *
 */
public class FindKPairswithSmallestSums {
	

	   public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) 
	{
	        List<int[]> result = new LinkedList<int[]>();
	        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) return result;
	        
	        PriorityQueue<Triple> queue = new PriorityQueue<Triple>(nums1.length, new Comparator<Triple>() {
	            public int compare(Triple a, Triple b)
	            {
	                return Integer.compare(a.val, b.val);
	            }
	        });

	// add the first column
	        for (int i=0; i<nums1.length; i++)
	        {
	            queue.add(new Triple(nums1[i]+nums2[0], i, 0));
	        }
	        
	        while (k-- > 0 && !queue.isEmpty())
	        {
	            Triple current = queue.poll();
	            result.add(new int[]{nums1[current.one], nums2[current.two]});
	// if the current one has a right candidate, add it to the queue. 
	            if (current.two+1 < nums2.length)
	                queue.add(new Triple(nums1[current.one]+nums2[current.two+1], current.one, current.two+1));
	        }
	        
	        return result;
	}
	    
	// Triple is used to store the sum, the index in nums1 and the index in nums2.
	    class Triple
	    {
	        int val;
	        int one;
	        int two;
	        Triple (int val, int one, int two)
	        {
	            this.val = val;
	            this.one = one;
	            this.two = two;
	        }
	    }



}
