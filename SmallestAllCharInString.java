import java.util.Arrays;

public class SmallestAllCharInString {
	
	
	public static void main(String st[]) {
		
		SmallestAllCharInString pro = new SmallestAllCharInString();
		char arr[] = new char[]{'z'};
		
		System.out.println(pro.getSmallestSubString("azbxcy", arr));
		
	}
	String getSmallestSubString(String s, char arr[]) {

		if (s == null || s.length() == 0 || arr == null || arr.length == 0) {
			return null;
		}
		// assuming all the alphabets are in lowercase

		int count[] = new int[26];
		Arrays.fill(count, -1);
		for (char ch : arr) {
			count[ch - 'a'] = 0;
		}
		int required = arr.length;
		String result = null;
		int start = 0;
		// xyyzyzyx
		

		for (int i = 0; i < s.length(); i++) {
			String possibleMin = null;

			int ch = s.charAt(i) - 'a';
			if (count[ch] == 0) {
				count[ch]++;
				required--;
			} else if (count[ch] > 0) {
				count[ch]++;
			}

			while (required == 0) {
				possibleMin = s.substring(start, i + 1);
				int sch = s.charAt(start++)- 'a';
				count[sch]--;
				if (count[sch] == 0) {
					required++;
				}
			}
			if((possibleMin != null) && (result == null || result.length()>possibleMin.length())){
				result = possibleMin;
			}

		}

		return result;

	}
}
