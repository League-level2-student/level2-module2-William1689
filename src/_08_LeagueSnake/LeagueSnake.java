package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */


int applesEaten = 0;
int direction = UP;
int foodX;
int foodY;
Segment head;
ArrayList <Segment> tail = new ArrayList<>();
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        setSize(1000, 1000);
       
    }

    @Override
    public void setup() {
        head = new Segment(500,500);
        frameRate(20);
        dropFood();
      
       
        
    }
//    void pauseGame() {
//    	if(keyCode == 49) {
//    		head.x = 40        ;
//    		head.y = 40;
//    	}
//    }
    void dropFood() {
        // Set the food in a new random location
    	foodX = ((int)random(50)*20);
    	foodY = ((int)random(50)*20);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {  
    	move();
       background(50, 168, 82);
       drawFood();
       drawSnake();
     
       eat();
       fill(0,0,0);
       textSize(20);
       text("Score: "+applesEaten, 20,20);
       
    }

    void drawFood() {
        // Draw the food
        fill(219, 13, 13);
        rect(foodX,foodY,20,20);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(19, 16, 224);
    	rect(head.x,head.y,20,20);
    	drawTail();
    	manageTail();
    }

    void drawTail() {
        // Draw each segment of the tail
        fill(19,16,224);
        for(Segment s: tail) {
        	rect(s.x,s.y,20,20);
        }
      
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
    	checkTailCollision();
    	drawTail();
    	tail.add(new Segment(head.x,head.y));
    	tail.remove(0);
    	
    	
    	
    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
    	
    	
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
        

        if(keyCode == UP && direction != DOWN) {
        	direction = UP;
        }
        
        if(keyCode == DOWN && direction != UP) {
        	direction = DOWN;
        }
        if(keyCode == RIGHT && direction != LEFT) {
        	direction = RIGHT;
        }
        if(keyCode == LEFT && direction != RIGHT) {
        	direction = LEFT;
        }
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (direction == UP) {
            head.y-=20;
            checkBoundaries();
        } else if (direction == DOWN) {
          head.y+=20;
               checkBoundaries(); 
        } else if (direction == LEFT) {
            head.x-=20;
            checkBoundaries(); 
        } else if (direction == RIGHT) {
            head.x+=20;
            checkBoundaries(); 
        }
        
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(head.y>980) {
        	System.exit(0);
        }
        if(head.y<0) {
        	System.exit(0);
        }
        if(head.x>980) {
        	System.exit(0);
        }
        if(head.x<0) {
        	System.exit(0);
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
    	if(head.y == foodY && head.x == foodX) {
    		dropFood();
    		applesEaten++;
    		tail.add(new Segment(head.x,head.y));
    	}
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
    }
