
public class TreeFromIfElse {

	
	
	
	public TreeNode createTree(String st, int p[]) {
		
		if(st.length() <= p[0]) {
			return null;
		}
		TreeNode root = new TreeNode(Character.getNumericValue(st.charAt(p[0]++)));
		if(p[0] == st.length() || st.charAt(p[0]) == ':') {
			return root;
		}
		p[0]++;
		root.left = createTree(st, p);
		p[0]++;
		if(p[0] == st.length()) {
			return root ;
		}
		root.right = createTree(st, p);
		return root;
		
	}
	
	
	public static void main(String st[]) {
		
		TreeNode root = new TreeFromIfElse().createTree("1?2:3?4:5?6:7", new int[1]);
		root.print();
		System.out.println(root);
		
	}
	
}
