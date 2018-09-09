/**
 * 
 * https://leetcode.com/problems/powx-n/
 * 50. Pow(x, n)
 * 
 * Implement pow(x, n). 
 * @author abhigupta
 *
 */
public class PowMN {
	
	

	 
	 public  static double myPow(double x, int n) {
		if(n<0){
			 if(n == Integer.MIN_VALUE){
				 return 1/(powrec(x,Integer.MAX_VALUE)*x); //tricky
			 }
			return 1/powrec(x,-n);
		}
		return powrec(x,n);
		
		
		}

		public static double powrec(double x, int n){
			if(n == 1)
				return x;
			if(n == 0)
				return 1;
			if(n%2 == 0){
				double r = powrec(x,n/2);
				return r*r;
			}
			return x* powrec(x, n-1);
		}



}
