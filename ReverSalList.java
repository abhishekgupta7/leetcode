class 
LinkedListInternal {
	
	int val;
	LinkedListInternal next;
	
	LinkedListInternal(int v) {
		val = v;
	}
	
}
public class ReverSalList {

	
	public static void main(String st[]) {
		
		LinkedListInternal l = new LinkedListInternal(1);
		l.next = new LinkedListInternal(2);
		l.next.next = new LinkedListInternal(3);
		l.next.next.next = new LinkedListInternal(4);
		l.next.next.next.next = new LinkedListInternal(5);
		LinkedListInternal r = new ReverSalList().getReversal(new ReverSalList().getReversal(l,5), 2);
		
		while(r!= null) {
			System.out.println(r.val);
			r = r.next;
		}
		
		System.out.println(r);
	}
	
	
	
	public LinkedListInternal getReversal(LinkedListInternal root, int n) {
		
		if(root == null || n<=0) {
			return root;
		}
		
		LinkedListInternal temp = null;
		LinkedListInternal pre = null;
		int l = 0;
		LinkedListInternal first = null;
		LinkedListInternal dummy = new LinkedListInternal(3);
		LinkedListInternal ans = dummy;

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
