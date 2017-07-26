/**
 * https://leetcode.com/problems/first-missing-positive/#/description
 * 
 * 41. First Missing Positive
 * 
 * @author abhigupta
 *
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] <= 0 || A[i] > A.length || A[i] == i+1) {
				i++;
			} else {
				swap(A, i, A[i] - 1);
			}
		}
		i = 0;
		while (i < A.length && A[i] == i + 1) {
			i++;
		}
		return i + 1;
	}

	private void swap(int[] A, int i, int j) {
		if(i == j) {
			return;
		}
		
		int v = A[i];
		A[i] = A[j];
		A[j] = v;
		
	}
	
	public static void main(String st[]) {
		
		int n [] = {1,1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(n));
	}

}
