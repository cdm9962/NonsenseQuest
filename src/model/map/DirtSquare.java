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

    /**
     * Dirt Square constructor.
     */
    public DirtSquare() {
        super(DIRT_SQUARE_NAME, DIRT_SQUARE_DESCRIPTION, false);
    }
}
