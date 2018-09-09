/**
 * 302. Smallest Rectangle Enclosing Black Pixels
 * 
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]

and x = 0, y = 2,

Return 6. 
 * @author abhigupta
 *
 */
public class SmallestRectangleEnclosingBlackPixels {


	
	public int minArea(char[][] image, int x, int y) {
	
		if( image == null || image.length ==0 || image[0] == null || image[0].length ==0) {
			return 0;
		}
		int m = image.length-1;
		int n = image[0].length-1;

		int l = getSMaller(0, x, image, n, true);
		int r = getBigger(x,m , image, n, true);

		int u = getSMaller(0, y, image, m, false);

		int d = getBigger(y, n, image, m, false);
	//	System.out.println(l+","+r+","+u+","+d);
		
		return (r-l+1)*(d-u+1);
	
	}
	
	public int getSMaller(int s, int e, char[][] a, int cl, boolean isColumn ) {
		
		int ans = e;
		
		while(s<=e) {
			boolean f = false;
			int m = s+(e-s)/2;
		for(int c=0;c<=cl;c++) {	
			if((isColumn?a[m][c] : a[c][m]) == '1'  ) {
				ans = m;
				e = m-1;
				f = true;
				break;
			}
		}
		if(!f) {
			s = m+1;
		}
			
		}
		return ans;
		
		
	}
	
	public int getBigger(int s, int e, char[][] a, int cl, boolean isColumn ) {
		
		int ans = e;
		
		while(s<=e) {
			boolean f = false;
			int m = s+(e-s)/2;
		for(int c=0;c<=cl;c++) {	
			if((isColumn?a[m][c] : a[c][m]) == '1'  ) {
				ans = m;
				s = m+1;
				f = true;
					break;
			}
		}
		if(!f) {
			
			e = m-1;
		}
			
		}
		return ans;
		
		
	}
	


}
