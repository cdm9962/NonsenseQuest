package model.map;

/**
 * Class for the dirt path squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class DirtPathSquare extends Square {
    // Constant square characters
    public static final char VERTICAL_DIRT_PATH_SQUARE_CHARACTER = '|';
    public static final char HORIZONTAL_DIRT_PATH_SQUARE_CHARACTER = '-';
    public static final char TOP_LEFT_DIRT_PATH_SQUARE_CHARACTER = 'q';
    public static final char TOP_RIGHT_DIRT_PATH_SQUARE_CHARACTER = 'w';
    public static final char BOTTOM_RIGHT_DIRT_PATH_SQUARE_CHARACTER = 'e';
    public static final char BOTTOM_LEFT_DIRT_PATH_SQUARE_CHARACTER = 'r';
    public static final char INTERSECTION_DIRT_PATH_SQUARE_CHARACTER = '+';

    // Constant file paths
    public static final String VERTICAL_DIRT_PATH_FILE = "/images/squares/dirtpathvert.png";
    public static final String HORIZONTAL_DIRT_PATH_FILE = "/images/squares/dirtpathhorz.png";
    public static final String TOP_LEFT_DIRT_PATH_FILE = "/images/squares/dirtpathtopleft.png";
    public static final String TOP_RIGHT_DIRT_PATH_FILE = "/images/squares/dirtpathtopright.png";
    public static final String BOTTOM_RIGHT_DIRT_PATH_FILE = "/images/squares/dirtpathbottomright.png";
    public static final String BOTTOM_LEFT_DIRT_PATH_FILE = "/images/squares/dirtpathbottomleft.png";
    public static final String INTERSECTION_DIRT_PATH_FILE = "/images/squares/dirtpathintersection.png";

    // Constant square descriptors
    public static final String DIRT_PATH_SQUARE_NAME = "Path";
    public static final String DIRT_PATH_SQUARE_DESCRIPTION = "A basic paved path.";

    /**
     * Dirt Path Square constructor.
     * @param row int representing the row location of the square
     * @param col int representing the column location of the square
     * @param filename String representing the image filename
     * @param containsCharacter boolean to determine if the square holds the character
     * @param containsEnemy boolean to determine if the square holds an enemy
     */
    public DirtPathSquare(int row, int col, String filename, boolean containsCharacter, boolean containsEnemy) {
        super(row, col, filename, DIRT_PATH_SQUARE_NAME, DIRT_PATH_SQUARE_DESCRIPTION, false, containsCharacter, containsEnemy, null);
    }
}
