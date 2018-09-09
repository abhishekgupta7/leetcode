/**
 * https://leetcode.com/problems/sort-list/ 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author abhigupta
 *
 */
public class LinkedListSoring {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode f = head.next;

		while (f != null && f.next != null) {

			slow = slow.next;
			f = f.next.next;
		}
		ListNode next = slow.next;
		slow.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(next);

		return merge(l1, l2);

	}

	ListNode merge(ListNode l1, ListNode l2) {

		ListNode t = new ListNode(1);
		ListNode r = t;
		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {

				t.next = l1;
				t = t.next;
				l1 = l1.next;
			} else {

				t.next = l2;
				t = t.next;
				l2 = l2.next;

			}
		}
		while (l1 != null) {

			t.next = l1;
			l1 = l1.next;
			t = t.next;

		}

		while (l2 != null) {

			t.next = l2;
			l2 = l2.next;
			t = t.next;

		}
		t.next = null;
		return r.next;

	}

}
