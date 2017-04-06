
public class LongestAbsoluteFilePath {

	int max = 0;
	
	public static void main(String st[]) {
		
		LongestAbsoluteFilePath path = new LongestAbsoluteFilePath();
		
		//System.out.println(path.lengthLongestPath("dir"));
		//System.out.println(path.lengthLongestPath("subdir1.txt"));
		//System.out.println(path.lengthLongestPath("dir\n\tsubdir1.txt"));
		//System.out.println(path.lengthLongestPath("dir\n\tsubdir2\n\t\tfile.ext"));
		//System.out.println(path.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
		//System.out.println(path.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
		System.out.println(path.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));


	}
	public int lengthLongestPath(String input) {
		max = 0;
		if(input ==  null || input.length() == 0) {
			return 0;
		}
		String[] paths = input.split("\n");
		
		
		getNextPosition(paths, 0, 0, -1);
		
		return max;
	}
	
	int getNextPosition(String[] paths, int pos, int len, int preLevel) {

		if (paths.length <= pos) {
			return -1;
		}
		int level = getLevel(paths, pos);

		while (level == preLevel + 1) {

			if (paths[pos].contains(".")) {
				max = Math.max(max, len + paths[pos].length() - getLengthOfT(paths[pos]));
				//System.out.println(paths[pos]);
				//return pos + 1;
			}
			pos = getNextPosition(paths, pos + 1, len + paths[pos].length() + 1 - getLengthOfT(paths[pos]), level);
			if (pos < 0 || pos >= paths.length) {
				return -1;
			}
			level = getLevel(paths, pos);
		}
		return pos;
	}
		
	
	int getLevel(String[] paths, int pos ) {
		if(paths.length <= pos) {
			return -1;
		}
		System.out.println(paths[pos]);

		return getLengthOfT(paths[pos]);
	}
	int getLengthOfT(String st) {
		int level = 0;
		while(st.startsWith("\t")){
			level += 1;
			st = st.substring(1);
		}
		return level;
	}
	
}
