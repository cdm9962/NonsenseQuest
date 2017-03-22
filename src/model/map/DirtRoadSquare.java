package model.map;

/**
 * Class for the  dirt road squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class DirtRoadSquare extends Square {
    // Constant square values
    public static char DIRT_ROAD_SQUARE_CHARACTER = '|';
    public static String DIRT_ROAD_SQUARE_NAME = "Road";
    public static String DIRT_ROAD_SQUARE_DESCRIPTION = "A basic paved path.";

    /**
     * Dirt Road Square constructor.
     */
    public DirtRoadSquare() {
        super(DIRT_ROAD_SQUARE_NAME, DIRT_ROAD_SQUARE_DESCRIPTION, false);
    }
}
