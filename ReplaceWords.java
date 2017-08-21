/**
 * 
 * https://leetcode.com/problems/replace-words/description/
 *  648. Replace Words 
 *  In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Note:

    The input will only have lower-case letters.
    1 <= dict words number <= 1000
    1 <= sentence words number <= 1000
    1 <= root length <= 100
    1 <= sentence words length <= 1000

 * @author abhigupta
 *
 */
public class ReplaceWords {
	
    

class Trie {
    
    Trie[] child ;
    
    boolean isWord;
   
    Trie() {
        child = new Trie[27];
    }
    
}
    Trie root = new Trie();
    public String replaceWords(List<String> dict, String sentence) {
        
        
        if(dict == null || sentence == null) {
            return null;
        }
        for(String s : dict) {
            
            addToTrie(s,0, root);
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        for(String s : sentence.split(" ")) {
            
            String f = find(s, root, 0);
            
            if(f != null) {
                sb.append(f);
            }else {
                sb.append(s);
            }
            sb.append(" ");
            
        }
        return sb.toString().trim();
        
    }
    
    
    Trie addToTrie(String st, int p, Trie root) {
        if(st == null || st.length() == p) {
            return null;
        }
        char ch = st.charAt(p);
        if(root.child[ch-'a'] == null) {
            root.child[ch-'a'] = new Trie();
        }
        Trie t = addToTrie(st,p+1, root.child[ch-'a']);
        if(t == null) {
            root.child[ch-'a'].isWord = true;
        }
        return root;
    }
    
    String find(String st, Trie root, int p) {
        
        if(st == null || root == null) {
            return null;
        }
        if(st.length() == p) {
            return null;
        }
        Trie child = root.child[st.charAt(p)-'a'];
        if(child == null) {
            return null;
        }
        if(child.isWord) {
            return st.substring(0,p+1);
        }
        
        return find(st,child,p+1);
        
        
        
    }
    
    
    

}
