
public class DivideTwoInteger {
	public int divide(int dividend, int divisor) {
	     
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        } 
        boolean isNeg = (dividend<0 ^ divisor<0);
        
        long divd = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);
        System.out.println(divd);
        System.out.println(divis);

        /*if(divd < divis) {
            return 0;
        }
        */
       
        long count = 0;
        
        while(divd>=divis) {
            long t =1;
            long tdivis = divis;
            while(divd>=tdivis){
                t = t<<1;
                tdivis = tdivis<<1;
            }
            t = t>>1;
            count += t;
            tdivis = tdivis>>1;
            divd -= tdivis;     
        
        }
        if(isNeg) {
            count = -1*count;
            return count<Integer.MIN_VALUE ?(int) Integer.MIN_VALUE : (int)count;
        }
        return count>Integer.MAX_VALUE ?(int) Integer.MAX_VALUE : (int) count;
    }
	
	public static void main(String st[]) {
		System.out.println(new DivideTwoInteger().divide(Integer.MIN_VALUE, 1));
	}
}
