/**
 * 234. Palindrome Linked List
 * 
 * https://leetcode.com/problems/palindrome-linked-list/#/description Given a
 * singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
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
