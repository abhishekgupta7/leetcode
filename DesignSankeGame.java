import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-snake-game/description/
 * @author abhigupta
 *Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.
 */
public class DesignSankeGame {
	
    /** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

Deque<int[]> snake = new java.util.LinkedList<>();
Set<String> set = new HashSet<>();
int fp = 0;
int m = 0;
int n = 0;
int food[][];
public DesignSankeGame(int width, int height, int[][] food) {
    this.food = food;
    m = height;
    n = width;
    snake.add(new int[] {0,0});
    set.add(""+0+"-"+0);
}

/** Moves the snake.
    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
    @return The game's score after the move. Return -1 if game over. 
    Game over when snake crosses the screen boundary or bites its body. */
public int move(String direction) {
    
    int fr[] = snake.getFirst();
    int front[]  = new int[] {fr[0], fr[1]};
    switch(direction) {
            
        case "U" :
            front[0]--;
            break;
        case "D" :
            front[0]++;
            break;
        case "L" :
            front[1]--;
            break;
        case "R" :
            front[1]++;
            
    }
    
    if(IsInValid(front)) {
        return -1;
    }
    if(!(front[0] == snake.getLast()[0] && front[1] == snake.getLast()[1]) &&(set.contains(front[0]+"-"+front[1]))) {
        return -1;
    }
    if(fp<food.length && front[0]== food[fp][0] && front[1]== food[fp][1]) {
        fp++;
    }else {
        int f[] = snake.removeLast();
        set.remove(f[0]+"-"+f[1]);
 
    }
    snake.addFirst(new int[] {front[0], front[1]});
    set.add(front[0]+"-"+front[1]);
    return snake.size()-1;
    
}

boolean IsInValid(int fp[]) {
    
    return (fp[0]>=m || fp[1]>=n || fp[0]<0 || fp[1]<0) ;
}


}
