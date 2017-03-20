package model;

/**
 * Class for the road squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class RoadSquare extends Square {
    public static char ROAD_SQUARE_CHARACTER = '|';
    public static String ROAD_SQUARE_NAME = "Road";
    public static String ROAD_SQUARE_DESCRIPTION = "A basic paved path.";

    public RoadSquare() {
        super(ROAD_SQUARE_NAME, ROAD_SQUARE_DESCRIPTION, false);
    }
}
