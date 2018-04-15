import java.util.Queue;

public class SyncQueue<T> {
	
	private Queue<T> q = null;
	
	
	public SyncQueue() {
		q = new java.util.LinkedList<>();
	}
	
	public synchronized T poll() throws InterruptedException {
		
		while(q.isEmpty()) {
			wait();
		}
	}
	
}
