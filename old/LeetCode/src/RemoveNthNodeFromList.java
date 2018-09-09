/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
 * @author abhigupta
 *
 */
public class RemoveNthNodeFromList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp = head;
        
        while(n>0) {
            temp = temp.next;
            n--;
        }
        ListNode s = head;

        if(temp == null) {
            return head.next;
        }
        while(temp.next != null) {
            
           temp = temp.next;
           s = s.next;
        }
        
        ListNode r = s.next;
        
        ListNode next = r.next;
        if(next == null) {
            s.next = null;
            return head;
        }
        s.next = next;
        return head;
        
    }

}
