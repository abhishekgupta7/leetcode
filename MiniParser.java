import java.util.ArrayList;
import java.util.List;

class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;
    
    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }
    
    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }
    
    public String printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            }
            else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
public class MiniParser {
	public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if (s.length() == 0) return res;
        if (s.charAt(0) != '[') {
            res.setInteger(Integer.parseInt(s));
            return res;
        }
        helper(res, s);
        return res;
    }
    
    public void helper(NestedInteger res, String s) {
        for (int i = 1; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '[') {
                int start = i;
                int count = 1;
                while (count != 0) {
                    i++;
                    if (s.charAt(i) == ']') count--;
                    if (s.charAt(i) == '[') count++;
                }
                NestedInteger temp = new NestedInteger();
                helper(temp, s.substring(start, i + 1));
                res.add(temp);
            }
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                int start = i;
                while (s.charAt(i) != ',' && s.charAt(i) != ']') i += 1;
                res.add(new NestedInteger(Integer.parseInt(s.substring(start, i))));
            }
        }
    }
	
	public static void main(String st[]) {
		
		System.out.println( new MiniParser().deserialize("[123,[456,[789]]]"));
	}
}
