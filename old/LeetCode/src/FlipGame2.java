/**
 * 
 * 294. Flip Game II
 * 
 * https://leetcode.com/problems/flip-game-ii/
 *  You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity. 
 * 
 * @author abhigupta
 *
 */
public class FlipGame2 {

    public boolean canWin(String s) {
        
        
        
        return canWin(s.toCharArray());
        
    }
    
    
    public boolean canWin(char [] st) {
        
        
        for(int i =0;i<st.length-1; i++) {
            
            if(st[i]== '+' && st[i+1] == '+' ) {
                
              
                st[i] ='-';
                st[i+1] ='-';
                
                boolean r = !canWin(st);
                
              
               st[i] ='+';
                st[i+1] ='+';
                if(r) return true;
            }
            
            
        }
        
        return  false;
        
    }

}
