/**
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Reverse a singly linked list. 206. Reverse Linked List
 * 
 * @author abhigupta
 *
 */
public class LinkedListReversal {

	public ListNode reverseList(ListNode head) {

		ListNode pre = null;

		ListNode temp = null;

		while (head != null) {

			temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;

		}
		return pre;

	}

}
