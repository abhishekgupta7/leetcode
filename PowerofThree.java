
public class PowerofThree {
	

	//return ( n>0 &&  1162261467%n==0);
    // 1162261467 is 3^19,  3^20 is bigger than int  
	    public boolean isPowerOfThree(int n) {
	        if(n == 1) {
	            return true;
	        }
	        
	        if(n<=0 ||  n%3 !=0 ) {
	            return false;
	        }
	        
	        return isPowerOfThree(n/3);
	        
	    }


}
