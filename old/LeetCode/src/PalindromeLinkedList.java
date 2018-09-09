/**
 * 
 * 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome. 234. Palindrome
 * Linked List
 * 
 * Could you do it in O(n) time and O(1) space?
 * https://leetcode.com/problems/palindrome-linked-list/
 * @author abhigupta
 *
 */
public class PalindromeLinkedList {

	ListNode root = null;

	public boolean isPalindrome(ListNode head) {

		root = head;
		return check(head);
	}

	public boolean check(ListNode head) {
		if (head == null) {
			return true;
		}

		if (!check(head.next)) {
			return false;
		}

		if (head.val != root.val) {
			return false;
		}
		root = root.next;
		return true;

	}

}
