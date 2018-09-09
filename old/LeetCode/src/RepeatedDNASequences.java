import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**https://leetcode.com/problems/repeated-dna-sequences/
 * 
 * 
 * 187. Repeated DNA Sequences
 * 
 *  All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,
 * @author abhigupta
 *
 */
public class RepeatedDNASequences {

	private static final Map<Character, Integer> A = new HashMap<>();
	static {
		A.put('A', 0);
		A.put('C', 1);
		A.put('G', 2);
		A.put('T', 3);
	}
	private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

	
	public static void main(String st[]) {
		
		System.out.println( new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		
	}
	public List<String> findRepeatedDnaSequences(String s) {
	    Set seen = new HashSet(), repeated = new HashSet();
	    for (int i = 0; i + 9 < s.length(); i++) {
	        String ten = s.substring(i, i + 10);
	        System.out.println(ten);
	        if (!seen.add(ten)) {
	            repeated.add(ten);

	        }
	    }
	    return new ArrayList(repeated);
	}
}
