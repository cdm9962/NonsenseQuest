package model.map;

/**
 * Class for the dirt squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class DirtSquare extends Square {
    // Constant square values
    public static char DIRT_SQUARE_CHARACTER = '/';
    public static String DIRT_SQUARE_NAME = "Dirt";
    public static String DIRT_SQUARE_DESCRIPTION = "This area looks to be well traveled.";
    public static String DIRT_SQUARE_FILE = "/images/squares/dirt.png";

    /**
     * Dirt Square constructor.
     * @param row int representing the row location of the square
     * @param col int representing the column location of the square
     * @param containsCharacter boolean to determine if the square holds the character
     */
    public DirtSquare(int row, int col, boolean containsCharacter, boolean containsEnemy) {
        super(row, col, DIRT_SQUARE_FILE, DIRT_SQUARE_NAME, DIRT_SQUARE_DESCRIPTION, false, containsCharacter, containsEnemy, null);
    }
}
