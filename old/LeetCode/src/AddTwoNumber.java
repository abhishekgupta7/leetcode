/**
 * https://leetcode.com/problems/add-two-numbers/
 * 2. Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
#AMZ
#MS
#Bloom
#AirBnb
#Adobe
 * @author abhigupta
 *
 */
public class AddTwoNumber {
	
	

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        if(l1 == null) {
            return l2;
        }
        
        int c = 0;
        ListNode root = new ListNode(1);
        ListNode r  = root;
        while(l1!= null && l2 != null) {
            
            c = l1.val +l2.val + c;
            root.next = new ListNode(c%10);
            c = c/10;
            root = root.next;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        while(l1 != null) {
            c = l1.val+c;
            root.next = new ListNode(c%10);
            c  = c/10;
            root = root.next;
             l1 = l1.next;
        }
        
        while(l2 != null) {
            c = l2.val+c;
            root.next = new ListNode(c%10);
            c  = c/10;
            root = root.next;
             l2 = l2.next;

        }
        if(c != 0) {
            root.next = new ListNode(c);
            root = root.next;
        }
        return r.next;
    }


}
