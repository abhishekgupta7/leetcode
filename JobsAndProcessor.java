import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobsAndProcessor {
	// This is the text editor interface. 
	// Anything you type or change here will be seen by the other person in real time.
	
	
	
	public static void main(String st[]) {
		
		int t[] = {3,4,10,18,11,16,3};
		
		System.out.println(new JobsAndProcessor().getOptimalTasks(t, 3));
		
	}
	public List<List<Integer>> getOptimalTasks(int tasks[], int p) {
	    
	        
	        if(tasks == null || p <=0) {
	            
	            return null;//throw an exception 
	        }
	        
	        Arrays.sort(tasks);
	        int sum = 0;    
	        for(int n : tasks) {
	            
	            sum += n;
	            
	        }
	        
	        return helper(tasks, p, sum/p);
	    
	    
	}
	
	int getSum(List<Integer> s, int t[]) {
		
		
		int sum = 0;
		for(int i : s) {
			sum+=t[i];
		}
		return sum;
	}
	
	   List<List<Integer>> helper(int t[], int p, int sum) {
	       
	       
	       List<List<Integer>> ans = new ArrayList<>();
	       for(int i =1;i<=p;i++) {
	           
	           Integer pre = null;
	           List<Integer> result  = null;
	           for(int j=1;j<=t.length;j++) {
	               
	               List<Integer> l = new ArrayList<>();
	               min = Integer.MAX_VALUE;
	               r = null;
	               
	               getSum(j,sum,l, t, 0, 0);
	               if(r == null) {
	            	   continue;
	               }
	               int csum = getSum(r,t);
	               if(pre == null){
	                   pre = csum;
	                   result = r;
	               }else {
	                   
	                   if(Math.abs(pre-sum)>Math.abs(csum-sum)) {
	                       pre = csum;
	                       result = r;
	                   }
	               }
	               
	           }
	           
	           ans.add(updateValues(t, result));
	           
	       
	           
	       }
	       return ans;
	       
	       
	       
	   }
	   
	   List<Integer>  updateValues(int t[], List<Integer> r) {
	       
	        List<Integer> a = new ArrayList<>();
	
	       if(r == null) {
	           return a;
	       }
	       
	       for(int i : r) {
	            a.add(t[i]);
	            t[i] = 0;    
	           
	       }
	       return a;
	       
	   }
	
	
	  int min = Integer.MAX_VALUE;
	  List<Integer> r = null;
	 
	 void getSum(int remain, int target, List<Integer> index, int t[], int sum, int p) {
	     
	    
	     if(remain == 0) {
	         
	         if(r == null || Math.abs(sum - target)< min) {
	             min = Math.abs(sum - target);
	             r = new ArrayList<>(index);
	         }
	         
	         return;
	         
	     }
	     if(p>= t.length) {
	         return;
	     }
	     
	     for(int i =p;i<t.length;i++) {
	         
	         if(t[i] == 0) {
	             continue;
	         }
	         index.add(i);
	         getSum(remain-1, target, index,t, sum+t[i], i+1);
	         index.remove(index.size()-1);
	     }
	     
	     
	 }
	
	
	
}