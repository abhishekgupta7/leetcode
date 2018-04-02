/**
 * https://leetcode.com/problems/rotate-list/description/
 * @author abhigupta
 *
 *Given a list, rotate the list to the right by k places, where k is non-negative.

Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.

 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        
   if (head==null||head.next==null) return head;
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode fast=dummy,slow=dummy;

    int i;
    for (i=0;fast.next!=null;i++)//Get the total length 
    	fast=fast.next;
    System.out.println(i);
        System.out.println(i-n%i);
    for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
    	slow=slow.next;
    
    fast.next=dummy.next; //Do the rotation
    ListNode r =slow.next;
    slow.next=null;
    
    return r;
    }         
    
    
    public static void main(String st[]) {
    	
    	int num[] ={1,2,3,4,5};
    	ListNode root = new ListNode(0);
    	ListNode t = root;
    	for(int i=0;i<num.length;i++) {
    		root.next = new ListNode(num[i]);
    		root = root.next;
    		
    	}
    	System.out.println(new RotateList().rotateRight(t.next, 2).val);
    }
    
}
