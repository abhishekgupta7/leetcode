class LinkedListI {
	  
	  LinkedListI next;
	  int val;
	  
	  LinkedListI(int val) {
	      this.val = val; 
	  }
	  public String toString() {
		  return ""+val;
	  }
	}	


public class LinkedListZingZag {
	/*
	 * Input : 1->2->3->4->5->6->7->8->9->null and k=3
	 * Output: 3->2->1->4->5->6->9->8->7->null
	 */

	
	  public static void main(String[] args) {

	    int n[] = {1,2,3,4,5,6,7,8,9,10,11,12};
	    LinkedListI root = createList(n);
	    
	    LinkedListI mRoot = getReverse(root, 4);
	    
	    while(mRoot != null) {
	      
	      System.out.println(mRoot.val);
	      mRoot = mRoot.next;
	    }
	   
	  }
	  public static LinkedListI createList(int nums[]) {
	    
	    LinkedListI root = new LinkedListI(nums[0]);
	    
	    LinkedListI t = root;
	    for(int i = 1 ;i<nums.length;i++) {
	      
	      t.next =  new LinkedListI(nums[i]);
	      
	      t = t.next;
	    }
	    return root;
	    
	  }
	  public static LinkedListI getReverse(LinkedListI root, int k) {
	    
		    
		    if(root == null || k<=0) {
		      return root; 
		    }
		    
		    LinkedListI pre = null;
		    
		    LinkedListI ans = null;
		    LinkedListI start = root;
		    boolean b = false;
		    LinkedListI sstart = null;
		    while(root != null) {
		    	start = root;
		        int tk = k;
		        while(root != null && tk>0) {
		        	LinkedListI temp  = root.next;
		          root.next = pre;
		          pre = root;
		          root = temp;
		          tk--;
		        }
		        if(ans == null) {
		          ans = pre; 
		        }
		        start.next = root;//pre
		        if(sstart != null){
		        	sstart.next = pre; 
		        }
		        
		        if(root == null) {
		            break;//return 
		        }
		        b = !b;
		        tk = k;
		        while(root != null && tk>0) {
		          pre = root;
		          root = root.next;
		          tk--;
		          
		        }
		        sstart = pre;
		        pre.next = null;
		        pre = null;
		        //ob = true;
		      
		    }
		    
		    return ans;
		    

	    
	  }
	  
	  
	  
	
}
