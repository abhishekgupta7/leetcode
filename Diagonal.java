import java.util.LinkedList;
import java.util.List;

public class Diagonal {

	
	
	public static void main(String st[]) {
		
		
		
		
		
	}
	
	List<Integer> getList(int [][] mat) {
	
		List<Integer> ans = new LinkedList<>();
		boolean up = true;
		for(int i =0;i<mat.length;i++) {
			int ii = i;
			int j = 0;
			while(ii>=0) {
				if(up)
					ans.add(mat[ii][j++]);
				else
					ans.add(0,mat[ii][j++]);
			}
			
			up = !up;
			
		}
		
		for(int j =1;j<mat[0].length;j++) {
			int jj = j;
			int i = mat.length-1;
			while(jj<mat[0].length) {
				if(up)
					ans.add(mat[i--][jj++]);
				else
					ans.add(0,mat[i--][jj++]);
			}
			
			up = !up;
			
		}
		return ans;
		
		
	}
	
	
}

