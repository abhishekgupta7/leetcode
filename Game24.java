import java.util.ArrayList;
import java.util.List;

/**
 * 
 *  679. 24 Game 
 *  
 *  https://leetcode.com/problems/24-game/description/
 *  
 *  

You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:

Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24

Example 2:

Input: [1, 2, 1, 2]
Output: False

Note:

    The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
    Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
    You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.

 * @author abhigupta
 *
 */
public class Game24 {
	
final double eps = 0.001;
    

public static void main(String st[]) {
	
	int a[] = { 6, 4};
	System.out.println(new Game24().judgePoint24(a));
}
    
    List<List<Integer>> getPer(int[] nums, int p) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length -1 == p) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[p]);
            ans.add(l);
            return ans;
        }
        
        List<List<Integer>> r = getPer(nums, p+1); 
        
        for(List<Integer> l : r) {
            
            for(int i =0;i<=l.size();i++) {
                List<Integer> list = new ArrayList<>(l);
                list.add(i,nums[p]);
                ans.add(list);
            }
            
            
        }
        return ans;

         
        
        
    }
    public boolean judgePoint24(int[] nums) {
        
        List<List<Integer>> list = getPer(nums,0);
        
        double n[] = new double[nums.length];
        
        for(List<Integer> l : list) {
            System.out.println(l);
            for(int i =0;i<l.size();i++) {

                n[i] = l.get(i);
            }

            List<Double> ans = getCal(n, 0, n.length-1);

            for(Double n1 : ans) {

                if(Math.abs(n1-24)< eps) {
                    return true;
                }


            }
    }
        return false;
    }
    
    List<Double> getCal(double[] nums, int s, int e) {
        
        if(s>e) {
            return new ArrayList<>();
        }
        List<Double> ans = new ArrayList<>();
        if(s == e) {
            ans.add(nums[e]);
            return ans;
        }
        
        
        for(int i = s;i<e;i++) {
            
            List<Double> l = getCal(nums, s,i);
            List<Double> r = getCal(nums, i+1,e);
            for(double ln : l) {
                for(double rn : r) {
                    
                    ans.addAll(doCal(ln,rn));
                }
            }
        }
        return ans;
        
        
    }
    
    List<Double> doCal(double n1, double n2) {
        
        List<Double> ans = new ArrayList<>(4);    
        
        ans.add(n1+n2);
        ans.add(n1-n2);
        //ans.add(n2-n1);
        ans.add(n1*n2);
        ans.add(n1/n2);
        //ans.add(n2/n1);

        return ans;
    }	
	
	

        
        
        /*
        //List<Double> n2 = new ArrayList<>();
        
        for(int i =0;i<nums.length;i++) {
            
            for(int j =0;j<nums.length;j++) {
                List<Double> n1 = new ArrayList<>();

                if( i != j) {
                    
                    n1.add((double)nums[i]);
                    n1.add((double)nums[j]);
                    
                    List<Double> n2 = new ArrayList<>();
                    List<Double> n3 = new ArrayList<>();

                    for(int k = 0;k<nums.length;k++) {
                        if(k != i && k != j) {
                            n2.add((double)nums[k]);
                            n3.add(0,(double)nums[k]);
                        }
                    }
                    System.out.println(n1.get(0)+"--"+n1.get(1));
                    System.out.println(n2.get(0)+"--"+n2.get(1));
                    System.out.println(n3.get(0)+"--"+n3.get(1));
                    List<List<Double>> r = new ArrayList<>();
                    List<Double> r1 = getResult(n1);
                    r.add(getResult(n2));
                    r.add(getResult(n3));
                    

                    System.out.println("+++++++");
                    for(Double d1 : r1) {
                    	for(List<Double> r2 : r) {
                    		for(Double d2 : r2) {
                    			
                                List<Double> r3 = new ArrayList<>();
                                r3.add(d1);
                                r3.add(d2);
                                List<Double> r4 = getResult(r3);
                                for(Double ans :r4) {
                                	if(Math.abs(ans- 24) < 1e-6) {
                                        return true;
                                	}
                                }
                                r3 = new ArrayList<>();
                                r3.add(d2);
                                r3.add(d1);
                                r4 = getResult(r3);
                                for(Double ans :r4) {
                                	if(Math.abs(ans- 24) < 1e-6) {
                                        return true;
                                	}
                                }
                             } 
                    	}
                       
                    }
                    
                }
            
            
            }
            
        }
        return false;
        
    }
    List<Double> getResult(List<Double> d) {
        List<Double> r = new ArrayList<>();
        
        r.add(d.get(0)+ d.get(1));
         r.add(d.get(0) * d.get(1));
         r.add(d.get(0)- d.get(1));
        if(d.get(1) != 0) {
            r.add(d.get(0) /d.get(1));
        }
        return r;
        
    }
    
    public static void main(String st[]) {
    	
    	int a[] = {1,3, 6, 4};
    	System.out.println(new Game24().judgePoint242(a));
    }
    
    public boolean judgePoint242(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        for (int v: nums) A.add((double) v);
        return solve(A);
    }
    private boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) return false;
        if (nums.size() == 1) {
        	System.out.println(1e-6);
        	return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<Double>();
                    for (int k = 0; k < nums.size(); k++) if (k != i && k != j) {
                        nums2.add(nums.get(k));
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }*/

}
