package model.map;

/**
 * Class for the  dirt road squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class DirtRoadSquare extends Square {
    // Constant square values
    public static char STRAIGHT_DIRT_ROAD_SQUARE_CHARACTER = '|';
    public static char TOP_LEFT_DIRT_ROAD_SQUARE_CHARACTER = 'q';
    public static char TOP_RIGHT_DIRT_ROAD_SQUARE_CHARACTER = 'w';
    public static char BOTTOM_RIGHT_DIRT_ROAD_SQUARE_CHARACTER = 'e';
    public static char BOTTOM_LEFT_DIRT_ROAD_SQUARE_CHARACTER = 'r';

    public static String STRAIGHT_DIRT_ROAD_FILE = "file:dirtpathvert.png";
    public static String TOP_LEFT_DIRT_ROAD_FILE = "file:dirtpathtopleft.png";
    public static String TOP_RIGHT_DIRT_ROAD_FILE = "file:dirtpathtopright.png";
    public static String BOTTOM_RIGHT_DIRT_ROAD_FILE = "file:dirtpathbottomright.png";
    public static String BOTTOM_LEFT_DIRT_ROAD_FILE = "file:dirtpathbottomleft.png";

    public static String DIRT_ROAD_SQUARE_NAME = "Road";
    public static String DIRT_ROAD_SQUARE_DESCRIPTION = "A basic paved path.";

    /**
     * Dirt Road Square constructor.
     */
    public DirtRoadSquare(String filename, boolean containsCharacter) {
        super(filename, DIRT_ROAD_SQUARE_NAME, DIRT_ROAD_SQUARE_DESCRIPTION, false, containsCharacter, null);
    }
}
