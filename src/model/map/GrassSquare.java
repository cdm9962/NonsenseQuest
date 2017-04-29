package model.map;

/**
 * Class for the grass squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class GrassSquare extends Square {
    // Constant square values
    public static char GRASS_SQUARE_CHARACTER = '.';
    public static String GRASS_SQUARE_NAME = "Grass";
    public static String GRASS_SQUARE_DESCRIPTION = "A nice patch of soft grass.";
    public static String GRASS_SQUARE_FILE = "/images/squares/grass.png";

    /**
     * Grass Square constructor.
     * @param row int representing the row location of the square
     * @param row int representing the column location of the square
     * @param containsCharacter boolean to determine if the square holds the character
     */
    public GrassSquare(int row, int col, boolean containsCharacter, boolean containsEnemy) {
        super(row, col, GRASS_SQUARE_FILE, GRASS_SQUARE_NAME, GRASS_SQUARE_DESCRIPTION, false, containsCharacter, containsEnemy, null);
    }
}
