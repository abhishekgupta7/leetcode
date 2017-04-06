
public class FactorialTrailingZeroes {
	
	public int trailingZeroes(int n) {
        if (n < 0) return -1;
        int ret = 0;
        while (n > 0) {
        n /= 5;
        ret += n;
        }
        return ret;
        }


}
