import java.util.HashMap;
import java.util.Map;

class DoublyLinkedList<T> {
	
	T pre;
	T next;
	
}

class FrequencyNode extends DoublyLinkedList<FrequencyNode>{

	int freq;
	FrequencyNodeChild childHead;
	FrequencyNodeChild childTail;
	

	FrequencyNode(int freq) {

		this.freq = freq;

		childHead = new FrequencyNodeChild(0, 0, this);
		childTail = new FrequencyNodeChild(Integer.MAX_VALUE, Integer.MAX_VALUE, this);
		childHead.next = childTail;
		childTail.pre = childHead;

	}

	public String toString() {

		FrequencyNodeChild temp = childHead.next;
		String st = "[";
		while (temp != childTail) {
			st = st + temp.key + ":" + temp.value + ",";
			temp = temp.next;

		}
		st = st + "]";
		return st;
	}

}

class FrequencyNodeChild  extends DoublyLinkedList<FrequencyNodeChild>{

	int value;
	int key;
	FrequencyNode parent;

	FrequencyNodeChild(int key, int value, FrequencyNode parent) {
		this.key = key;
		this.value = value;
		this.parent = parent;
	}

}

public class LFUCache {

	FrequencyNode head;
	FrequencyNode tail;
	Map<Integer, FrequencyNodeChild> map;
	int capacity;

	public LFUCache(int capacity) {

		head = new FrequencyNode(0);
		tail = new FrequencyNode(Integer.MAX_VALUE);
		map = new HashMap<>();
		head.next = tail;
		tail.pre = head;
		this.capacity = capacity;
	}

	public int get(int key) {

		FrequencyNodeChild node = map.get(key);

		if (node == null) {
			return -1;
		}
		removeNodeChild(node);
		updateToNextFreQuency(node.parent, node);
		System.out.println(this);

		return node.value;

	}

	public void put(int key, int value) {

		FrequencyNodeChild node = map.get(key);
		FrequencyNode curFre = head;
		if (node == null) {
			if (map.size() == capacity) {
				removeLFU();
			}
			node = new FrequencyNodeChild(key, value, null);
			map.put(key, node);

		} else {
			removeNodeChild(node);
			curFre = node.parent;
		}
		node.value = value;

		updateToNextFreQuency(curFre, node);
		System.out.println(this);

	}

	FrequencyNode updateToNextFreQuency(FrequencyNode currentFre, FrequencyNodeChild child) {

		FrequencyNode newFre = currentFre.next;

		if (currentFre.next.freq != currentFre.freq + 1) {
			newFre = new FrequencyNode(currentFre.freq + 1);
			addAfterParent(currentFre, newFre);
		}
		child.parent = newFre;

		addAfterChild(newFre.childTail.pre, child);

		if (currentFre != head && currentFre.childHead.next == currentFre.childTail) {

			currentFre.pre.next = currentFre.next;
			currentFre.next.pre = currentFre.pre;
		}
		return newFre;

	}

	void removeLFU() {
		
		
		FrequencyNode remove = head.next;

		FrequencyNodeChild removechild = remove.childHead.next;
		remove.childHead.next = removechild.next;
		removechild.next.pre = remove.childHead;
		map.remove(removechild.key);
		if (remove.childHead.next == remove.childTail) {
			head.next = remove.next;
			remove.next = head;
		}

	}

	void removeNodeChild(FrequencyNodeChild node) {

		FrequencyNodeChild temp = node.pre;
		temp.next = node.next;
		node.next.pre = temp;
		node.next = null;
		node.pre = null;

	}

	void addAfterParent(FrequencyNode pre, FrequencyNode fNode) {

		FrequencyNode temp = pre.next;
		fNode.next = temp;
		temp.pre = fNode;
		pre.next = fNode;
		fNode.pre = pre;

	}

	void addAfterChild(FrequencyNodeChild pre, FrequencyNodeChild fNode) {

		FrequencyNodeChild temp = pre.next;
		fNode.next = temp;
		temp.pre = fNode;
		pre.next = fNode;
		fNode.pre = pre;

	}

	public static void main(String st[]) {
		LFUCache cache = new LFUCache(1 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1); // returns 1
		cache.put(3, 3); // evicts key 2
		cache.get(2); // returns -1 (not found)
		cache.get(3); // returns 3.
		cache.put(4, 4); // evicts key 1.
		cache.get(1); // returns -1 (not found)
		cache.get(3); // returns 3
		cache.get(4); // returns 4

	}

	public String toString() {

		FrequencyNode temp = head.next;
		String st = "{";

		while (temp != tail) {
			st = st + temp.freq;
			st = st + temp.toString();
			temp = temp.next;
		}
		st = st + "}";
		return st;
	}

}
