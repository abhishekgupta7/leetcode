import java.util.LinkedList;
import java.util.List;

/**
 * 68. Text Justification
 * 
 * https://leetcode.com/problems/text-justification/
 * 
 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Note: Each word is guaranteed not to exceed L in length. 
 * @author abhigupta
 *
 */
public class TextJustification {
	

    public List<String> fullJustify(String[] words, int maxWidth) {
        
        
    List<String>  r = new LinkedList<>();
    
    
    if(words == null || words.length ==0) {
        return r;
    }
    
    
    int s = 0;
    int tlen = words[0].length()+1;
    
    
    for(int i =1;i<words.length ;i++) {
        
        if(tlen+words[i].length() > maxWidth) {
            
            addStrings(words, s,i-1, r, maxWidth);
            s = i;
            tlen = words[i].length()+1;
        }else {
            
            tlen += words[i].length()+1;
        }
        
        
    }
    
    addStrings(words, s,words.length -1, r, maxWidth);

    return r;
    }
    
    void addStrings(String words[], int s, int e , List<String>   r, int w) {
        
        if(e<s) {
            return;
        }
        StringBuffer sb = new StringBuffer();
        int ts = s;
        int wl = 0;
        while(ts <= e) {
            wl = wl+ words[ts++].length();
        }
        //System.out.println(s+" "+e);
        if(s != e && e!= words.length-1 ) {
            
            
            int gap = (w- wl)/(e-s);
            int extra = (w-wl) - (gap*(e-s));
            
            for(int i =s ;i<=e-1;i++) {
                
                sb.append(words[i]);
                int j =0;
                while(j<gap){
                    sb.append(' ');
                    j++;
                }
                if(extra>0) {
                    sb.append(' ');
                    extra--;
                }
                
            }
            sb.append(words[e]);
            
        }else{
            
            while(true) {
                
                sb.append(words[s++]);
                if(s>e) {
                    break;
                }
                 sb.append(' ');
            }
            
            
            while(sb.length() != w) {
                sb.append(' ');
            }
        }
        r.add(sb.toString());
        
    }


}
