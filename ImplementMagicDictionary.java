/**
 * 
 *  676. Implement Magic Dictionary 
 *  
 *  
 *  

Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:

Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False

Note:

    You may assume that all the inputs are consist of lowercase letters a-z.
    For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
    Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.


 * @author abhigupta
 *
 */

class Trie {
    
    Trie childs[] = new Trie[26];
    boolean isEnd = false;
}

public class ImplementMagicDictionary {    

    Trie root = null;

    /** Initialize your data structure here. */
    public ImplementMagicDictionary() {
        root = new Trie();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        
        for(String st : dict){
            addToTrie(root, st.toCharArray(), 0);
        } 
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word == null) {
            return false;
        }
        return search(root, word.toCharArray(), 0, 1);
    }
    
    private boolean search(Trie root, char ch[], int p, int missing) {
        
        if(root == null) {
            return false;
        }

        if(ch.length == p ) {
            return root.isEnd && missing == 0 ? true:false;
        }
        
        Trie child = root.childs[(int)(ch[p]-'a')];
        boolean result = search(child, ch, p+1, missing);
        if(result) {
            return true;
        }
            
        if(missing == 0) {
            return false;
        }
        for(int i=0;i<root.childs.length;i++) {

            if(root.childs[i] != child && search(root.childs[i], ch, p+1, missing-1)) {
                return true;
            }
        }
        return false;
        
    }
    
    private Trie addToTrie(Trie root, char ch[], int p) {
        
        if(root == null || ch.length == p) {
            return null;
        }
        
        Trie child = root.childs[(int)(ch[p]-'a')];
        
        if(child == null) {
            child = new Trie();
            root.childs[(int)(ch[p]-'a')] = child;
        }
        
        Trie t = addToTrie(child, ch, p+1);
        if(t == null) {
            child.isEnd = true;
        }
        return child;
        
    }
    
}

/**
* Your MagicDictionary object will be instantiated and called as such:
* MagicDictionary obj = new MagicDictionary();
* obj.buildDict(dict);
* boolean param_2 = obj.search(word);
*/
