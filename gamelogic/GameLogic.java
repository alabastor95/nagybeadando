package beadando.gamelogic;


import beadando.Action;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class GameLogic extends Thread{
    /**
     * The cube class represents a cube in the playing field matrix.
     */
    public class Cube{
        /**
         * gives the cubes x coordinate
         */
        protected final int X;
        /**
         * gives the cubes y coordinate
         */
        protected final int Y;
        /**
         * Gives back who is the owner of the cube.
         *
         * <p>0 - No-one owns the cube</p>
         * <p>1-6 -Someone from the players owns the cube</p>
         */
        protected Integer owner;
        /**
         * Is this a whole?
         */
        protected Boolean whole = false;

        /**
         * Creates a cube variable
         * @param x The x coordinate of the cube
         * @param y The y coordinate of the cube
         * @param owner The owner of the cube
         */
        public Cube(int x, int y, Integer owner) {
            this.X = x;
            this.Y = y;
            this.owner = owner;
        }

        /**
         * Gives back the X coordinate of the cube
         * @return  The X coordinate of the cube
         */
        public int getX() {
            return X;
        }

        /**
         * Gives back the Y coordinate of the cube
         * @return  The Y coordinate of the cube
         */
        public int getY() {
            return Y;
        }

        /**
         * Gives back the owner of the cube.
         * @return  The owner of the cube.
         */
        public Integer getOwner() {
            return owner;
        }

        /**
         * Gives back if the cube is a whole.
         * @return true - if it's a whole; false - if it's not a whole
         */
        public Boolean getWhole() {
            return whole;
        }

        /**
         * Sets the owner of the cube.
         * @param owner Gives the cube the ID of the owner.
         */
        public void setOwner(Integer owner) {
            this.owner = owner;
        }

        /**
         * Changes the cubes whole parameter.
         * @param whole true - if it's a whole; false - if it's not a whole
         */
        public void setWhole(Boolean whole) {
            this.whole = whole;

        }
    }

    /**
     * Game size in the X direction
     */
    public final static int GAME_SIZE_X = 600;
     /**
     * Game size in the Y direction
     */
     public final static int GAME_SIZE_Y = 400;


    /**
     * Create a matrix from gamecubes.
     */
    Cube[][] gameBoard;
    /**
     * stores the heads of the snakes
     */
    Cube[] heads;
    /**
     * stores the directions of the snakes
     */
    Action[] direction;

    /**
     * Stores the message that we send.
     */
    Cube[] message;

    /**
     * Initializes a clean board and generates unique random locations for starting to the players.
     * In addition initializes the array where we store the heads of the snake and the array where we
     * store the directions of the snakes. This later is initializes with forward movement.
     * @param playerNumber Symbolizes the number of the players.
     */
    public GameLogic(int playerNumber) {
        gameBoard = new Cube[GAME_SIZE_X][GAME_SIZE_Y];
        heads = new Cube[playerNumber];
        direction = new Action[playerNumber];

        for (int i = 0; i <GAME_SIZE_X ; i++) {
            for (int j = 0; j <GAME_SIZE_Y ; j++) {
                gameBoard[i][j] = new Cube(i,j,0);
            }
        }
        Boolean freeSpace = false;
        for (int i = 0; i <playerNumber ; i++) {
            int randx = 0;
            int randy = 0;
            while(!freeSpace)
            {
                randx = ThreadLocalRandom.current().nextInt(GAME_SIZE_X);
                randy = ThreadLocalRandom.current().nextInt(GAME_SIZE_Y);
                if(gameBoard[randx][randy].getOwner() == 0)
                    freeSpace = true;
            }
            freeSpace = false;
            gameBoard[randx][randy].setOwner(i);
            heads[i] = gameBoard[randx][randy];
            direction[i] = Action.FORWARD;
        }
    }

    @Override
    public void run() {
        while(!Thread.interrupted())
        {

        }
    }

    //TODO
    public static void main(String[] args) {

    }
}
