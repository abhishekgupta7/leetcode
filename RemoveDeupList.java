import java.util.HashSet;
import java.util.Set;

public class RemoveDeupList {

	public void removeDuplicate(ListNode list) {
		
		if(list == null) {
			return;
		}
		
		ListNode head = list;
		Set<Integer> set = new HashSet<>();
		
		set.add(head.val);
		
		while(head != null && head.next != null) {
			
			if(set.contains(head.next.val)) {
				head.next = head.next.next;
			}else {
				set.add(head.next.val);
			}
			head = head.next;
		}
		
	}
	
	public static void main(String st[]) {
		RemoveDeupList rl = new RemoveDeupList();
		ListNode head = null;
		rl.print(head);
		rl.removeDuplicate(head);
		rl.print(head);
		head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		rl.print(head);
		rl.removeDuplicate(head);
		rl.print(head);
		
		head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(5);
		rl.print(head);
		rl.removeDuplicate(head);
		rl.print(head);
		head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(6);

		rl.print(head);
		rl.removeDuplicate(head);
		rl.print(head);
		
		head = new ListNode(1);
		head.next = new ListNode(1);
		rl.print(head);
		rl.removeDuplicate(head);
		rl.print(head);
	}
	
	private  void print(ListNode l) {
		System.out.println();
		while(l != null) {
			System.out.print(l.val+"->");
			l = l.next;
		}
		System.out.print("null");
	}
}
