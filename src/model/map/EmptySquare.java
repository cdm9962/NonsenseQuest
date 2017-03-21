package model.map;

/**
 * Class for the empty squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class EmptySquare extends Square {
    // Constant square values
    public static char EMPTY_SQUARE_CHARACTER = '.';
    public static String EMPTY_SQUARE_NAME = "Empty";
    public static String EMPTY_SQUARE_DESCRIPTION = "There is seemingly nothing here.";

    /**
     * Empty Square constructor.
     */
    public EmptySquare() {
        super(EMPTY_SQUARE_NAME, EMPTY_SQUARE_DESCRIPTION, false);
    }
}