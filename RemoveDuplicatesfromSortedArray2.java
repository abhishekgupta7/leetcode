
public class RemoveDuplicatesfromSortedArray2 {
	public int removeDuplicates(int[] nums) {

		int i = 0;
		for (int n : nums) {

			if (i < 2 || n > nums[i - 2]) {
				nums[i++] = n;
			}

		}
		return i;
	}

	public static void main(String st[]) {
		int a[] = { 1, 1, 1, 2, 2, 3 };
		System.out.println(new RemoveDuplicatesfromSortedArray2().removeDuplicates(a));
	}
}
