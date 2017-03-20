package model.map;

/**
 * Class for the character squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class CharacterSquare extends Square {
    // Constant square values
    public static char CHARACTER_SQUARE_CHARACTER = 'C';
    public static String CHARACTER_SQUARE_NAME = "Character";
    public static String CHARACTER_SQUARE_DESCRIPTION = "This is you.";

    /**
     * Character Square constructor.
     */
    public CharacterSquare() {
        super(CHARACTER_SQUARE_NAME, CHARACTER_SQUARE_DESCRIPTION, false);
    }
}