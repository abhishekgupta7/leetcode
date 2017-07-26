import java.util.HashMap;

public class EqualOrSmallBinarySearch {

	
	public int getEqualOrSmall(int a[], int s , int e, int target) {
		
		if(s>e) {
			return -1;
		}
		
		int m = s+(e-s)/2;
		
		if(a[m] == target) {
			return m;
		}
		
		if(a[m]<target) {
			
			if(m == a.length-1 || (a[m+1]>target)) {
				return m;
			}
			return getEqualOrSmall(a, m+1, e, target);
			
		}
		
		return getEqualOrSmall(a, s, m-1, target);
		
	}
	
	public static void main(String st[]) {
		
		int a[] = {1,10,20};
		EqualOrSmallBinarySearch obj = new EqualOrSmallBinarySearch();
		System.out.println(obj.getEqualOrSmall( a, 0, a.length-1, 22));
		HashMap<String, String> map = new HashMap<>(); 
		map.containsKey(null);
	}
	
}
