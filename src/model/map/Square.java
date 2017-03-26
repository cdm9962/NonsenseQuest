package model.map;

/**
 * Abstract class for the map squares.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Square {
    // The private state of the map square
    private int row;
    private int col;
    private String filename;
    private String name;
    private String description;
    private boolean isAdjacent;
    private boolean containsCharacter;
    private Character enemy;

    // Character square constants
    public static char CHARACTER_SQUARE_CHARACTER = 'C';
    public static String CHARACTER_SQUARE_NAME = "Character";
    public static String CHARACTER_SQUARE_DESCRIPTION = "This is you.";

    /**
     * Square constructor.
     * @param row int representing the row location of the square
     * @param col int representing the column location of the square
     * @param filename String representing the image filename for the square
     * @param name String representing the name of the square
     * @param description String representing the description of the square
     * @param isAdjacent boolean representing if the square is adjacent to the character
     * @param containsCharacter boolean to determine if the square holds the character
     * @param enemy Character that represents an enemy of the board
     */
    public Square(int row, int col, String filename, String name, String description, boolean isAdjacent, boolean containsCharacter, Character enemy){
        this.row = row;
        this.col = col;
        this.filename = filename;
        this.name = name;
        this.description = description;
        this.isAdjacent = isAdjacent;
        this.containsCharacter = containsCharacter;
        this.enemy = enemy;
    }

    /**
     * Getter method for the square description.
     * @return String representing the square description
     */
    public String getDescription(){
        if(this.isAdjacent){
            return "You can move to this square.";
        } else if (this.containsCharacter) {
            return "You are here.";
        } else {
            return this.description;
        }
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
     * Getter method for the stage map filename.
     * @return String representing the stage map filename
     */
    public String getFilename(){
        return this.filename;
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
}
