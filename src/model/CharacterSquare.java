package model;

/**
 * Class for the character squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class CharacterSquare extends Square {
    public static char CHARACTER_SQUARE_CHARACTER = 'C';
    public static String CHARACTER_SQUARE_NAME = "Character";
    public static String CHARACTER_SQUARE_DESCRIPTION = "This is you.";

    public CharacterSquare() {
        super(CHARACTER_SQUARE_NAME, CHARACTER_SQUARE_DESCRIPTION, false);
    }
}