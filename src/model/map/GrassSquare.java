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

    /**
     * Grass Square constructor.
     */
    public GrassSquare() {
        super(GRASS_SQUARE_NAME, GRASS_SQUARE_DESCRIPTION, false);
    }
}