package model.map;

import model.Player;

/**
 * Abstract class for the map squares.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Square {
    // The private state of the map square
    private int row;
    private int col;
    private String imageFilename;
    private String name;
    private String description;
    private boolean isAdjacent;
    private boolean containsCharacter;
    private boolean containsEnemy;
    private Player enemy;

    // Character square constants
    public static final char CHARACTER_SQUARE_CHARACTER = 'C';
    public static final String CHARACTER_SQUARE_NAME = "Character";
    public static final String CHARACTER_SQUARE_DESCRIPTION = "This is you.";
    public static final char ENEMY_SQUARE_CHARACTER = 'E';
    public static final String ENEMY_SQUARE_NAME = "Enemy";
    public static final String ENEMY_SQUARE_DESCRIPTION = "He looks pretty scary";

    /**
     * Square constructor.
     * @param row int representing the row location of the square
     * @param col int representing the column location of the square
     * @param imageFilename String representing the image imageFilename for the square
     * @param name String representing the name of the square
     * @param description String representing the description of the square
     * @param isAdjacent boolean representing if the square is adjacent to the character
     * @param containsCharacter boolean to determine if the square holds the character
     * @param containsEnemy boolean to determine if the square holds an enemy
     * @param enemy Character that represents an enemy of the board
     */
    public Square(int row, int col, String imageFilename, String name, String description, boolean isAdjacent, boolean containsCharacter,
                  boolean containsEnemy, Player enemy){
        this.row = row;
        this.col = col;
        this.imageFilename = imageFilename;
        this.name = name;
        this.description = description;
        this.isAdjacent = isAdjacent;
        this.containsCharacter = containsCharacter;
        this.containsEnemy = containsEnemy;
        this.enemy = enemy;
    }

    /**
     * Getter method for the square description.
     * @return String representing the square description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Method to toggle if a square is adjacent to a character.
     */
    public void toggleIsAdjacent(){
        this.isAdjacent = !this.isAdjacent;
    }

    /**
     * Getter method to check for character adjacency.
     * @return boolean to determine if the square is adjacent to the character
     */
    public boolean getIsAdjacent(){
        return this.isAdjacent;
    }

    /**
     * Getter method for the stage map imageFilename.
     * @return String representing the stage map imageFilename
     */
    public String getImageFilename(){
        return this.imageFilename;
    }

    /**
     * Getter method to check if a square holds an enemy.
     * @return boolean to determine if the square holds and enemy
     */
    public boolean containsEnemy(){
        return this.enemy != null;
    }

    /**
     * Getter method to check if a square contains the player's character.
     * @return boolean to determine if the square contains the player's character
     */
    public boolean isContainsCharacter(){
        return this.containsCharacter;
    }

    /**
     * Method to toggle if a square contains the player's character.
     */
    public void togleContainsCharacter(){
        this.containsCharacter = !this.containsCharacter;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isContainsEnemy() {
        return this.containsEnemy;
    }

    public void setContainsEnemy(boolean containsEnemy) {
        this.containsEnemy = containsEnemy;
    }

    public void toggleIsEnemy(){
        this.containsEnemy = !this.containsEnemy;
    }

    public Player getEnemy() {
        return enemy;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }

    public void createEnemy() {
        this.enemy = new Player("Guard", "Human", "Warrior");
    }
}