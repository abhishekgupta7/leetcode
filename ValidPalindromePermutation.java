
public class ValidPalindromePermutation {
	
	public boolean isValidPalindromPermutation(String s) {
		
		if(s == null || s.length() == 0) {
			return true;
		}

		int bitVector = getBitVector(s);
		
		return bitVector == 0 || ((bitVector & bitVector-1) == 0);
	}
	
	public int getBitVector(String s) {
		
		int bitVector = 0;
		for( char c : s.toCharArray()) {
			bitVector = appendToBitVector(c-'a', bitVector);
		}
		return bitVector;
	}
	
	public int appendToBitVector(int i, int bitVector) {
		
		int mask = 1;
		mask = mask << i;
		
		if((mask & bitVector) != 0) {
			bitVector &= ~mask;
		}else {
			bitVector |= mask;
		}
		return bitVector;
	}
	
	public static void main(String st[]) {
	
		ValidPalindromePermutation vp = new ValidPalindromePermutation();
		
		System.out.println(vp.isValidPalindromPermutation("aabbccdd"));
	}
	
	
	

}
