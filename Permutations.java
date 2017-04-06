import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	
	
	public static void main(String st[]) {
		
		System.out.println( new Permutations().permute(new int[]{1}));
	}
	public  List<List<Integer>> permute(int[] nums) {

		return getPermutations(0, nums);

	}

	List<List<Integer>>  getPermutations(int p, int[]nums ) {

    
	    if(p >= nums.length) {
	       List<List<Integer>> lists = new ArrayList<>();
           List<Integer> l = new LinkedList<>();
	        lists.add(l);
	        return lists;
	    }
	   List<List<Integer>>  previous  =  getPermutations(p+1, nums);

	   List<List<Integer>> lists = new ArrayList<>();

	    for(List<Integer> l : previous) {
	        for(int i = 0;i<=l.size(); i++){
	            List<Integer> list = new LinkedList<>(l);
	            list.add(i,nums[p]);
	            lists.add(list);
	        }
	    }
	    
	  return lists;  
	}
}
