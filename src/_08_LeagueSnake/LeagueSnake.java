package _08_LeagueSnake;

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
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        setSize(500, 500);
    }

    @Override
    public void setup() {
        head = new Segment(250,250);
        frameRate(20);
        dropFood();
       
        
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = ((int)random(50)*10);
    	foodY = ((int)random(50)*10);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
       background(50, 168, 82);
       drawFood();
       drawSnake();
       move();
    }

    void drawFood() {
        // Draw the food
        fill(219, 13, 13);
        rect(foodX,foodY,30,30);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(19, 16, 224);
    	rect(head.x,head.y,30,30);
    }

    void drawTail() {
        // Draw each segment of the tail
        
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
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (direction == UP) {
            head.y-=10;
            checkBoundaries();
        } else if (direction == DOWN) {
          head.y+=10;
               checkBoundaries(); 
        } else if (direction == LEFT) {
            head.x+=10;
            checkBoundaries(); 
        } else if (direction == RIGHT) {
            head.x-=10;
            checkBoundaries(); 
        }
        
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(head.y>=500) {
        	System.exit(0);
        }
        if(head.y<=30) {
        	System.exit(0);
        }
        if(head.x>=500) {
        	System.exit(0);
        }
        if(head.x<=30) {
        	System.exit(0);
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
    }
