package model.map;

/**
 * Class for the road squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class RoadSquare extends Square {
    // Constant square values
    public static char ROAD_SQUARE_CHARACTER = '|';
    public static String ROAD_SQUARE_NAME = "Road";
    public static String ROAD_SQUARE_DESCRIPTION = "A basic paved path.";

    /**
     * Road Square constructor.
     */
    public RoadSquare() {
        super(ROAD_SQUARE_NAME, ROAD_SQUARE_DESCRIPTION, false);
    }
}
