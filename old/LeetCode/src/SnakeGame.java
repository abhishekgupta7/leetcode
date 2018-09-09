import java.util.LinkedList;

/**
 * 
 * 353. Design Snake Game
 * 
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

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



https://leetcode.com/problems/design-snake-game/
 * @author abhigupta
 *
 */




public class SnakeGame {
	

	class Position {
	    
	    int x;
	    int y;
	    
	    
	    Position(int x, int y ) {
	        this.x = x;
	        this.y = y;
	    }
	    boolean isEqual(Position p){
	    //System.out.println("=="+p);

	        return p.x == this.x && p.y == this.y;
	    }
	    public String toString() {
	        return x+","+y;
	    }
	    
	}

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        
        LinkedList<Position> snakep = new LinkedList<>();
        int fp =0;
        int l = 0;
        int h =0;
        int w =0;
        int f[][] =null;
    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        f = food;
       snakep.add(new Position(0,0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        
        
        Position p = new Position(snakep.getFirst().x, snakep.getFirst().y);
        
        
        if(direction.equals("U")) {
            p.y--;
            
        }
        if(direction.equals("L")) {
            p.x--;
            
        }
        if(direction.equals("R")) {
            p.x++;
        }
        if(direction.equals("D")) {
           p.y++;
        }
         snakep.add(0,p);
        if(validate(p)) {
            l =0;
            return -1;
        }
       // System.out.println(direction);
        //System.out.println(p);

        for(int i =1;i<snakep.size()-1;i++) { // tricky
            if(p.isEqual(snakep.get(i))) {
                return -1;
            }
            
        }
       

        if(fp<f.length && p.isEqual(new Position(f[fp][1], f[fp][0]))) { 
            l++;
            fp++;    
        }else {
            snakep.removeLast();

        }
        
    
        return l;
        
    }
    private boolean validate(Position p) {

        return (p.x<0 || p.y>= h || p.y<0 || p.x>=w);
        
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
