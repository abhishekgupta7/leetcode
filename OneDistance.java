
public class OneDistance {

	public boolean isOneDistance(String s1, String s2) {

		if (s1 == null) {
			s1 = "";
		}
		if (s2 == null) {
			s2 = "";
		}

		int l1 = s1.length();
		int l2 = s2.length();

		if (Math.abs(l1 - l2) > 1) {
			return false;
		}
		if (Math.abs(l1 - l2) == 1) {
			return isOneAdd(s1, s2);
		}

		return isOneChange(s1, s2);
	}

	private boolean isOneAdd(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return isOneAdd(s2, s1);
		}

		boolean isSkipped = false;
		int j = 0;
		for (int i = 0; i < s1.length(); i++) {

			if (s1.charAt(i) != s2.charAt(j)) {

				if (isSkipped) {
					return false;
				}
				i--;
				isSkipped = true;
			}
			j++;
		}
		return true;

	}

	private boolean isOneChange(String s1, String s2) {

		boolean missMatch = false;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (missMatch) {
					return false;
				}
				missMatch = true;
			}
		}
		return true;

	}
	
	public static void main(String st[]) {
		
		OneDistance od = new OneDistance();
		System.out.println(od.isOneDistance("abc", "abc"));
		System.out.println(od.isOneDistance("ac", "abc"));

		System.out.println(od.isOneDistance("av", "ac"));
		System.out.println(od.isOneDistance("df", "ac"));
		System.out.println(od.isOneDistance("dca", "ac"));
		System.out.println(od.isOneDistance("asd", "ad"));
		System.out.println(od.isOneDistance("caf", "ad"));


	}
}
