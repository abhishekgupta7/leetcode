/**
 * 
 * https://leetcode.com/problems/reverse-linked-list-ii/ Reverse a linked list
 * from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 m n length of list. 92.
 * Reverse Linked List II
 * 
 * @author abhigupta
 *
 */
public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode root, int m, int n) {

		ListNode head = new ListNode(0);
		head.next = root;
		ListNode r = head;
		ListNode pr = null;
		n = n - m + 1;
		while (m > 0) {
			pr = head;

			head = head.next;
			m--;
		}

		ListNode pre = null;
		ListNode oroot = head;

		while (n > 0) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;

			n--;

		}
		oroot.next = head;

		pr.next = pre;

		return r.next;

	}

}
