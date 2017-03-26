package model.map;

/**
 * Class for the dirt path squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class DirtPathSquare extends Square {
    // Constant square characters
    public static char VERTICAL_DIRT_PATH_SQUARE_CHARACTER = '|';
    public static char HORIZONTAL_DIRT_PATH_SQUARE_CHARACTER = '-';
    public static char TOP_LEFT_DIRT_PATH_SQUARE_CHARACTER = 'q';
    public static char TOP_RIGHT_DIRT_PATH_SQUARE_CHARACTER = 'w';
    public static char BOTTOM_RIGHT_DIRT_PATH_SQUARE_CHARACTER = 'e';
    public static char BOTTOM_LEFT_DIRT_PATH_SQUARE_CHARACTER = 'r';

    // Constant file paths
    public static String VERTICAL_DIRT_PATH_FILE = "/resources/images/dirtpathvert.png";
    public static String HORIZONTAL_DIRT_PATH_FILE = "/resources/images/dirtpathhorz.png";
    public static String TOP_LEFT_DIRT_PATH_FILE = "/resources/images/dirtpathtopleft.png";
    public static String TOP_RIGHT_DIRT_PATH_FILE = "/resources/images/dirtpathtopright.png";
    public static String BOTTOM_RIGHT_DIRT_PATH_FILE = "/resources/images/dirtpathbottomright.png";
    public static String BOTTOM_LEFT_DIRT_PATH_FILE = "/resources/images/dirtpathbottomleft.png";

    // Constant square descriptors
    public static String DIRT_PATH_SQUARE_NAME = "Path";
    public static String DIRT_PATH_SQUARE_DESCRIPTION = "A basic paved path.";

    /**
     * Dirt Path Square constructor.
     */
    public DirtPathSquare(String filename, boolean containsCharacter) {
        super(filename, DIRT_PATH_SQUARE_NAME, DIRT_PATH_SQUARE_DESCRIPTION, false, containsCharacter, null);
    }
}
