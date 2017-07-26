class LinkedList {
	
	int val;
	LinkedList next;
	
	LinkedList(int v) {
		val = v;
	}
	
}
public class ReverSalList {

	
	public static void main(String st[]) {
		
		LinkedList l = new LinkedList(1);
		l.next = new LinkedList(2);
		l.next.next = new LinkedList(3);
		l.next.next.next = new LinkedList(4);
		l.next.next.next.next = new LinkedList(5);
		LinkedList r = new ReverSalList().getReversal(new ReverSalList().getReversal(l,5), 2);
		
		while(r!= null) {
			System.out.println(r.val);
			r = r.next;
		}
		
		System.out.println(r);
	}
	
	
	
	public LinkedList getReversal(LinkedList root, int n) {
		
		if(root == null || n<=0) {
			return root;
		}
		
		LinkedList temp = null;
		LinkedList pre = null;
		int l = 0;
		LinkedList first = null;
		LinkedList dummy = new LinkedList(3);
		LinkedList ans = dummy;

		while(root != null) {
			first = root;
			l = n;
			while(root != null && l>0) {
			
				temp = root.next;
				root.next = pre;
				pre = root;
				root = temp;
				l--;
			}
			
			dummy.next = pre;
			dummy = first;
			pre = null;
			
		}
		
		return ans.next;
		
	}
	
}
