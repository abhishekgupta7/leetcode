import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 * 
 * @author abhigupta
 *
 */
public class FizzBuzz {

	public List<String> fizzBuzz(int n) {
		
		List<String> list = new ArrayList<String>(n);
		int f = 1;
		int b = 1;
		for (int i = 1; i <= n; i++) {
			
			if (f == 3 && b == 5) {
				list.add("FizzBuzz");
				f = 1;
				b = 1;
			} else if (f == 3) {
				list.add("Fizz");
				f = 1;
				b++;
			} else if (b == 5) {
				list.add("Buzz");
				b = 1;
				f++;
			} else {
				list.add("" + i);
				f++;
				b++;
			}
		}
		return list;

	}

	public static void main(String st[]) {
		
		FizzBuzz fb = new FizzBuzz();
		
		for(String s :fb.fizzBuzz(15)) {
			System.out.println(s);
		}

	}
}
