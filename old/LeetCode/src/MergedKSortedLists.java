import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 23. Merge k Sorted Lists
 * @author abhigupta
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 */

 class MergeList implements Comparable<MergeList>{

	public ListNode list;

	MergeList(ListNode node) {

		list = node;
	}


	@Override
	public int compareTo(MergeList o) {
		return this.list.val - o.list.val;
	}
}
public class MergedKSortedLists {

	public ListNode mergeKLists2(ListNode[] lists) {

		if (lists == null || lists.length == 0) {
			return null;

		}


		PriorityQueue<MergeList> pq = new PriorityQueue<MergeList>();

		MergeList ml = null;
		for (int i = 0; i < lists.length; i++) {

			if (lists[i] != null) {
				ml = new MergeList(lists[i]);
				pq.add(ml);
			}

		}
		ListNode rootp = null;
		ListNode root = new ListNode(0);
		rootp = root;
		ListNode out = null;

		while (pq.size() != 0) {

			out = pq.poll().list;
			if (out.next != null) {
				ml = new MergeList(out.next);

				pq.add(ml);
			}

			
				root.next = out;
				root = root.next;
			
		}

		return rootp.next;

	}


        
    

    
    
    public ListNode merge(ListNode l1, ListNode l2) {
        
        
        if(l1 == null && l2 == null) {
            return l1;
        }

        ListNode r = new ListNode(0);
        ListNode ans = r;
        
        while(l1!= null && l2!= null) {
            
            if(l1.val> l2.val) {
                
                r.next = l2;
                l2 = l2.next;
                
            }else{
                
                r.next = l1;
                l1 = l1.next;
            }
          r = r.next;  
          //System.out.println(r.val);
            
        }
        
        if(l1 != null){
            r.next = l1;
        }
        if(l2 != null) {
            r.next = l2;
        }
        return ans.next;
        
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
       if(lists == null || lists.length == 0 ){
           return null;
       }
       
       return mergeKLists(lists, 0 , lists.length -1);
        
        

    }
    
    public ListNode mergeKLists(ListNode[] lists,int s ,int e) {
        
       if(s == e){
           return lists[e];
       }
       if(e-s == 1){
           return merge(lists[s], lists[e]);
       }
       
       return merge( mergeKLists(lists,s,(e+s)/2) ,  mergeKLists(lists,(e+s)/2+1,e));
       
        
        

    }

}
