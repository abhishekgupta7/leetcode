import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrimeFactors {
	
	List<Integer> getFactors(int n) {
		
		if(n <=1) {
			return Collections.emptyList();
		}
	
		List<Integer> factors = new ArrayList<>();
		while(n !=1) {
			for(int i = 2;i<=n;i++) {
				if( n %i == 0) {
					factors.add(i);
					n = n/i;
					break;
				}
			}
		}
		return factors;
	}
	
	public static void main(String arg[]) {
		
		System.out.println(Arrays.toString(new PrimeFactors().getFactors(100).toArray()));
		
	}
}
