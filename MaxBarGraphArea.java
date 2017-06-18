import java.util.Stack;

public class MaxBarGraphArea {

	public int getMaxArea(int a[]) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int max = 0;
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i <= a.length; i++) {
			
			int val = 0;
			int curP = i;
			if(i <a.length){
				val = a[i];
			}
			if (s.isEmpty() || a[s.peek()] <= val) {
				s.push(i);
			} else {
				while (!s.isEmpty() && a[s.peek()] > val) {
					int preP = s.pop();
					max = Math.max(max, (s.isEmpty() ? i : i - 1 - s.peek()) * a[preP]);
				}
				s.push(i);
			}

		}
		

		return max;
	}
	
	public static void main(String st[]) {
		
		MaxBarGraphArea compute = new MaxBarGraphArea();
		
		System.out.println(compute.getMaxArea(new int[]{1,2,1,2,3,4,1}));
		System.out.println(compute.largestRectangleArea(new int[]{1,2,1,2,3,4,1}));

		
	}
	
	public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

}
